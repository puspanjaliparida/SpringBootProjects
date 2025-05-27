//LOBsTestRunner.java(13/14.03.2025)
package com.nt.runner;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.MarriageSeeker;
import com.nt.service.IMatrimonyServiceMgmt;

@Component
public class LOBsTestRunner implements CommandLineRunner {
      @Autowired
      private IMatrimonyServiceMgmt service;
      
      @Override
      public void run(String... args) throws Exception{
    	  /*Scanner sc=new Scanner(System.in);
    	  System.out.println("Enter Person Name::");
    	  String name=sc.next();
    	  
    	  System.out.println("Enter Person Address::");
    	  String addrs=sc.next();
    	  
    	  sc.nextLine(); 
    	  System.out.println("Enter Person Photo File Complete Path::");
    	  String photoPath=sc.nextLine().trim();
    	  
    	  System.out.println("Enter Person BioData File Complete Path::");
    	  String biodataPath=sc.nextLine().trim();
    	  
    	  System.out.println("Is The Person Indian ?");
    	  boolean indian=sc.nextBoolean();
    	  
    	  //Prepare byte[] Representing Photo File Content
    	  InputStream is=new FileInputStream(photoPath);
    	  byte[] photoData=new byte[is.available()];
    	  photoData=is.readAllBytes();
    	  
    	  //Prepare char[] Representing BioData File Content
    	  File file=new File(biodataPath);
    	  Reader reader=new FileReader(file);
    	  char bioDataContent[]=new char[(int) file.length()];
    	  reader.read(bioDataContent);
    	  
    	  //Prepare Entity Class Object
    	  MarriageSeeker seeker=new MarriageSeeker(name,addrs,photoData,
    			                                                                                                  LocalDateTime.of(1990, 11,23,12,45),
    			                                                                                                  bioDataContent,indian);
    	  System.out.println(service.registerMarriageSeeker(seeker));*/
    	  
    	  System.out.println("--------------------------------------");
    	  Optional<MarriageSeeker> opt=service.searchSeekerById(1);
    	  if(opt.isPresent()) {
    		  MarriageSeeker seeker=opt.get();
    		  System.out.println(seeker.getId()+""+seeker.getName()+""+seeker.getAddrs()+""+seeker.isIndian());
    		  OutputStream os=new FileOutputStream("1000055010-01.jpeg");
    		  os.write(seeker.getPhoto());
    		  os.flush();
    		  Writer writer=new FileWriter("Puspanjali_Parida _Resume.pdf");
    		  writer.write(seeker.getBiodata());
    		  writer.flush();
    		  os.close();
    		  writer.close();
    		  System.out.println("LOBs Are Retrieved");
    	  }
    	  else {
    		  System.out.println("Records Are Not Found");
    	  }
     }
    	  
}
