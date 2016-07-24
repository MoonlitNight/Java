package com.fileio.demo;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

class Queue {
	LinkedList<File> queue = new LinkedList<>();// ����LinkedList������ģ����нṹ

	public void add(File file)// �򼯺�������ļ�����
	{
		queue.addFirst(file);// ��ͷ��ʼ���
	}

	public File getFile()// �Ӽ����л�ȡ�ļ�����
	{
		return queue.removeLast();
	}

	public boolean isEmpty()// �жϼ������Ƿ�Ϊ��
	{
		return queue.isEmpty();
	}
}

/* �Զ����������ʵ��FileFilter�ӿ� */
class MyFileFilter2 implements FileFilter {

	private String regex;// ��׺��

	public MyFileFilter2(String regex) {
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

	public static Queue queue = new Queue();// �������ж���
	public static MyFileFilter2 mff = new MyFileFilter2(".+(.java)$");// ��������������

	public static void main(String[] args) {
		File file = new File("D:\\�ĵ�\\JAVA\\eclipse");// ����Flie����
		try {
			long start = System.currentTimeMillis();// ��ȡ��ʼ����ʱ����ֵ
			getFile(file);
			long end = System.currentTimeMillis();// ��ȡ�������ʱ����ֵ
			System.out.println("����ʹ��" + (end - start) + "����");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void getFile(File file) throws IOException {
		if (!file.exists()) // �ж��Ƿ�����ļ���Ŀ¼
		{
			throw new RuntimeException(file + "·��������");// ���������׳��쳣
		}
		File[] data = file.listFiles(mff);// ���չ����������ļ�
		if (data == null) // �ж����dateΪnull���������β���
		{
			return;
		}
		// ��������
		for (File file2 : data) {
			/* ������ļ�������ļ��ľ���·�� */
			if (file2.isFile()) {
				record(file2);
			} else if (file2.isDirectory()) {
				/* �����Ŀ¼��Ŀ¼������ӵ������� */
				queue.add(file2);
			}
		}
		process();// ���ö��д�������
	}

	/* �˷���Ϊ��������е����� */
	public static void process() throws IOException {
		// �ж϶������Ƿ���Ԫ��
		while (!queue.isEmpty()) {
			File file = queue.getFile();// ��ȡ�ļ�����
			getFile(file);// �ٴε��÷���
		}
		return;
	}

	public static void record(File file) throws IOException {
		if (!file.exists())
			throw new RuntimeException("Դ�ļ�������");
		// �����ֽ����������������
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("D:\\record.txt"), true));
		// ������ȡ�ֽ�����
		String path = file.getAbsolutePath() + System.getProperty("line.separator");
		byte[] ch = path.getBytes();
		bos.write(ch);// ���ֽ���������д������
		bos.flush();// ˢ�´λ���������
		bos.close();// �رջ���������
	}

}
