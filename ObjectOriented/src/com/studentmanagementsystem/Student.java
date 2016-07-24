package com.studentmanagementsystem;

public class Student {
	private int id;
	private String name;
	private double score;

	Student() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	/* 重写 toString()方法返回对象属性字符串 */
	public String toString() {
		return "学号：" + this.id + "\t\t姓名：" + this.name + "\t\t成绩：" + this.score;
	}
}
