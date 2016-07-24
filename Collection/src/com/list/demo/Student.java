package com.list.demo;

class Student {
	private String name;
	private int age;

	public Student(String name, int age) {// 构造函数初始化学生对象
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
}
