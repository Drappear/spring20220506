package org.zerock.service.ex02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.ex01.CustomerDto;
import org.zerock.domain.ex01.EmployeeDto;
import org.zerock.mapper.ex02.Ex02Mapper;

@Service
public class Ex04Service {

	@Autowired
	private Ex02Mapper mapper;
	
	public String getNameById(int id) {
		String name = mapper.selectNameById(id);
		return name;
	}

	public String getFirstNameById(int id) {
		String firstName = mapper.selectFirstNameById(id);
		return firstName;
	}

	public CustomerDto getCustomerInfoById(int id) {
		CustomerDto dto = mapper.selectCustomerById(id);
		return dto;
	}

	public EmployeeDto getEmployeeInfoById(int id) {
		EmployeeDto dto = mapper.selectEmployeeById(id);
		return dto;
	}

	public boolean addCustomer(CustomerDto customer) {
		int count = mapper.insertCustomer(customer);
		return count == 1;
	}

	public boolean addEmployee(EmployeeDto employee) {
		int count = mapper.insertEmployee(employee);
		return count == 1;
	}
	
	public List<EmployeeDto> listEmployee() {
		return mapper.listEmployee();
	}
	
	public List<CustomerDto> listCustomer(int startNum) {
		return mapper.listCustomer(startNum);
	}

	public int getTotal() {
		return mapper.totalCustomer();
	}

	public List<CustomerDto> listCustomerPage(int page, int rowPerPage) {
		int from = (page-1) * rowPerPage;
		return mapper.listCustomerPage(from, rowPerPage);
	}
	
}
