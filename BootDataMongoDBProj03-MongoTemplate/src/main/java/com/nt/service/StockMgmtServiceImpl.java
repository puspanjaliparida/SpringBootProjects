//StockMgmtServiceImpl.java(25.05.2025)
package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.mongodb.client.result.UpdateResult;
import com.nt.document.StockDetails;

@Service
public class StockMgmtServiceImpl implements IStockMgmtService {
    @Autowired
    private MongoTemplate template;
    
	@Override
	public String registerStock(StockDetails details) {
		String idVal=template.save(details).getId();
		return "Stock is Saved with the id value: "+idVal;
	}

	@Override
	public String registerMultipleStocks(List<StockDetails> list) {
		int count=template.insertAll(list).size();
		return count+" no. of docs are saved";
	}

	@Override
	public List<StockDetails> showStocksByPriceRange(double start, double end) {
		//Prepare Query Object
		Query query=new Query();
		query.addCriteria(Criteria.where("price").gte(start).lte(end));
		List<StockDetails> list=template.find(query, StockDetails.class);
		return list;
	}

	@Override
	public String updateExchangeByPrice(double start, double end, String newExchange) {
		//Prepare Query Object
		Query query=new Query();
		query.addCriteria(Criteria.where("price").gte(start).lte(end));
		//Prepare Update Object
		Update update=new Update();
		update.set("exchange", newExchange);
		//Perform Multiple Update
		UpdateResult result=template.updateMulti(query, update, StockDetails.class);
	    return result.getModifiedCount()+" no. of records are updated"; 
	}

	@Override
	public String registerOrUpdateStock(String name, String exchange, double price) {
		//Query Object
		Query query=new Query();
		query.addCriteria(Criteria.where("name").is(name));
		//Prepare Update object
		Update update=new Update();
		update.set("exchange", exchange);
		update.set("price", price);
		update.setOnInsert("name",name);
		//Execute the logics
		UpdateResult result=template.upsert(query, update, StockDetails.class);
		return result.getModifiedCount()==0?"  Document Saved":" Document Updated";
	}

	@Override
	public String removeStocksByPrice(double start, double end) {
		//Prepare Query Object
				Query query=new Query();
				query.addCriteria(Criteria.where("price").gte(start).lte(end));
				//Execute the logics
				int count=template.findAllAndRemove(query,StockDetails.class).size();
		return count+ " no. of docs are Removed";
	}
}
