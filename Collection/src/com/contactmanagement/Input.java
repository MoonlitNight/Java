package com.contactmanagement;

import java.util.Scanner;

public class Input {
	/* ����ɨ�赽������ֵ */
	public int returnInt() {
		Scanner input = new Scanner(System.in);
		int i = 0;
		try {
			i = input.nextInt();
		} catch (Exception e) {
			System.out.println("�������ݴ�������������");
			returnInt();
		} 
		return i;
	}

	/* ����ɨ�赽��String����ֵ */
	public String returnString() {
		Scanner input = new Scanner(System.in);
		String str ="";
		try {
			str = input.next();
		} catch (Exception e) {
			System.out.println("�������ݴ�������������");
			returnInt();
		} 
		return str;
	}
}
