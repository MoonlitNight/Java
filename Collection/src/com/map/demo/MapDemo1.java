package com.map.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapDemo1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);// 创建扫描对象
		System.out.println("请输入字符串：");// 提示信息
		Map<Character, Integer> map = getMap(input.next());// 获取输入的字符串并调用getMap()方法
		Set<Character> set = map.keySet();// 获取map集合中的所有Key
		// 遍历输出
		for (Character key : set) {
			Integer value = map.get(key);// 获取Key对应的Value
			System.out.println("Key=" + key + ",Value=" + value);// 打印
		}
		input.close();// 关闭对象，回收资源
	}

	public static Map<Character, Integer> getMap(String str) {
		char[] ch = str.toCharArray();// 将字符串转换为char类型数组
		Map<Character, Integer> map = new HashMap<>();// 创建Map集合对象
		// 遍历数组
		for (char key : ch) {
			/* 调用Map集合中的get(Key)方法获取执行Key的值 */
			Integer value = map.get(key);
			if (value == null) {
				map.put(key, 1);// value值为null则向map集合中添加Key及Value
			} else {
				map.put(key, value + 1);// value不为null则在其基础上加一
			}
		}
		return map;// 返回map集合
	}

}
