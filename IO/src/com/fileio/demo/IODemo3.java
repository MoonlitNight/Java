package com.fileio.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo3 {

	public static void main(String[] args) {
		File src = new File("D:\\ͼƬ\\Saved Pictures");// ����Դ�ļ�Flie����
		File dest = new File("D:\\ͼƬ\\copy");
		try {
			long start = System.currentTimeMillis();//��ȡ��ʼ����ʱ����ֵ
			copy(src,dest);
			long end = System.currentTimeMillis();//��ȡ�������ʱ����ֵ
			System.out.println("�����ļ�����ʹ��"+(end-start)+"����");
		} catch (IOException e) {
			e.printStackTrace();
		}
 }

	public static void copy(File src,File dest) throws IOException {
		if (!src.exists()) // �ж��Ƿ�����ļ���Ŀ¼
		{
			throw new RuntimeException(src + "·��������");// ���������׳��쳣
		}
		if(!dest.exists())dest.mkdir();//�ж�Ŀ��Ŀ¼�Ƿ���ڣ��������򴴽���Ŀ¼
		File[] data = src.listFiles();// ��ȡԴ�ļ�Ŀ¼�µ��ļ��б�
		if (data == null) // �ж����dateΪnull���������β���
		{
			return;
		}
		// ��������
		for (File file : data) {
			/* ������ļ�������ļ��ľ���·�� */
			if (file.isFile()) {
				rw(file,new File(dest,file.getName()));//�����ļ���Ŀ���ļ���
			} else if (file.isDirectory()) {
				/*ʹ��Ŀ���ļ��ж����fileĿ¼����һ���µ�File���� */
				File dir = new File(dest,file.getName());
				if(!dir.exists()){
				if(dir.mkdir())//������Ŀ¼
				{
				copy(file,dir);//�����ɹ���ݹ���ø��Ƹ�Ŀ¼�µ��ļ�
				}else{
				System.out.println("���������ļ���ʧ�ܣ��ļ������ڸ�Ŀ¼");
				copy(file,dest);//����ʧ�����Ƶ���ʼĿ��Ŀ¼��
				}			
			}else 
			{
				copy(file,dir);//���Ƹ�Ŀ¼�µ��ļ�
			}
				}
		}
	}
	public static void rw(File src , File dest) throws IOException {
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
