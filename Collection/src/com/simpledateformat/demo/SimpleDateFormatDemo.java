package com.simpledateformat.demo;

import java.text.SimpleDateFormat;

public class SimpleDateFormatDemo {

	public static void main(String[] args) {
		// 自定义风格，获取SimpleDateFormat对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年-MM月-dd日 HH时:mm分:ss秒");
		String str = sdf.format(System.currentTimeMillis());// 根据毫秒值格式化当前日期
		System.out.println(str);// 打印
	}

}
