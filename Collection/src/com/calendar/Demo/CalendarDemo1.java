package com.calendar.Demo;

import java.util.Calendar;

public class CalendarDemo1 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();// ͨ��Calendar�е�getInstance()������ȡ����
		c.set(2014, 2, 1);// ����������
		c.add(Calendar.DATE, -1);// ������һ
		int year = c.get(Calendar.YEAR);// ��ȡ���
		int month = c.get(Calendar.MONTH) + 1;// ��ȡ�·�
		int day = c.get(Calendar.DATE);// ��ȡ����
		System.out.println(year + "��" + month + "��" + "��" + day + "��");// ��ӡ���
	}
}