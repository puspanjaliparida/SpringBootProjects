//PagingAndSortingRepositoryRunner.java(04/05.03.2025)
package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorMgmtService;

@Component
public class PagingAndSortingRepositoryRunner implements CommandLineRunner {

	@Autowired
	private IDoctorMgmtService docService;
	
	@Override
	public void run(String... args) throws Exception {
//		try {
//		//Use docService
//		docService.showAllDoctorsBySorting(true,"docName").forEach(System.out::println);;	
//	    }
//         catch(Exception e) {
//        	 e.printStackTrace();
//         }
//		try {
//			Page<Doctor> page=docService.showAllDoctorsByPageNo(0, 3);
//			System.out.println("1st Page Records Are ::");
//			List<Doctor> list=page.getContent();
//			list.forEach(System.out::println);
//			System.out.println("-----------------------");
//			System.out.println("Requested Page Number ::"+(page.getNumber()+1));
//			System.out.println("Total No. Of Pages ::"+page.getTotalPages());
//			System.out.println("Is It The First Page ::"+page.isFirst());
//			System.out.println("Is It The Last Page ::"+page.isLast());
//			System.out.println("Requested Page Size ::"+page.getSize());
//			System.out.println("No. Of Records In Requested Page ::"+page.getNumberOfElements());
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
		
//		try {
//			Page<Doctor> page=docService.showAllDoctorsByPageNoAsSorted(0, 4,true,"specialization");
//			page.forEach(System.out::println);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
		try {
			docService.showAllDoctorsInPagination(3);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
