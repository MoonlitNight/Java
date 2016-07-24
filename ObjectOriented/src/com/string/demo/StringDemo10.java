package com.string.demo;
import java.util.Scanner;//导入包

public class StringDemo10 {
	public static void main(String[] args) {
		/* 创建Scanner对象 */
		Scanner input = new Scanner(System.in);
		/* 输出提示信息 */
		System.out.println("请输入身份证号码：");
		/* 扫描录入信息 */
		String id = input.nextLine();
		/* 截取信息 */
		String year = id.substring(6, 10);
		String month = id.substring(10, 12);
		String day = id.substring(12, 14);
		/* 打印信息 */
		System.out.println(year + "年" + month + "月" + day + "日");
		/* 关闭对象，回收资源 */
		input.close();
	}
}
