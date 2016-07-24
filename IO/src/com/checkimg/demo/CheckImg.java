package com.checkimg.demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;

public class CheckImg {

	public static void main(String[] args) {
		try {
			checkimg(180,40);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void checkimg(int width, int height) throws IOException {
		//����һ�����ڴ洢ͼƬ���ݵĻ���������
		BufferedImage bufi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		//��ȡ2D��ͼ����
		Graphics g = bufi.getGraphics();
		//���û���Ϊ��ɫ
		g.setColor(Color.WHITE);
		//��䱳��
		g.fillRect(0, 0, width, height);
		//���߿�
		g.drawRect(0, 0, width-1, height-1);
		//��������
		g.setFont(new Font("����",Font.BOLD,30));
		//����һ�����������
		Random r = new Random();
		int x = 15 ;
		for (int i = 0; i < 4; i++) {
			g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));//����������ɫ
			String str = getGBK();
			g.drawString(str, x , 30);//����д��ͼƬ����
			x+=40;
		}
		//���ɸ�����
		for (int i = 0; i < 10 ; i++) {
			g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));//���û�����ɫ
			g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));//�ߵ���ʼλ�úͽ���λ�����
		}
		//��ͼƬ������������д�뵽�ļ���
		ImageIO.write(bufi,"jpg", new FileOutputStream("D:/test/������֤��.jpg"));	
	}
	private static String getGBK() {
		//����ʱ�����ֵ����һ�������������
		Random r = new Random(new Date().getTime());
		String str = null;
		int high,low;//�������ߵ�λ
		high = 129 + Math.abs(r.nextInt(31));//GBK����λ��Χ
		low =  64 + Math.abs(r.nextInt(190));//GBK����λ��Χ
		byte [] b = new byte [2];
		b[0] = new Integer(high).byteValue();
		b[1] = new Integer(low).byteValue();
		try {
			str = new String(b,"GBK");//��GBK�����תΪ����
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;	
	}
/*	//ͨ��Unicode����������ȡ�����ַ�
	private static char getUnicode() {
	 	//����ʱ�����ֵ����һ�������������
		Random r = new Random(new Date().getTime());
		int unicode = 0x9fa5 - 0x4e00 + 1;
		return (char)r.nextInt(unicode);		
	}*/
}
