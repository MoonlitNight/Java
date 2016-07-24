package com.simpledateformat.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo2 {

	public static void main(String[] args) throws ParseException {
		// �Զ����񣬻�ȡSimpleDateFormat����
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy��MM/dd HHʱmm��ss��");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM��dd�� HHʱmm��ss��");
		Date d1 = sdf1.parse("2015��06/14 23ʱ13��01��");
		Date d2 = sdf2.parse("2010-02��12�� 12ʱ02��01��");
		double n = (d1.getTime()-d2.getTime())/(1000*60*60*24.0);
		System.out.println(sdf1.format(d1)+"��"+sdf2.format(d2)+"���"+n+"��");
	}

}
