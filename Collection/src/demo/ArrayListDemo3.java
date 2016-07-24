package demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Person {
	private String name;
	private int age;
	private char sex;
	private String phone;
	private String address;

	public Person(String name, int age, char sex, String phone, String address) {
		this.setName(name);
		this.setAge(age);
		this.setSex(sex);
		this.setPhone(phone);
		this.setAddress(address);
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

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}

public class ArrayListDemo3 {
	public static void main(String[] args) {
		List list = new ArrayList();// 创建新集合
		Person p1 = new Person("赵大", 23, '0', "132", "乌有一村");// 创建对象
		Person p2 = new Person("丽丽", 21, '女', "133", "乌有一村");
		Person p3 = new Person("李四", 16, '男', "134", "乌有一村");
		list.add(p1);// 添加一人
		list.add(p2);// 添加
		list.add(p3);// 添加
		for (Iterator it = list.iterator(); it.hasNext();) {// 使用迭代器遍历集合
			Person p = (Person) it.next();// 向下转型
			if (p.getAge() < 20) {// 判断年龄是否小于20岁
				it.remove();// true 则删除该对象并结束本次循环
				continue;
			} else if (p.getSex() != '男' || p.getSex() != '女') {// 判断sex是否正确设置
				p.setSex('男');// false则设置默认值男
			}
			System.out.println(toString(p));// 打印
		}
	}

	private static String toString(Person p) {
		StringBuilder sb = new StringBuilder();// 创建字符串缓冲区对象
		sb.append("[姓名=" + p.getName() + ", 年龄=" + p.getAge() + ", 性别=" + p.getSex() + ", 电话：" + p.getPhone() + ", 地址："
				+ p.getAddress() + "]");// 添加信息
		return sb.toString();// 返回字符串
	}

}
