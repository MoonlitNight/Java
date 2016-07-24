package com.filerw.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CopyUTF8 {

	public static void main(String[] args) {
		/* ����Դ�ļ�File���� */
		File src = new File("D:\\Test\\UTF-8.txt");
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
		/* ָ������������ַ�����������������������ȡԴ�ļ� */
		BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(src),"UTF-8"));
		/* ָ������������ַ��������������������д�����ļ� */
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dest),"UTF-8"));
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
