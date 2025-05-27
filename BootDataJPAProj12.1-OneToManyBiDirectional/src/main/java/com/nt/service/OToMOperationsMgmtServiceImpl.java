//OToMOperationsMgmtServiceImpl.java(17/18/19.03.2025)
package com.nt.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;
import com.nt.repository.IPersonRepository;
import com.nt.repository.IPhoneNumberRepository;

@Service
public class OToMOperationsMgmtServiceImpl implements IOToMOperationsMgmtService {
    @Autowired 
	private IPersonRepository personRepo;
    @Autowired
    private IPhoneNumberRepository phoneRepo;
    
	@Override
	public String registerPersonWithPhoneNumbers(Person per) {
		//Save The Object(Parent To Child)
		int idVal=personRepo.save(per).getPid();
		return "Person Object And It's Associated Child Objects Are Saved With The Id Value::"+idVal;
	}

	@Override
	public String registerPhoneNumberWithPerson(List<PhoneNumber> list) {
		List<PhoneNumber> list1=phoneRepo.saveAll(list);
		return list1.size()+"No. Of Childs Linked With Parent Are Saved";
	}

	@Override
	public List<Person> loadPersonAndHisPhoneNumbers() {
		return personRepo.findAll();
	}

	@Override
	public List<PhoneNumber> loadPhonesWithPerson() {
		return phoneRepo.findAll();
	}

	@Override
	public String removePersonAndHisPhones(int pid) {
		//Load Parent Object
		Optional<Person> opt=personRepo.findById(pid);
		if(opt.isPresent()) {
			//Delete The Parent Object Which Internally Deals The Associated Child Objects
			Person per=opt.get();
			personRepo.delete(per);
			return "Person Object And Its Associated PhoneNumber Objects Are Deleted";
		}
		return "Person Is Not Found For Deletion";
	}

	@Override
	public String removePhonesOfaPerson(int pid) {
		//Load Person Object
		Optional<Person> opt=personRepo.findById(pid);
		if(opt.isPresent()) {
			//Get Parent Object
			Person per=opt.get();
			//Get Childs Of A Parent
			Set<PhoneNumber> childs=per.getPhones();
			//Nullify The Parent
			childs.forEach(ph->{
				ph.setPerson(null);
			});
			//Delete All Childs
			phoneRepo.deleteAll(childs);
			return childs.size()+"No. Of PhoneNumber From"+pid+"Person Are Deleted";
		}
		return "Person Not Found For Deletion";
	}

	@Override
	public String addNewPhoneNumberToAPerson(int pid, PhoneNumber ph) {
		//Load Person Object
		Optional<Person> opt=personRepo.findById(pid);
		if(opt.isPresent()) {
			//Get Parent Object
			Person per=opt.get();
			//Get Existing Childs
			Set<PhoneNumber> childs=per.getPhones();
			//Link New Child With Parent
			ph.setPerson(per);
			//Add New Child To Existing Parent
			childs.add(ph);
			per.setPhones(childs);
			//Save The Child Object
			personRepo.save(per);
			return "New Phone Number Is Added To Existing Person";
		}
		return "Person Is Not Found";
	}

	@Override
	public String removePhoneNumbersAndPerson(int pid) {
		//Load Person Object
		Optional<Person> opt=personRepo.findById(pid);
		if(opt.isPresent()) {
			//Get Parent Object
			Person per=opt.get();
			//Get Existing Childs
			Set<PhoneNumber> childs=per.getPhones();
			//Delete The Childs And Associated Parent
			childs.forEach(ph->{
				phoneRepo.delete(ph);
			});
			return "All PhoneNumbers And The Associated Person Are Deleted"+pid; 
		}
		return "Person Is Not Found For Deletion";
	}   
}
