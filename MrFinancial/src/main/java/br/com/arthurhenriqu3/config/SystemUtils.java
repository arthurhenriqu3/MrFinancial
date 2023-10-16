package br.com.arthurhenriqu3.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class SystemUtils {

	public static boolean isDateValid(String date){
		try {
			LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
		} catch (DateTimeParseException  e) {
			return false;
		}
		return true;	
	}
	
	public static boolean isDateValid(DateTimeFormatter formatter, String date){
		try {
			LocalDate.parse(date, formatter);
		} catch (DateTimeParseException  e) {
			return false;
		}
		return true;	
	}
}