package com.Target.Product.DSA;

import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.LocalDate;

import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;

public class MissingDateFinder {
	public static void main(String[] args) {
		int year = 2025;
		List<String> allDates = generateAllDates(year);
		
		// remove one date
		allDates.remove("2025-01-05");
		
		
		// Now find missing date
		String missing = findMissingDateUsingSet(allDates, year);
		System.out.println(" Missing Dates : "+missing);
	}
	
	public static List<String> generateAllDates(int year) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		List<String> dates = new ArrayList<>();
		
		LocalDate start = LocalDate.of(year, 1, 1); // 2025-01-01
		LocalDate end = start.withMonth(12).withDayOfMonth(31);
		
		System.out.println(" startDate : "+start+", end - "+end);
		
		for(LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
			dates.add(date.format(formatter));
		}
		
		return dates;
	}
	
	
	public static String findMissingDateUsingSet(List<String> allDates, int year) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		Set<LocalDate> givenDates = new HashSet<LocalDate>();
		for(String d : allDates) {
			givenDates.add(LocalDate.parse(d, formatter));
		}
		
		System.out.println(" givenDates : "+givenDates);
		
		LocalDate start = LocalDate.of(year, 1, 1);
		LocalDate end = start.withMonth(12).withDayOfMonth(31);
		
		for(LocalDate date = start; !date.isAfter(end); date = date.plusDays(1)) {
			if(!givenDates.contains(date)) {
				return date.format(formatter);
				}
		}
		
		return "Not Found";
	}
}
