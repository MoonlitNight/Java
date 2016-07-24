package com.studentmanagementsystem;
import java.util.Scanner;

public class Input {
	/* 返回扫描到的整型值 */
	public int returnInt() {
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}

	/* 返回扫描到的double类型值 */
	public double returnDouble() {
		Scanner input = new Scanner(System.in);
		return input.nextDouble();
	}

	/* 返回扫描到的String类型值 */
	public String returnString() {
		Scanner input = new Scanner(System.in);
		return input.next();
	}
}
