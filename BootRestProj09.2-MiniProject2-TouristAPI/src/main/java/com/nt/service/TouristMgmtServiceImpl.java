//TouristMgmtServiceImpl.java(26.04.2025)
package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Tourist;
import com.nt.repo.ITouristRepo;

@Service
public class TouristMgmtServiceImpl implements ITouristMgmtService {
     @Autowired
     private ITouristRepo touristRepo;
     
	@Override
	public String registerTourist(Tourist tourist) {
		int idVal=touristRepo.save(tourist).getTid();
		return "Tourist Is Registered Having The Id value::"+idVal;
	}

	@Override
	public List<Tourist> fetchAllTourists() {
		List<Tourist> list=touristRepo.findAll();
		list.sort((t1,t2)->t1.getTid().compareTo(t2.getTid()));
		return list;
	}

	@Override
	public List<Tourist> showAllTourist(String city1, String city2, String city3) {
		return touristRepo.findTouristsByCities(city1, city2, city3);
	}

	@Override
	public Tourist fetchTouristById(Integer tid)throws TouristNotFoundException{
		return touristRepo.findById(tid)
				           .orElseThrow(()-> new TouristNotFoundException());
	}

	@Override
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException {
		Optional<Tourist> optional=touristRepo.findById(tourist.getTid());
		if(optional.isPresent()) {
			touristRepo.save(tourist);
			return tourist.getTid()+"Tourist Is Updated";
		}
		else {
			throw new TouristNotFoundException();
		}
	}

	@Override
	public List<Tourist> findAllTouristsByName(String name) {
		return touristRepo.getTouristsByName(name);
	}

	@Override
	public String updateTouristBudgetById(int tid, double hikePercentage) throws TouristNotFoundException {
		//Get The Tourist By Id
		Optional<Tourist> opt=touristRepo.findById(tid);
		if(opt.isPresent()) {
			//Get Existing Budget Of The Tourist
			Tourist tourist=opt.get();
			double budget=tourist.getBudget();
			double newBudget=budget+(budget*hikePercentage/100.0);
			//Update Tourist With New Budget
			tourist.setBudget(newBudget);
			touristRepo.save(tourist);
			return "Tourist Budget Is Hiked ...and the new Budget is"+newBudget;
		}
		else {
			throw new TouristNotFoundException();
		}
	}

	@Override
	public String removeTouristById(int tid) throws TouristNotFoundException {
		//Get The Tourist By Id
		Optional<Tourist> opt=touristRepo.findById(tid);
		if(opt.isPresent()) {
			//Use Repo
			touristRepo.deleteById(tid);
			return tid+"tid Tourist Found and Deleted";
		}
		else {
			throw new TouristNotFoundException();
		}
	}

	@Override
	public String removeTouristByBudgetRange(double start, double end) {
		// Use Repo
		int count=touristRepo.removeTouristsByBudgetRange(start, end);
		return count==0?"Tourists not found for deletion":count+"no. of Tourists are found and deleted";
	}
}
