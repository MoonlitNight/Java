package com.regex.demo;

import java.util.Scanner;//导入包

public class RegexDemo4 {
	public static void main(String[] args) {
		/* 创建Scanner对象 */
		Scanner input = new Scanner(System.in);
		/* 输出提示信息 */
		System.out.println("请输入：");
		/* 扫描录入信息 */
		String e = input.nextLine();
		boolean f = flag(e);
		/* 打印信息 */
		System.out.println(f);
		/* 关闭对象，回收资源 */
		input.close();
	}

	public static boolean flag(String e) {
		return e.matches("[a-zA-Z]+$");
	}
}
