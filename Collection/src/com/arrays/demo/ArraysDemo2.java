package com.arrays.demo;

import java.util.Arrays;

public class ArraysDemo2 {
	public static void main(String[] args) {
		int[] array = { 12, 27, 19, 60, 23, 47 };
		// 复制数组
		int[] temp = Arrays.copyOf(array, array.length);
		// 调用sort方法排序
		Arrays.sort(temp);
		// 最大值为最后一个元素
		int max = temp[temp.length - 1];
		// 调用二分查找方法查找23
		int index = Arrays.binarySearch(array, 23);
		System.out.println("最大值max=" + max + "，23在数组中的角标为" + index);
	}
}
