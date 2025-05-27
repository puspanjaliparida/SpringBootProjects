//IOToMOperationsMgmtService.java(17/18/19.03.2025)
package com.nt.service;

import java.util.List;
import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;

public interface IOToMOperationsMgmtService {
    public String registerPersonWithPhoneNumbers(Person person);
    public String registerPhoneNumberWithPerson(List<PhoneNumber> list);
    public List<Person> loadPersonAndHisPhoneNumbers();
    public List<PhoneNumber> loadPhonesWithPerson();
    public String removePersonAndHisPhones(int pid);
    public String removePhonesOfaPerson(int pid);
    public String addNewPhoneNumberToAPerson(int pid,PhoneNumber ph);
    public String removePhoneNumbersAndPerson(int pid);
}
