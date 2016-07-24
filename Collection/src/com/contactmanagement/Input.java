package com.contactmanagement;

import java.util.Scanner;

public class Input {
	/* 返回扫描到的整型值 */
	public int returnInt() {
		Scanner input = new Scanner(System.in);
		int i = 0;
		try {
			i = input.nextInt();
		} catch (Exception e) {
			System.out.println("输入数据错误请重新输入");
			returnInt();
		} 
		return i;
	}

	/* 返回扫描到的String类型值 */
	public String returnString() {
		Scanner input = new Scanner(System.in);
		String str ="";
		try {
			str = input.next();
		} catch (Exception e) {
			System.out.println("输入数据错误请重新输入");
			returnInt();
		} 
		return str;
	}
}
