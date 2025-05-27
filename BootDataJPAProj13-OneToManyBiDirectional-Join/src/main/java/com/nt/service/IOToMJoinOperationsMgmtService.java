//BootDataJpaProj13OToMBiDirectionalJoin.java(19.03.2025)
package com.nt.service;

import java.util.List;
import com.nt.entity.Person;
import com.nt.entity.PhoneNumber;

public interface IOToMJoinOperationsMgmtService {
    public List<Object[]> showPersonAndPhoneNumbersUsingJoins();
    public List<Object[]> showPhoneNumbersAndPersonUsingJoins();
}
