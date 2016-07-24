package com.calendar.Demo;

import java.util.Calendar;

public class CalendarDemo1 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();// 通过Calendar中的getInstance()方法获取对象
		c.set(2014, 2, 1);// 设置年月日
		c.add(Calendar.DATE, -1);// 天数减一
		int year = c.get(Calendar.YEAR);// 获取年份
		int month = c.get(Calendar.MONTH) + 1;// 获取月份
		int day = c.get(Calendar.DATE);// 获取天数
		System.out.println(year + "年" + month + "月" + "有" + day + "天");// 打印输出
	}
}