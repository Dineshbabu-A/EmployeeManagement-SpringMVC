package com.employee.utility;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class EmployeeUtility {

	public static int calculateAge(Date date) {

		if(date == null) {
			return 0;
		}

		LocalDate birthDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Period period = Period.between(birthDate, LocalDate.now());
		int age = period.getYears();

		return age;

	}




}
