//CrudRepoTestRunner.java(26/27/28/01/03/04.02/03.2025)
package com.nt.runner;

//import java.util.Optional;
//import java.util.ArrayList;
//import java.util.stream.Collectors;
//import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IDoctorService;

@Component
public class CrudRepoTestRunner implements CommandLineRunner{
      @Autowired
      private IDoctorService docService;
      
      @Override
      public void run(String... args) throws Exception {
//    	  try {
//    		  //Prepare Doctor Object
//    		  Doctor doc = new Doctor("Kimmi",6789L,"ortho",997992201L,"MD");
//    		  String msg=docService.registerDoctor(doc);
//    		  System.out.println(msg);
//          }
//          catch(Exception e) {
//        	  e.printStackTrace();
//          }
//    	  try {
//    			System.out.println("Doctors Count::"+docService.showDoctorsCount());
//    		}catch(Exception e) {
//    			e.printStackTrace();
//    		}
    	  
//    	       try {
//    	    	   Doctor doc1 = new Doctor("Omm",6789L,"Cardio",997992201L,"MD");
//    	    	   Doctor doc2 = new Doctor("Mama",6788L,"Physio",997992202L,"MD");
//    	    	   Doctor doc3 = new Doctor("Pankaj",6787L,"Ortho",997992203L,"MD");
//    	    	   List<Doctor> list=List.of(doc1,doc2,doc3); //Java 9 Feature Giving Immutable Collection
//    	    	   String resultMsg=docService.registerDoctorsAsGroup(list);
//    	    	   System.out.println(resultMsg);
//    	       }catch(Exception e) {
//    	    	   e.printStackTrace();
//    	       }
    	          
//    	          try {
//    	        	  String msg=docService.checkDoctorAvailabilityById(101);
//    	        	  System.out.println(msg);
//    	          }
//    	          catch(Exception e) {
//    	        	  e.printStackTrace();
//    	          }
    	             
//    	             try {
//    	            	 Iterable<Doctor> list=docService.findAllDoctors();
//    	            	 list.forEach(doc->{
//    	            		 System.out.println(doc);
//    	            	 });
//    	            	 System.out.println("--------------");
//    	            	 list.forEach(doc->System.out.println(doc));
//    	            	 System.out.println("--------------");
//    	            	 list.forEach(System.out::println);
//    	            	 System.out.println("--------------");
//    	            	 StreamSupport.stream(list.spliterator(), false).forEach(System.out::println);
//    	            	 System.out.println("--------------");
//    	            	 long count=StreamSupport.stream(list.spliterator(), false).count();
//    	            	 System.out.println("No. Of Records::"+count);
//    	            	 System.out.println("--------------");
//    	            	 Iterable<String> specialatiesList=StreamSupport.stream(list.spliterator(), false).map(Doctor::getSpecialization).collect(Collectors.toList());
//    	            	 System.out.println(specialatiesList);
//    	            	 System.out.println("--------------");
//    	            	 for(Doctor doc:list) {
//    	            		 System.out.println(doc);
//    	            	 }
//    	            	 System.out.println("--------------");
//    	            	 List<Doctor> list1=StreamSupport.stream(list.spliterator(), false).toList();
//    	            	 for(int i=0;i<count;++i) {
//    	            		 System.out.println(list1.get(i));
//    	            	 }
//    	             }
//    	             catch(Exception e) {
//    	            	 e.printStackTrace();
//    	             }
//    	  
//    	                try {
////    	                	List<Integer> ids=new ArrayList();
////    	                	ids.add(101);
////    	                	ids.add(102);
////    	                	ids.add(52);
////    	                	ids.add(452);
////    	                	ids.add(null);
//    	                	List<Integer> ids=Arrays.asList(101,102,53,451);
//    	                	Iterable<Doctor> it=docService.findAllDoctorsByIds(ids);
//    	                	long count=StreamSupport.stream(it.spliterator(), false).count();
//    	                	System.out.println(count+"No. Of Doctors Are Found With Given Ids");
//                            it.forEach(doc->{
//                            	System.out.println(doc);
//                            });  	               
//    	                }
//    	                catch(Exception e) {
//    	                	e.printStackTrace();
//    	                }
    	  
//    	                    try {
//    	                    	Doctor doc=docService.showDoctorById(53);
//    	                    	System.out.println("Doctor Info is ::"+doc);
//    	                    }
//    	                    catch(Exception e) {
//    	                    	e.printStackTrace();
//    	                    }
    	                  
//    	                    try {
//    	                    	Optional<Doctor> opt=docService.getDoctorById(1153);
//    	                    	if(opt.isEmpty())
//    	                    		System.out.println("Doctor Not Found");
//    	                    	else
//    	                    		System.out.println("Doctor Found::"+opt.get());
//    	                    }
//    	                    catch(Exception e) {
//    	                    	e.printStackTrace();
//    	                    }
//    	      try {
//    	    	  Doctor doc=new Doctor(593,"RAJESH",7854L,"MD",78383939L,"Ortho");
//    	    	  String msg=docService.registerOrUpdateDoctor(doc);
//    	          System.out.println(msg);
//    	      }
//    	      catch(Exception e) {
//    	    	  e.printStackTrace();
//    	      }
//    	     try {
//    	    	 String msg=docService.updateDoctorDetails(563,"MD-FRC",788372299L);
//    	    	 System.out.println(msg);
//    	     }
//    	     catch(Exception e) {
//    	    	 e.printStackTrace();
//    	     }
             
//             try {
//            	 System.out.println(docService.removeAllDoctors());
//             }
//             catch(Exception e) {
//            	 e.printStackTrace();
//             }
    	  
//    	      try {
//    	    	  System.out.println("Doctors Count::"+docService.removeDoctorsByIds(Arrays.asList(159,160,161)));
//    	      }
//    	      catch(Exception e) {
//    	    	  e.printStackTrace();
//    	      }
 
//    	  try {
//    		    // Creating Doctor Objects Manually (Ensure These Objects Exist In The Database)
//    		    Doctor doctor1 = new Doctor(212, "Dr. A",6783L,"MD",189295L, "Cardiologist");
//    		    Doctor doctor2 = new Doctor(213, "Dr. B",6783L,"MBBS",189295L, "Orthopedic");
//    		    Doctor doctor3 = new Doctor(214, "Dr. C",6783L,"MD",189295L, "Psychologist");
//
//    		    // Call The Method To Remove Doctors
//    		    System.out.println("Doctors Count::" + 
//    		        docService.removeAllDoctors(Arrays.asList(doctor1, doctor2, doctor3)));
//    		} 
//    		catch (Exception e) {
//    		    e.printStackTrace();
//    		}
    	  
    	     System.out.println(docService.removeDoctorById(209));
      }//Run(-)
}//Class
