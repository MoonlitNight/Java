package com.calendar.Demo;

import java.util.Calendar;

public class CalendarDemo2 {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();// ͨ��Calendar�е�getInstance()������ȡ����
		int year = c.get(Calendar.YEAR);// ��ȡ���
		int month = c.get(Calendar.MONTH) + 1;// ��ȡ�·�
		int day = c.get(Calendar.DATE);// ��ȡ����
		int date = c.get(Calendar.DAY_OF_YEAR);// ��ȡ�����ǽ����еĵڼ���
		System.out.println(year + "��" + month + "��" + day + "��," + "������" + year + "�еĵ�" + date + "��");// ��ӡ���
	}
}
