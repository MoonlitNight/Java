package com.properties.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo {

	public static void main(String[] args) {

		try {
			// ��Properties�����е�key-valueд���ļ���
			write();
			// ʹ��Properties���϶�ȡ����
			read();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void read() throws IOException {
		// ����Properties���϶���
		Properties p = new Properties();
		// ʹ��Properties���϶�ȡ����
		p.load(new FileInputStream(new File("D:/test/test")));
		// ��ȡ�����е�key
		Set<Object> set = p.keySet();
		for (Object key : set) {
			Object value = p.get(key);
			System.out.println("key=" + key + "---" + "value=" + value);
		}

	}

	private static void write() throws IOException {
		// ����Properties���϶���
		Properties p = new Properties();
		// �򼯺������Ԫ�ء������е�key��valueֻ�����ַ���
		p.put("����", "�Ϻ�");
		p.put("����", "����");
		// �������е�����д�뵽�ļ�
		p.store(new FileOutputStream(new File("D:/test/test")), "����סַ��Ϣ");
	}
}
