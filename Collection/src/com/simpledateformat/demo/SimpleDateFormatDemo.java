package com.simpledateformat.demo;

import java.text.SimpleDateFormat;

public class SimpleDateFormatDemo {

	public static void main(String[] args) {
		// �Զ����񣬻�ȡSimpleDateFormat����
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��-MM��-dd�� HHʱ:mm��:ss��");
		String str = sdf.format(System.currentTimeMillis());// ���ݺ���ֵ��ʽ����ǰ����
		System.out.println(str);// ��ӡ
	}

}
