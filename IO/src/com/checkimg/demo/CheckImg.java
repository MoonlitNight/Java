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
		//创建一个用于存储图片数据的缓冲区对象
		BufferedImage bufi = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		//获取2D绘图对象
		Graphics g = bufi.getGraphics();
		//设置画笔为白色
		g.setColor(Color.WHITE);
		//填充背景
		g.fillRect(0, 0, width, height);
		//画边框、
		g.drawRect(0, 0, width-1, height-1);
		//设置字体
		g.setFont(new Font("宋体",Font.BOLD,30));
		//创建一个随机数对象
		Random r = new Random();
		int x = 15 ;
		for (int i = 0; i < 4; i++) {
			g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));//设置字体颜色
			String str = getGBK();
			g.drawString(str, x , 30);//把字写入图片数据
			x+=40;
		}
		//生成干扰线
		for (int i = 0; i < 10 ; i++) {
			g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));//设置画线颜色
			g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));//线的起始位置和结束位置随机
		}
		//把图片缓冲区的数据写入到文件中
		ImageIO.write(bufi,"jpg", new FileOutputStream("D:/test/中文验证码.jpg"));	
	}
	private static String getGBK() {
		//根据时间毫秒值创建一个随机数生成器
		Random r = new Random(new Date().getTime());
		String str = null;
		int high,low;//设置码表高低位
		high = 129 + Math.abs(r.nextInt(31));//GBK码表高位范围
		low =  64 + Math.abs(r.nextInt(190));//GBK码表低位范围
		byte [] b = new byte [2];
		b[0] = new Integer(high).byteValue();
		b[1] = new Integer(low).byteValue();
		try {
			str = new String(b,"GBK");//按GBK编码表转为中文
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;	
	}
/*	//通过Unicode编码表随机获取中文字符
	private static char getUnicode() {
	 	//根据时间毫秒值创建一个随机数生成器
		Random r = new Random(new Date().getTime());
		int unicode = 0x9fa5 - 0x4e00 + 1;
		return (char)r.nextInt(unicode);		
	}*/
}
