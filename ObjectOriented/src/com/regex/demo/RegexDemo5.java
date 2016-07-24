package com.regex.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo5 {
	public static void main(String[] args) {
		String str = "张三的电子邮箱:zhangsan@163.com;李四邮箱:lisi@qq.com";
		/* 创建Pattern实例 */
		Pattern p = Pattern.compile("([a-zA-Z]|\\d|_)+@([a-zA-z]|(\\d))+\\.[a-zA-Z]+");
		/* 根据正则实例获取匹配器对象(Matcher) */
		Matcher m = p.matcher(str);
		/* 查找符合规则的序列 */
		while (m.find()) {
			/* 返回匹配到的序列并打印 */
			System.out.println(m.group());
		}
	}
}
