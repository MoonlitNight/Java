package com.io.demo;

import java.io.File;
import java.io.FileFilter;

/*�Զ����������ʵ��FileFilter�ӿ�*/
class MyFileFilter3 implements FileFilter {

	public MyFileFilter3(String suffix) {
		super();
		setSuffix(suffix);// ���ù��˺�׺��
	}

	/**
	 * @return the suffix
	 */
	public String getSuffix() {
		return suffix;
	}

	/**
	 * @param suffix
	 *            the suffix to set
	 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	private String suffix;// ��׺��

	/* ��дaccept()�������Զ�����˹��� */
	public boolean accept(File path) {
		/*�ж�������ļ����ļ�����׺ƥ��������ļ����򲻹���*/
		if (path.isFile() && path.getName().endsWith(suffix)||path.isDirectory()) {
			return true;
		}
		return false;
	}

}

public class IODemo4 {

	public static void main(String[] args) {
		File file = new File("D:\\�ĵ�\\JAVA\\eclipse");// ����Flie����
		getFile(file, new MyFileFilter3(".class"));// ���÷�����ȡ��׺Ϊ.jpg�ļ�����
		getFile(file, new MyFileFilter3(".java"));// ���÷�����ȡ��׺Ϊ.png�ļ�����
	}

	public static void getFile(File file, MyFileFilter3 myFileFilter) {
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
