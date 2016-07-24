package com.cutfile.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CutFile {

	public static void main(String[] args) throws IOException {
		//����Դ�ļ�·������File�����
		File src = new File("D:/test/test.jpg");
		//�����ֽ�����������������
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
		//�����и��ļ�part��
		int part = 1;
		//����һ��byte����һ�ζ�ȡ����ֽڴ洢��������
		byte [] buf = new byte[1024*100];
		//����int�ͱ�����¼ʵ�ʶ�ȡ�����ֽ���
		int len = 0 ;
		while((len=bis.read(buf))!=-1)
		{
			//�����ֽ����������������
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(src.getParent(),"part"+part)));
			bos.write(buf, 0, len);
			bos.flush();
			bos.close();
			part++;
		}
		bis.close();
	}

}
