package com.set.demo;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

class Person implements Comparable {
	private String name;
	private int age;

	public Person(String name, int age) {
		super();
		setName(name);
		setAge(age);
	}

	public int compareTo(Object o) {
		if (!(o instanceof Person)) // �ж������Ƿ�ΪPerson
		{
			throw new RuntimeException("���Ͳ�ƥ��");// �������׳��쳣
		}
		Person p = (Person) o;// ����ת��
		int flag=p.getAge() - this.getAge();
		if(flag==0)//�ж����������ͬ��Ƚ�����
		{
			flag=p.name.compareTo(this.name);
		}
		return flag;// ����
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

	/* ��дtoString()���� */
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}

public class SetDemo1 {
	public static void main(String[] args) {
		Set set = new TreeSet();// ����TreeSet����
		set.add(new Person("��«��", 7));// ���Ԫ��
		set.add(new Person("������", 999));// ���Ԫ��
		set.add(new Person("����", 166));// ���Ԫ��
		set.add(new Person("������", 46));// ���Ԫ��
		/* ʹ�õ������������� */
		for (Iterator it = set.iterator(); it.hasNext();) {
			Person obj = (Person) it.next();// ��ȡ������Ԫ��
			System.out.println(obj);// ��ӡ
		}
	}

}
