package com.copy.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
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

public class IODemo1 {
	
	public static Queue queue = new Queue();// �������ж���
	public static void main(String[] args) {
		File src = new File("D:\\��Ƶ\\fs 2014Ѳ�� ��I��");// ����Դ�ļ�Flie����
		File dest = new File("D:\\copy");
		try {
			long start = System.currentTimeMillis();// ��ȡ��ʼ����ʱ����ֵ
			copy(src, dest);
			long end = System.currentTimeMillis();// ��ȡ�������ʱ����ֵ
			System.out.println("�����ļ�����ʹ��" + (end - start) + "����");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void copy(File src, File dest) throws IOException {
		if (!src.exists()) // �ж��Ƿ�����ļ���Ŀ¼
		{
			throw new RuntimeException(src + "·��������");// ���������׳��쳣
		}
		if (!dest.exists()){
			if(dest.mkdir())// �ж�Ŀ��Ŀ¼�Ƿ���ڣ��������򴴽���Ŀ¼
			{
				System.out.println("����"+dest.getAbsolutePath()+"·���ɹ���");
			}else{
				System.out.println("����"+dest.getAbsolutePath()+"·��ʧ�ܣ�\n�ļ����浽�ϼ�Ŀ¼");
				rw(src,dest.getParentFile());// �����ļ����ϼ�Ŀ¼
			}
		}
		if(src.isFile()){
			rw(src, dest);// �����ļ���Ŀ���ļ���
		}else if (src.isDirectory()){
		File[] data = src.listFiles();// ��ȡԴ�ļ�Ŀ¼�µ��ļ��б�
		if (data == null) // �ж����dateΪnull���������β���
		{
			return;
		}
		// ��������
		for (File file : data) {
			/* ������ļ�������ļ��ľ���·�� */
			if (file.isFile()) {
				rw(file, new File(dest, file.getName()));// �����ļ���Ŀ���ļ���
			} else if (file.isDirectory()) {
				queue.add(file);//�򼯺������Ŀ¼����
		}
			process(src);//��������е�Ŀ¼����
		}
	}
	}

	public static void rw(File src, File dest) throws IOException {
		if (!src.exists())
			throw new RuntimeException("Դ�ļ�������");
		// �����ֽ������뻺��������
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
		// �����ֽ����������������
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
		// ������ȡ�ֽ�����
		byte[] ch = new byte[1024];
		// ��������count��¼��ȡ�����ֽ���
		int count = 0;
		while ((count = bis.read(ch)) != -1) {
			bos.write(ch, 0, count);// ���ֽ���������д������
		}
		bos.close();// �رջ���������
		bis.close();// �رջ���������
	}

	/* �˷���Ϊ��������е����� */
	public static void process(File src) throws IOException {
		// �ж϶������Ƿ���Ԫ��
		while (!queue.isEmpty()) {
			File file = queue.getFile();// ��ȡ�ļ�����
			copy(src,file);// �ٴε��÷���
		}
		return;
	}
}
