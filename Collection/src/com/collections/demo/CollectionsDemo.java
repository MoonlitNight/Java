package com.collections.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
	private String name;
	private int age;

	public Student(String name, int age) {
		super();
		setName(name);
		setAge(age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String toString() {
		return "Studnet [name=" + name + ", age=" + age + "]";
	}

}

public class CollectionsDemo {

	public static void main(String[] args) {
		Student s1 = new Student("葫芦娃", 7);// 创建学生对象
		Student s2 = new Student("孙悟空", 888);// 创建学生对象
		Student s3 = new Student("超人", 99);// 创建学生对象
		List<Student> list = new ArrayList<>();// 创建ArrayList集合对象
		list.add(s1);// 添加元素
		list.add(s2);
		list.add(s3);
		// 使用比较器比较元素年龄，如果年龄相同则比较姓名，获取最大的学生对象
		Student max = Collections.max(list, new Comparator<Student>() {
			public int compare(Student stu1, Student stu2) {
				int temp = stu1.getAge() - stu2.getAge();
				return temp == 0 ? stu1.getName().compareTo(stu2.getName()) : temp;
			}
		});
		System.out.println(max);// 打印输出
	}

}
