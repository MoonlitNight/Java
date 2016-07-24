package com.cutfile.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Merge {

	public static void main(String[] args) throws IOException {
		//�����ֽ����������������
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File("D:/test/temp.jpg")));
		//���岼������f��Ϊtrueʱ������ȡ
		boolean f = true;
		//�������ͱ���part�������ȡ�ļ�����
		int part = 1;
		while(f)
		{
			//�����ֽ�����������������
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File("D:/test/part"+part)));
			//�����ֽ��������ڴ洢����
			byte[] buf = new byte [1024];
			//�������α���len���ڽ��ն�ȡ�����ֽ���
			int len = 0;
			while((len = bis.read(buf))!=-1)
			{
				bos.write(buf, 0, len);
				bos.flush();
				if(len!=1024)//�ж�ʵ�ʶ�ȡ�����ֽ�����Ϊ1024��ʱ���ټ�����ȡ����
					f=false;
			}
			part++;
			bis.close();
		}
		bos.close();
	}

}
