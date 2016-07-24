package com.list.demo;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
	private String name;
	private int age;

	public Teacher(String name, int age) {
		super();
		setName(name);
		setAge(age);
	}

	List stu = new ArrayList();// 创建集合对象

	public void addStudent(Student s) {
		stu.add(s);// 添加元素
	}

	public List getStudent() {
		return stu;// 对外提供获取集合接口
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

}
