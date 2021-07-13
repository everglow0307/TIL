package com.study.java.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateAndCanlendarTest {
	
	public static void main(String[] args) {
		
		//Calendar�� Date�� ��ȯ
		Calendar cal = Calendar.getInstance();
		Date d = new Date(cal.getTimeInMillis());
		
		
		//Date�� Calendar�� ��ȯ
		Date d2 = new Date();
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(d2);
		
		final String[] DAY_OF_WEEK = {"", "��", "��", "ȭ","��","��","��","��","��"};
		
		Calendar date1 = Calendar.getInstance();
		Calendar date2 = Calendar.getInstance();
		
		date1.set(2021,Calendar.JULY,13);
		System.out.println("������ "+DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)]+"���� �Դϴ�.");
		
		// �� ��¥���� ���̸� �������� getTimeInMillis() õ���� ���� ������ ��ȯ�ؾ� �Ѵ�.
		long difference = ((date2.getTimeInMillis()-date1.getTimeInMillis())/1000);
		System.out.println("date1���� date2���� "+difference+"�ʰ� �������ϴ�.");
		System.out.println("�Ϸ� ����ϸ� "+difference/24*60*60);
		
		//SimpleDateFormat
		Date today = new Date();
		
		SimpleDateFormat sdf1, sdf2, sdf3;
		
		sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf3 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		System.out.println(sdf1.format(today));
		System.out.println(sdf2.format(today));
		System.out.println(sdf3.format(today));
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy�� MM�� dd��");
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");

		try {
			Date d3 = df.parse("2021�� 11�� 25��");
			System.out.println(df2.format(d3));
		}catch(Exception e) {}
	}

}
