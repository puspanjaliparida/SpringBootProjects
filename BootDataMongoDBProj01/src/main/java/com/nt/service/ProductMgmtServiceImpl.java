//ProductMgmtServiceImpl.java(24.05.2025)
package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.document.Product;
import com.nt.repository.IProductRepository;

@Service
public class ProductMgmtServiceImpl implements IProductMgmtService{
    @Autowired
    private IProductRepository prodRepo;
    
	@Override
	public String registerProduct(Product prod) {
		//Save The Document
		String idVal=prodRepo.save(prod).getId();
		return "Product is Saved With id value: "+idVal;
	}

	@Override
	public String registerMultipleProducts(List<Product> prods) {
		List<Product> savedProds=prodRepo.saveAll(prods);
		List<String> listIds=savedProds.stream().map(Product::getId).collect(Collectors.toList());
		return "Multiple Products are Saved With id values "+listIds;
	}
	
	@Override
	public List<Product> showAllProducts() {
		return prodRepo.findAll();
	}

	@Override
	public Product showProductById(String id) {
		return prodRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Id"));
	}

	@Override
	public String updatePrice(String pid, float hikePercent) {
		Product prod=prodRepo.findById(pid).orElseThrow(()->new IllegalArgumentException("Invalid Id"));
		prod.setPrice(prod.getPrice()+(prod.getPrice()*hikePercent/100.0f));
		prodRepo.save(prod);
		return pid+" Product details are Updated ";
	}

	@Override
	public String removeProducts(String name, String status) {
		//Prepare Document Class Object having given data
		Product prod=new Product();
		prod.setStatus("active");
		prod.setName("table");
		//Prepare Example Object
		Example<Product> example=Example.of(prod);
		//Get The Documents
		List<Product> list=prodRepo.findAll(example);
		//Delete The Objects
		prodRepo.deleteAll(list);
		return list.size()+" no. of docs are deleted";
	}

	@Override
	public String removeProductById(String idVal) {
		Optional<Product> opt=prodRepo.findById(idVal);
		if(opt.isEmpty())
			return "Document not Found";
		else {
			prodRepo.deleteById(idVal);
			return "Document found are deleted";
		}
	}

	@Override
	public List<Product> showAllProducts(boolean asc, String... properties) {
		//Create the Sort Object
		Sort sort=Sort.by(asc?Direction.ASC:Direction.DESC,properties);
		//Get the docs by Sorting
		List<Product> list=prodRepo.findAll(sort);
		return list;
	}

	@Override
	public String saveProduct(Product p) {
		return "MongoDB Doc is Saved with id value: "+prodRepo.insert(p).getId();
	}
}
