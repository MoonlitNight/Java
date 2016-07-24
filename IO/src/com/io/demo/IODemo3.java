package com.io.demo;

import java.io.File;
import java.io.FileFilter;
import java.util.Calendar;
import java.util.Date;

/*�Զ����������ʵ��FileFilter�ӿ�*/
class MyFileFilter2 implements FileFilter {
	/* ��дaccept()�������Զ�����˹��� */
	public boolean accept(File path) {
		// ��ȡ����޸�ʱ������
		Calendar c = Calendar.getInstance();
		c.setTime(new Date(path.lastModified()));
		int year = c.get(Calendar.YEAR);
		// �жϸ��ļ�Ϊ�ļ�������޸�ʱ�����Ϊ2014�������ļ���
		if (path.isFile() && (year==2014)||path.isDirectory()) {
			return true;
		}
		return false;
	}
}

public class IODemo3 {
	public static void main(String[] args) {
		File file = new File("D:\\Backup\\ISO");// ����Flie����
		getFile(file, new MyFileFilter2());// ���÷�����ȡ��׺Ϊ.jpg�ļ�����
	}

	public static void getFile(File file, MyFileFilter2 myFileFilter) {
		if (!file.exists()) // �ж��Ƿ�����ļ���Ŀ¼
		{
			throw new RuntimeException(file + "·��������");// ���������׳��쳣
		}
		File[] data = file.listFiles(myFileFilter);// ���չ����������ļ�
		if(data==null)//�ж����dateΪnull���������β���
		{
			return;
		}
		// ��������
		for (File file2 : data) {
			/* ������ļ�������ļ��ľ���·�� */
			if (file2.isFile()) {
				System.out.println(file2.getAbsolutePath());
			} else if (file2.isDirectory()) {
				/* �����Ŀ¼��ݹ���� */
				getFile(file2, myFileFilter);
			}
		}
	}
}
