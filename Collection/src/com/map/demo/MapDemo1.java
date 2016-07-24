package com.map.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapDemo1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);// ����ɨ�����
		System.out.println("�������ַ�����");// ��ʾ��Ϣ
		Map<Character, Integer> map = getMap(input.next());// ��ȡ������ַ���������getMap()����
		Set<Character> set = map.keySet();// ��ȡmap�����е�����Key
		// �������
		for (Character key : set) {
			Integer value = map.get(key);// ��ȡKey��Ӧ��Value
			System.out.println("Key=" + key + ",Value=" + value);// ��ӡ
		}
		input.close();// �رն��󣬻�����Դ
	}

	public static Map<Character, Integer> getMap(String str) {
		char[] ch = str.toCharArray();// ���ַ���ת��Ϊchar��������
		Map<Character, Integer> map = new HashMap<>();// ����Map���϶���
		// ��������
		for (char key : ch) {
			/* ����Map�����е�get(Key)������ȡִ��Key��ֵ */
			Integer value = map.get(key);
			if (value == null) {
				map.put(key, 1);// valueֵΪnull����map���������Key��Value
			} else {
				map.put(key, value + 1);// value��Ϊnull����������ϼ�һ
			}
		}
		return map;// ����map����
	}

}
