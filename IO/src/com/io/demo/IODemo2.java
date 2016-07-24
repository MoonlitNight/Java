package com.io.demo;

import java.io.File;
import java.io.FileFilter;

/*�Զ����������ʵ��FileFilter�ӿ�*/
class MyFileFilter implements FileFilter {

	private String regex;// ��׺��

	public MyFileFilter(String regex) {
		super();
		setRegex(regex);// ���ù���������ʽ
	}

	/**
	 * @return the regex
	 */
	public String getRegex() {
		return regex;
	}

	/**
	 * @param regex
	 *            the regex to set
	 */
	public void setRegex(String regex) {
		this.regex = regex;
	}

	/* ��дaccept()�������Զ�����˹��� */
	public boolean accept(File path) {
		/* �ж�������ļ����ļ�������ƥ��������ļ����򲻹��� */
		if (path.isFile() && path.getName().matches(regex) || path.isDirectory()) {
			return true;
		}
		return false;
	}
}

public class IODemo2 {

	public static void main(String[] args) {
		File file = new File("D:\\");// ����Flie����
		getFile(file, new MyFileFilter(".+(.jpg|.png|.bmp)$"));
 }

	public static void getFile(File file, MyFileFilter myFileFilter) {
		if (!file.exists()) // �ж��Ƿ�����ļ���Ŀ¼
		{
			throw new RuntimeException(file + "·��������");// ���������׳��쳣
		}
		File[] data = file.listFiles(myFileFilter);// ���չ����������ļ�
		if (data == null) // �ж����dateΪnull���������β���
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
