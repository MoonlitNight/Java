package com.string.demo;
import java.util.Scanner;//�����

public class StringDemo10 {
	public static void main(String[] args) {
		/* ����Scanner���� */
		Scanner input = new Scanner(System.in);
		/* �����ʾ��Ϣ */
		System.out.println("���������֤���룺");
		/* ɨ��¼����Ϣ */
		String id = input.nextLine();
		/* ��ȡ��Ϣ */
		String year = id.substring(6, 10);
		String month = id.substring(10, 12);
		String day = id.substring(12, 14);
		/* ��ӡ��Ϣ */
		System.out.println(year + "��" + month + "��" + day + "��");
		/* �رն��󣬻�����Դ */
		input.close();
	}
}
