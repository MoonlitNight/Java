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

	/* ��д toString()�������ض��������ַ��� */
	public String toString() {
		return "ѧ�ţ�" + this.id + "\t\t������" + this.name + "\t\t�ɼ���" + this.score;
	}
}
