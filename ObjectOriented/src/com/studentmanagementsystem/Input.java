package com.studentmanagementsystem;
import java.util.Scanner;

public class Input {
	/* ����ɨ�赽������ֵ */
	public int returnInt() {
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}

	/* ����ɨ�赽��double����ֵ */
	public double returnDouble() {
		Scanner input = new Scanner(System.in);
		return input.nextDouble();
	}

	/* ����ɨ�赽��String����ֵ */
	public String returnString() {
		Scanner input = new Scanner(System.in);
		return input.next();
	}
}
