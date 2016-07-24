package com.regex.demo;

import java.util.Scanner;//导入包

public class RegexDemo1 {
	public static void main(String[] args) {
		/* 创建Scanner对象 */
		Scanner input = new Scanner(System.in);
		/* 输出提示信息 */
		System.out.println("请输入身份证号码：");
		/* 扫描录入信息 */
		String id = input.nextLine();
		boolean f = flag(id);
		/* 打印信息 */
		System.out.println(f);
		/* 关闭对象，回收资源 */
		input.close();
	}

	public static boolean flag(String id) {
		return id.matches("^[1-9]\\d{5}[1||2]\\d{3}(0[1-9]||1[0-2])([0-2]\\d||3[01])\\d{3}(\\d||X)$");
		
	}
}
