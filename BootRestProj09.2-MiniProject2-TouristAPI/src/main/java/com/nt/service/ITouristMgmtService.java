//ITouristMgmtService.java(26.04.2025)
package com.nt.service;

import java.util.List;

import com.nt.entity.Tourist;

public interface ITouristMgmtService{
     public String registerTourist(Tourist tourist);
     public List<Tourist> fetchAllTourists();
     public List<Tourist> showAllTourist(String city1,String city2,String city3);
     public Tourist fetchTouristById(Integer tid) throws TouristNotFoundException;
     public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException;
     public List<Tourist> findAllTouristsByName(String name);
     public String updateTouristBudgetById(int tid,double hikePercentage)throws TouristNotFoundException;
     public String removeTouristById(int tid)throws TouristNotFoundException;
     public String removeTouristByBudgetRange(double start,double end);
}
