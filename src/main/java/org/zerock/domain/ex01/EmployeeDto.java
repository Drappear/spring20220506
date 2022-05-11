package org.zerock.domain.ex01;

import java.sql.Date;

import lombok.Data;

@Data
public class EmployeeDto {
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String photo;
	private String notes;		
	
}
