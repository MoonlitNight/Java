package com.filerw.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Check {
	public static void main(String[] args) {
		/* ����Դ�ļ�File���� */
		File src = new File("D:\\Test\\kkk.txt");
		try {
			check(src);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void check(File src) throws IOException {
		// ���Դ�ļ����������׳��쳣
		if (!src.exists())
			throw new RuntimeException("Ŀ���ļ�������");
		/* ָ������������ַ�����������������������ȡԴ�ļ� */
		BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(src)));
		String temp = "";
		StringBuilder sb = new StringBuilder();
		// ��ȡһ���ַ������жϷ���ֵ��Ϊnull�������ȡ
		while ((temp = r.readLine()) != null) {
			String str = temp.replaceAll("SB|sb","**");
			str = str.replaceAll("tmd|TMD","***");
			sb.append(str);//�������ַ�������
			sb.append(System.getProperty("line.separator"));//д�뻻�з�
		}
		/* ָ������������ַ��������������������д�����ļ� */
		BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(src)));
		w.write(sb.toString());
		r.close();// �رն���
		w.close();// �ر�
	}
}
