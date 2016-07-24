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
			// 把Properties集合中的key-value写入文件中
			write();
			// 使用Properties集合读取数据
			read();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void read() throws IOException {
		// 创建Properties集合对象
		Properties p = new Properties();
		// 使用Properties集合读取数据
		p.load(new FileInputStream(new File("D:/test/test")));
		// 获取集合中的key
		Set<Object> set = p.keySet();
		for (Object key : set) {
			Object value = p.get(key);
			System.out.println("key=" + key + "---" + "value=" + value);
		}

	}

	private static void write() throws IOException {
		// 创建Properties集合对象
		Properties p = new Properties();
		// 向集合中添加元素。集合中的key和value只能是字符串
		p.put("张三", "上海");
		p.put("李四", "北京");
		// 将集合中的数据写入到文件
		p.store(new FileOutputStream(new File("D:/test/test")), "保存住址信息");
	}
}
