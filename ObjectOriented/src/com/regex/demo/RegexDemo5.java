package com.regex.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo5 {
	public static void main(String[] args) {
		String str = "�����ĵ�������:zhangsan@163.com;��������:lisi@qq.com";
		/* ����Patternʵ�� */
		Pattern p = Pattern.compile("([a-zA-Z]|\\d|_)+@([a-zA-z]|(\\d))+\\.[a-zA-Z]+");
		/* ��������ʵ����ȡƥ��������(Matcher) */
		Matcher m = p.matcher(str);
		/* ���ҷ��Ϲ�������� */
		while (m.find()) {
			/* ����ƥ�䵽�����в���ӡ */
			System.out.println(m.group());
		}
	}
}
