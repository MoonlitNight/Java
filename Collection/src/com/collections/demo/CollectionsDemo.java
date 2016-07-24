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
		Student s1 = new Student("��«��", 7);// ����ѧ������
		Student s2 = new Student("�����", 888);// ����ѧ������
		Student s3 = new Student("����", 99);// ����ѧ������
		List<Student> list = new ArrayList<>();// ����ArrayList���϶���
		list.add(s1);// ���Ԫ��
		list.add(s2);
		list.add(s3);
		// ʹ�ñȽ����Ƚ�Ԫ�����䣬���������ͬ��Ƚ���������ȡ����ѧ������
		Student max = Collections.max(list, new Comparator<Student>() {
			public int compare(Student stu1, Student stu2) {
				int temp = stu1.getAge() - stu2.getAge();
				return temp == 0 ? stu1.getName().compareTo(stu2.getName()) : temp;
			}
		});
		System.out.println(max);// ��ӡ���
	}

}
