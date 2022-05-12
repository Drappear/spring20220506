package org.zerock.domain.ex01;

import java.sql.Date;

import lombok.Data;

@Data
public class EmployeeDto {
	private int id;
	private String firstName;
	private String lastName;
//	@DateTimeFormat(pattern = "yyyy-MM-dd") -- 둘 중 하나
//	@DateTimeFormat(iso = ISO.DATE)			-- 둘 중 하나(국제 표준)
//	private LocalDate birthDate;
	private Date birthDate;		// Date 타입은 siple value type목록에 있음
	private String photo;
	private String notes;		
	
}
