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

	List stu = new ArrayList();// �������϶���

	public void addStudent(Student s) {
		stu.add(s);// ���Ԫ��
	}

	public List getStudent() {
		return stu;// �����ṩ��ȡ���Ͻӿ�
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
