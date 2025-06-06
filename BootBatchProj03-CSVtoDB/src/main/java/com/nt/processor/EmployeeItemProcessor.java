//EmployeeItemProcessor.java(31.05.2025)
package com.nt.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee;

@Component
public class EmployeeItemProcessor implements ItemProcessor<Employee, Employee>{

	@Override
	public Employee process(Employee item) throws Exception {
		if(item.getSalary()>15000) {
			item.setGrossSalary(item.getSalary()+item.getSalary()*0.3f);
			item.setNetSalary(item.getGrossSalary()-item.getGrossSalary()*0.2f);
			return item;
		}
		return null;
	}

}
