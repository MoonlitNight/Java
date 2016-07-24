package com.tcpfile.demo;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {

	public static void main(String[] args) throws Exception {
		//�����ͻ���Socket����
		Socket s = new Socket("192.168.0.102",9201);
		//��ȡ���������
		OutputStream os =s.getOutputStream();
		//������������ȡ��������
		FileInputStream fii = new FileInputStream("D:/Test/test.txt");
		//�����ֽ�����
		byte [] b = new byte [1024] ;
		int len = 0;
		while((len = fii.read(b))!=-1)
		{
			os.write(b, 0, len);//д������
		}
		//�ͻ������ݷ�����ɣ��跢�ͱ�Ǳ�ʾ�Ѿ������������
		s.shutdownOutput();
		fii.close();//�رն�ȡ��
		/*�����ǽ��շ���������*/
		//��ȡ����������
		InputStream is = s.getInputStream();
		//�����������ڴ洢����
		byte [] buf = new byte [1024];
		//���ֽ�����תΪ�ַ���
		String str = new String(buf,0,is.read(buf));
		//��ӡ�ַ���
		System.out.println(str);
		s.close();
	}

}
