package com.filerw.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyText {

	public static void main(String[] args) {
		/* ����Դ�ļ�File���� */
		File src = new File("D:\\Test\\������Щ�¶�.txt");
		/* ����Ŀ���ļ����� */
		File dest = new File("D:\\Test\\copy.txt");
		try {
			long start = System.currentTimeMillis();
			copy(src, dest);// ����copy���������ļ�
			long end = System.currentTimeMillis();
			System.out.println("�����ļ�����ʹ��" + (end - start) + "����");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void copy(File src, File dest) throws IOException {
		// ���Դ�ļ����������׳��쳣
		if (!src.exists())
			throw new RuntimeException("Ŀ���ļ�������");
		/* �����ַ�����������������������ȡԴ�ļ� */
		BufferedReader r = new BufferedReader(new FileReader(src));
		/* �����ַ��������������������д�����ļ� */
		BufferedWriter w = new BufferedWriter(new FileWriter(dest));
		String str = "";
		// ��ȡһ���ַ������жϷ���ֵ��Ϊnull�������ȡ
		while ((str = r.readLine()) != null) {
			w.write(str);// д���ַ���
			w.newLine();// д�뻻�з�
			w.flush();// ˢ�»�����
		}
		r.close();// �رն���
		w.close();// �ر�
	}

}
