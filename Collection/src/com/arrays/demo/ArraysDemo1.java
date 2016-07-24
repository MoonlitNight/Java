package com.arrays.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysDemo1 {
	public static void main(String[] args) {
		// 定义数组
		Integer[] array = { 11, 46, 23, 52 };
		// 调用Arrays中的asList()方法将数组转为集合
		List<Integer> list = Arrays.asList(array);
		// 反转集合
		Collections.reverse(list);
		// 将集合转换为数组赋值给array
		array = (Integer[]) list.toArray();
		// 遍历打印
		for (Integer n : array) {
			System.out.println(n);
		}
	}
}
