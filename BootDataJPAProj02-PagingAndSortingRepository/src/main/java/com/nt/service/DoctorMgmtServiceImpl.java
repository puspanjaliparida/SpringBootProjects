//DoctorMgmtServiceImpl.java(04/05.03.2025)
package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;

@Service
public class DoctorMgmtServiceImpl implements IDoctorMgmtService {

	@Autowired
	private IDoctorRepository doctorRepo;
	
	@Override
	public Iterable<Doctor> showAllDoctorsBySorting(boolean ascOrder, String... props) {
		//Create Sort Object
		Sort sort=Sort.by(ascOrder?Sort.Direction.ASC:Sort.Direction.DESC,props);
		//Use Repository
		Iterable<Doctor> it=doctorRepo.findAll(sort);
		return it;
	}

	@Override
	public Page<Doctor> showAllDoctorsByPageNo(int pageNo, int pageSize) {
		//Create The Pageable Object
		Pageable pageable=PageRequest.of(pageNo,pageSize);
		//Get The Requested Page Records
		Page<Doctor> page=doctorRepo.findAll(pageable);
		return page;
	}

	@Override
	public Page<Doctor> showAllDoctorsByPageNoAsSorted(int pageNo, int pageSize, boolean ascOrder, String... props) {
		Sort sort=Sort.by(ascOrder?Sort.Direction.ASC:Sort.Direction.DESC,props);
		//Create Pageable Object Having Sort Object
		Pageable pageable=PageRequest.of(pageNo,pageSize,sort);
		//Get The Requested Page Records
		Page<Doctor> page=doctorRepo.findAll(pageable);
		return page;
	}

	@Override
	public void showAllDoctorsInPagination(int pageSize) {
         //Get The Count Of Records
		long count=doctorRepo.count();
		//Get Count PagesCount
		long pagesCount=count/pageSize;
		if(count%pageSize!=0)
			pagesCount++;
		
		for(int i=0;i<pagesCount;++i) {
			//Get Pageable Object For Every Page
			Pageable pageable=PageRequest.of(i, pageSize);
			//Get Each Page Records
			Page<Doctor> page=doctorRepo.findAll(pageable);
			//Display Each Page Records
			System.out.println("-------Page No::"+(page.getNumber()+1)+"/"+page.getTotalPages()+"----------Records Are::");
			page.forEach(System.out::println);
			System.out.println("-----------------------");
		}
	}
}
