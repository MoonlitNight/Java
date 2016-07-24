package com.studentmanagesystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class SystemCore implements Serializable {
	/**
	 * 添加版本号，在程序修改后的本地数据依然可以读取
	 */
	private static final long serialVersionUID = -2774847548741657131L;
	private static List<Student> stuMag = new ArrayList<Student>();// 创建集合对象存储学生对象

	public List<Student> getStuMag() {
		return stuMag;
	}

	public void setStuMag(List<Student> stuMag) {
		this.stuMag = stuMag;
	}

	static {
		/* 用于读取本地存储数据 */
		File src = new File("D:/test/test");
		if (src.exists()) {
			ObjectInputStream ois;
			try {
				// 创建反序列化对象
				ois = new ObjectInputStream(new FileInputStream(src));
				// 读取数据
				stuMag = (List<Student>) ois.readObject();
				// 关闭流
				ois.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public boolean storage(Student s) {
		int index = stuMag.size();
		stuMag.add(s);
		return stuMag.size() > index;
	}

	public int findKey(int key)// 数组循环按id查找函数
	{
		for (Iterator<Student> it = stuMag.iterator(); it.hasNext();) {// 迭代器遍历集合
			Student s = it.next();
			if (s.getId() == key) // 判断是否相等
				return stuMag.indexOf(s);// 查找到则返回索引值
		} // 根据输入信息数量进行查找
		return -1;// 查找不到则返回-1
	}

	public boolean re(int x, int id, String name, double score) {// 修改学生对象信息
		int temp = 0;
		Student s = (Student) stuMag.get(x);
		s.setId(id);
		s.setName(name);
		s.setScore(score);
		int flag = temp + 1;
		return flag > temp;
	}

	public void move(int x)// 信息移动函数
	{
		stuMag.remove(x);
	}

	public List<Student> findName(String key)// 数组循环按姓名查找函数
	{
		List<Student> temp = new ArrayList<Student>();// 创建集合存储重名的学生对象
		for (Iterator<Student> it = stuMag.iterator(); it.hasNext();) {// 迭代器遍历
			Student s = it.next();
			if (key.equals(s.getName())) // 判断字符串是否相等
			{
				temp.add(s);// 向temp集合中添加元素
			}
		}
		return temp;// 返回集合
	}

	public TreeSet<Student> sort()// 存储并在存储时排序
	{
		TreeSet<Student> set = new TreeSet<Student>(new Comparator<Student>() {// 创建TreeSet集合，使用比较器进行比较
			public int compare(Student s1, Student s2) {
				int flag = (int) ((s1.getScore() - s2.getScore()) * 100);
				return flag == 0 ? s1.getName().compareTo(s2.getName()) : flag;
			}
		});
		for (Iterator<Student> it = stuMag.iterator(); it.hasNext();) {// 迭代器遍历集合并存储进新集合
			Student s = it.next();
			set.add(s);
		}
		return set;
	}

	// save()方法用于在本地保存系统中的数据
	public void save() throws IOException {
		// 创建序列化对象
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("D:/test/test")));
		// 保存List集合对象
		oos.writeObject(stuMag);
		// 关闭流
		oos.close();
	}
}
