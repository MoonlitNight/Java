package com.arrays.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysDemo1 {
	public static void main(String[] args) {
		// ��������
		Integer[] array = { 11, 46, 23, 52 };
		// ����Arrays�е�asList()����������תΪ����
		List<Integer> list = Arrays.asList(array);
		// ��ת����
		Collections.reverse(list);
		// ������ת��Ϊ���鸳ֵ��array
		array = (Integer[]) list.toArray();
		// ������ӡ
		for (Integer n : array) {
			System.out.println(n);
		}
	}
}
