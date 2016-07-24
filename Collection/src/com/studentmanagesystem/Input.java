package com.studentmanagesystem;
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

	/* 返回扫描到的double类型值 */
	public double returnDouble() {
		Scanner input = new Scanner(System.in);
		double d =0;
		try {
			d = input.nextDouble();
		} catch (Exception e) {
			System.out.println("输入数据错误请重新输入");
			returnInt();
		} 
		return d;
	}

	/* 返回扫描到的String类型值 */
	public String returnString() {
		Scanner str = new Scanner(System.in);
		String scan ="";
		try {
			scan = str.next();
		} catch (Exception e) {
			System.out.println("输入数据错误请重新输入");
			returnInt();
		} 
		return scan;
	}
}
