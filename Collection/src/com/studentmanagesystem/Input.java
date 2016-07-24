package com.studentmanagesystem;
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

	/* ����ɨ�赽��double����ֵ */
	public double returnDouble() {
		Scanner input = new Scanner(System.in);
		double d =0;
		try {
			d = input.nextDouble();
		} catch (Exception e) {
			System.out.println("�������ݴ�������������");
			returnInt();
		} 
		return d;
	}

	/* ����ɨ�赽��String����ֵ */
	public String returnString() {
		Scanner str = new Scanner(System.in);
		String scan ="";
		try {
			scan = str.next();
		} catch (Exception e) {
			System.out.println("�������ݴ�������������");
			returnInt();
		} 
		return scan;
	}
}
