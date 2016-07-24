package com.fileio.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

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
		/* �ж�������ļ����ļ�������ƥ���򲻹��� */
		if (path.isFile() && path.getName().matches(regex)) {
			return true;
		}
		return false;
	}
}

public class IODemo1 {

	public static void main(String[] args) {
		File file = new File("D:\\ͼƬ\\Saved Pictures");// ����Flie����
		try {
			long start = System.currentTimeMillis();//��ȡ��ʼ����ʱ����ֵ
			getFile(file, new MyFileFilter(".+[.jpg|.png|.bmp]$"));
			long end = System.currentTimeMillis();//��ȡ�������ʱ����ֵ
			System.out.println("�����ļ�����ʹ��"+(end-start)+"����");
		} catch (IOException e) {
			e.printStackTrace();
		}
 }

	public static void getFile(File file, MyFileFilter myFileFilter) throws IOException {
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
			/* ������ļ����Ƶ�Ŀ���ļ��� */
			if (file2.isFile()) {
				copy(file2,new File("D:\\ͼƬ\\copy\\"+file2.getName()));
			} /*else if (file2.isDirectory()) {
				 �����Ŀ¼��ݹ���� 
				getFile(file2, myFileFilter);
			}*/
		}
	}
	public static void copy(File src , File dest) throws IOException {
		if(!src.exists()) throw new RuntimeException("Դ�ļ�������");
		//�����ֽ������뻺��������
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
		//�����ֽ����������������
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
		//������ȡ�ֽ�����
		byte [] ch = new byte [1024];	
		//��������count��¼��ȡ�����ֽ���
		int count = 0 ;
		while((count=bis.read(ch))!=-1)
		{
			bos.write(ch,0, count);//���ֽ���������д������
		}
		bos.close();//�رջ���������
		bis.close();//�رջ���������
	}

}
