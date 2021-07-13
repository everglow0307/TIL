package com.study.java.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateAndCanlendarTest {
	
	public static void main(String[] args) {
		
		//Calendar를 Date로 변환
		Calendar cal = Calendar.getInstance();
		Date d = new Date(cal.getTimeInMillis());
		
		
		//Date를 Calendar로 변환
		Date d2 = new Date();
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(d2);
		
		final String[] DAY_OF_WEEK = {"", "일", "월", "화","수","목","금","토","일"};
		
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		
		date1.set(2021,Calendar.JULY,13);
		System.out.println("오늘은 "+DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)]+"요일 입니다.");
		
		// 두 날짜간의 차이를 얻으려면 getTimeInMillis() 천분의 일초 단위로 변환해야 한다.
		long difference = ((date2.getTimeInMillis()-date1.getTimeInMillis())/1000);
		System.out.println("date1부터 date2까지 "+difference+"초가 지났습니다.");
		System.out.println("일로 계산하면 "+difference/24*60*60);
		
		//SimpleDateFormat
		Date today = new Date();
		
		SimpleDateFormat sdf1, sdf2, sdf3;
		
		sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		System.out.println(sdf1.format(today));
		System.out.println(sdf2.format(today));
		System.out.println(sdf3.format(today));
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date d3 = df.parse("2021년 11월 25일");
			System.out.println(df2.format(d3));
		}catch(Exception e) {}
	}

}
