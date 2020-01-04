package br.com.andrew.registration.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;

public class FormatDate {
	
	public FormatDate() {

	}

	public static Date FormatDateBr(String date) 
			throws ServletException, ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date newDate = sdf.parse(date);

		return newDate;
	}

}
