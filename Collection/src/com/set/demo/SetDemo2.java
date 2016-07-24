package com.set.demo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

class MyComparator implements Comparator // ����һ���Ƚ����ӿ�ʵ����
{
	public int compare(Object o1, Object o2) {
		if (!(o1 instanceof String && o2 instanceof String)) // �ж������Ƿ�ΪString
		{
			throw new RuntimeException("���Ͳ�ƥ��");// �������׳��쳣
		}
		String str1 = (String) o1;// ����ת��
		String str2 = (String) o2;// ����ת��
		int flag = str1.length() - str2.length();// �Ƚ��ַ�������
		if (flag == 0) // �ж��ַ��������Ƿ���ͬ
		{
			flag = str1.compareTo(str2);// ��ͬ��Ƚ��ַ���
		}
		return flag;// ���رȽϽ��
	}
}

public class SetDemo2 {

	public static void main(String[] args) {
		TreeSet set = new TreeSet(new MyComparator());// ����TreeSet����ָ���Ƚ�������
		set.add("MeiZu");
		set.add("vivo");
		set.add("HuaWei");
		set.add("XiaoMi");
		set.add("ZhongXing");
		for (Iterator it = set.iterator(); it.hasNext();) {// ʹ�õ�������������
			String obj = (String) it.next();// ǿ������ת��
			System.out.println(obj);
		}
	}

}
