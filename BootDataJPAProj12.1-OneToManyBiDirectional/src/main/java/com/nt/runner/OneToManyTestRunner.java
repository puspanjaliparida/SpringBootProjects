//OneToManyTestRunner.java(17/18/19.03.2025)
package com.nt.runner;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.service.IOToMOperationsMgmtService;

@Component
public class OneToManyTestRunner implements CommandLineRunner {
	@Autowired
    private IOToMOperationsMgmtService otomService;
    
	@Override
	public void run(String... args) throws Exception {
		/*//Save The Object
		//Parent Object
		Person per=new Person("khushi","bls");
		//Child Objects
		PhoneNumber ph1=new PhoneNumber("office", 72882992L, "jio");
		PhoneNumber ph2=new PhoneNumber("personal", 72366272L, "vi");
		//Link Person To Childs(Many To One)
		ph1.setPerson(per);
		ph2.setPerson(per);
		//Link Childs With Parent(One To Many)
		per.setPhones(Set.of(ph1,ph2));
		//Invoke The Method
		try {
			String msg=otomService.registerPersonWithPhoneNumbers(per);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*//Child To Parent Object Saving
		//Parent Object
		Person per=new Person("suman","delhi");
		//Child Objects
		PhoneNumber ph1=new PhoneNumber("Office",36738932L,"jio");
		PhoneNumber ph2=new PhoneNumber("Personal",37832992L,"vi");
		//Link Parent With Childs
		ph1.setPerson(per);
		ph2.setPerson(per);
		//Link Childs With Parent
		Set<PhoneNumber> phonesSet=new HashSet<PhoneNumber>();
		per.setPhones(phonesSet);
		//Parent List<PhoneNumber> Collection
		List<PhoneNumber> list=Arrays.asList(ph1,ph2);
		//Invoke The Business Method
		try {
			String msg=otomService.registerPhoneNumberWithPerson(list);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			List<Person> list=otomService.loadPersonAndHisPhoneNumbers();
			list.forEach(per->{
				System.out.println("Parent ::"+per);
				Set<PhoneNumber> phonesSet=per.getPhones();
				phonesSet.forEach(ph->{
					System.out.println("Child::"+ph);
				});
				System.out.println("---------------------------");
			});
		}//Try
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			List<PhoneNumber> list=otomService.loadPhonesWithPerson();
			list.forEach(ph->{
				System.out.println("Child::"+ph);
				//Get Associated Parent
				Person per=ph.getPerson();
				System.out.println("Parent::"+per);
			});
		}//Try
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			String msg=otomService.removePersonAndHisPhones(1000);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			String msg=otomService.removePhonesOfaPerson(1020);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		/*try {
			PhoneNumber ph=new PhoneNumber("office",72882922L,"bsnl");
			String msg=otomService.addNewPhoneNumberToAPerson(1020, ph);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			String msg=otomService.removePhoneNumbersAndPerson(1020);
			System.out.println(msg);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
