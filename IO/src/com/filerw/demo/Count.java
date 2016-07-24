package com.filerw.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Count {
	static long count = 0;
	public static void main(String[] args) {
		//������Ҫͳ�Ƶ��ļ�����
		File file = new File("D:\\Test\\UTF-8.txt");
		System.out.println("��������Ҫͳ�Ƶ��ַ�����");
		String key = input();
		try {
			count(file,key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("["+file.toString()+"]�а���\""+key+"\"�Ĺ���:"+count+"����");
	}
	public static String input() {
		//��ȡ�ֽ��������������ֽ���ת��Ϊ�ַ���
		InputStreamReader isr = new InputStreamReader(System.in);
		//�����ַ�����������������
		BufferedReader br = new BufferedReader(isr);
		String str = "";
		try {
			str = br.readLine();//��ȡһ���ַ���
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
	public static void count(File file, String key) throws IOException {
		//�����ַ�������������
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTf-8"));
		//��ȡһ���ַ���������ֵ��Ϊnull�������ȡ
		String str = "";
		while((str=br.readLine())!=null)
		{
			regex(str,key);//�ж��ַ������Ƿ�����ص�����
		}
		br.close();//�رն��󣬻�����Դ
	}
	public static void regex(String str,String key) {
		/*����������ʽ��ȡPattern��ʵ��*/
		Pattern p = Pattern.compile(key);
		/*����Patternʵ����ȡƥ������Matcher������*/
		Matcher m = p.matcher(str);
		while(m.find())//Ѱ�ҷ��Ϲ��������
		{
			count++;//��������һ
		}
	}

}
