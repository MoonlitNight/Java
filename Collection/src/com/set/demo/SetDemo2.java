package com.set.demo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class MyComparator implements Comparator // 创建一个比较器接口实现类
{
	public int compare(Object o1, Object o2) {
		if (!(o1 instanceof String && o2 instanceof String)) // 判断类型是否为String
		{
			throw new RuntimeException("类型不匹配");// 不是则抛出异常
		}
		String str1 = (String) o1;// 向下转型
		String str2 = (String) o2;// 向下转型
		int flag = str1.length() - str2.length();// 比较字符串长度
		if (flag == 0) // 判断字符串长度是否相同
		{
			flag = str1.compareTo(str2);// 相同则比较字符串
		}
		return flag;// 返回比较结果
	}
}

public class SetDemo2 {

	public static void main(String[] args) {
		TreeSet set = new TreeSet(new MyComparator());// 创建TreeSet集合指定比较器对象
		set.add("MeiZu");
		set.add("vivo");
		set.add("HuaWei");
		set.add("XiaoMi");
		set.add("ZhongXing");
		for (Iterator it = set.iterator(); it.hasNext();) {// 使用迭代器遍历集合
			String obj = (String) it.next();// 强制类型转换
			System.out.println(obj);
		}
	}

}
