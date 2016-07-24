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
		if (!(o instanceof Person)) // 判断类型是否为Person
		{
			throw new RuntimeException("类型不匹配");// 不是则抛出异常
		}
		Person p = (Person) o;// 向下转型
		int flag=p.getAge() - this.getAge();
		if(flag==0)//判断如果年龄相同则比较姓名
		{
			flag=p.name.compareTo(this.name);
		}
		return flag;// 返回
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

	/* 重写toString()方法 */
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}

public class SetDemo1 {
	public static void main(String[] args) {
		Set set = new TreeSet();// 创建TreeSet集合
		set.add(new Person("葫芦娃", 7));// 添加元素
		set.add(new Person("奥特曼", 999));// 添加元素
		set.add(new Person("超人", 166));// 添加元素
		set.add(new Person("钢铁侠", 46));// 添加元素
		/* 使用迭代器遍历集合 */
		for (Iterator it = set.iterator(); it.hasNext();) {
			Person obj = (Person) it.next();// 获取迭代的元素
			System.out.println(obj);// 打印
		}
	}

}
