package com.arrays.demo;

import java.util.Arrays;

public class ArraysDemo2 {
	public static void main(String[] args) {
		int[] array = { 12, 27, 19, 60, 23, 47 };
		// ��������
		int[] temp = Arrays.copyOf(array, array.length);
		// ����sort��������
		Arrays.sort(temp);
		// ���ֵΪ���һ��Ԫ��
		int max = temp[temp.length - 1];
		// ���ö��ֲ��ҷ�������23
		int index = Arrays.binarySearch(array, 23);
		System.out.println("���ֵmax=" + max + "��23�������еĽǱ�Ϊ" + index);
	}
}
