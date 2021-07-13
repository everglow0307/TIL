package com.study.java.calendar;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeTest {
	
	public static void main(String[] args) {
		//LocalDate, LocalTime���� �������� �Һ����� ������ �ִ�.
		
		/**
		 * period : ��¥ - ��¥
		 * duration: �ð� - �ð�
		 * */
		
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plusDays(1);
		LocalDate tomorrow2 = today.plus(1, ChronoUnit.DAYS);
		System.out.println(today);
		System.out.println(tomorrow);
		System.out.println(tomorrow2);
		
		
		LocalTime time = LocalTime.now();
		LocalDateTime dateTime = LocalDateTime.now();
		ZonedDateTime dateTimeInKr = ZonedDateTime.now();
		
		LocalDate date2 = LocalDate.of(2021, 7, 13);
		LocalTime date3 = LocalTime.of(23, 59, 59);
		
		
		//���ڿ��� ��¥�� �ð����� ��ȯ��. (yyyy-mm-dd���ĸ� ����)
		LocalDate birth = LocalDate.parse("1995-11-15");
		LocalTime later = LocalTime.parse("12:32:15");
		System.out.println(birth);
		System.out.println(later);
		
		//LocalDate�� Calendar�� �ٸ��� 1������ 1���� ī��Ʈ��.
		System.out.println(today.getMonth());
		System.out.println(today.getMonthValue());
		
		
		
	}

}
