package com.calendar.Demo;

import java.util.Calendar;

public class CalendarDemo2 {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();// 通过Calendar中的getInstance()方法获取对象
		int year = c.get(Calendar.YEAR);// 获取年份
		int month = c.get(Calendar.MONTH) + 1;// 获取月份
		int day = c.get(Calendar.DATE);// 获取天数
		int date = c.get(Calendar.DAY_OF_YEAR);// 获取今日是今年中的第几天
		System.out.println(year + "年" + month + "月" + day + "日," + "今天是" + year + "中的第" + date + "天");// 打印输出
	}
}
