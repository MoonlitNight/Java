package com.simpledateformat.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo2 {

	public static void main(String[] args) throws ParseException {
		// 自定义风格，获取SimpleDateFormat对象
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM/dd HH时mm分ss秒");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM月dd日 HH时mm分ss秒");
		Date d1 = sdf1.parse("2015年06/14 23时13分01秒");
		Date d2 = sdf2.parse("2010-02月12日 12时02分01秒");
		double n = (d1.getTime()-d2.getTime())/(1000*60*60*24.0);
		System.out.println(sdf1.format(d1)+"和"+sdf2.format(d2)+"相差"+n+"天");
	}

}
