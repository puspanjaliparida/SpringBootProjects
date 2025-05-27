//IStockMgmtService.java(25.05.2025)
package com.nt.service;

import java.util.List;

import com.nt.document.StockDetails;

public interface IStockMgmtService {
      public String registerStock(StockDetails details);
      public String registerMultipleStocks(List<StockDetails> list);
      public List<StockDetails> showStocksByPriceRange(double start,double end);
      public String updateExchangeByPrice(double start,double end,String newExchange);
      public String registerOrUpdateStock(String name,String exchange,double price);
      public String removeStocksByPrice(double start,double end);
}
