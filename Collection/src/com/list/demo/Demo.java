package com.list.demo;

import java.util.Iterator;

public class Demo {
	public static void main(String[] args) {
		School s = new School("乌有大学");// 创建学校实例
		Teacher t1 = new Teacher("赵大", 34);// 创建老师实例
		Teacher t2 = new Teacher("王二", 32);// 创建老师实例
		t1.addStudent(new Student("李四", 17));// 为老师添加学生
		t1.addStudent(new Student("钱五", 18));// 为老师添加学生
		t2.addStudent(new Student("张三", 19));// 为老师添加学生
		s.addTeacher(t1);// 向学校添加老师
		s.addTeacher(t2);// 向学校添加老师
		System.out.println(toString(s));// 将对象转换为字符串并打印
	}

	public static String toString(School s) {
		StringBuilder sb = new StringBuilder();// 创建字符串缓冲区对象
		sb.append(s.getName() + "：{");// 添加
		for (Iterator it1 = s.getTeacher().iterator(); it1.hasNext();) {// 获取老师集合并使用迭代器遍历集合
			Teacher te = (Teacher) it1.next();// 获取到元素向下转型
			sb.append(te.getName() + "[");// 添加
			for (Iterator it2 = te.getStudent().iterator(); it2.hasNext();) {// 获取学生集合并使用迭代器遍历集合
				Student st = (Student) it2.next();// 获取学生元素并向下转型
				sb.append(st.getName() + "、");// 添加
			}
			sb.replace(sb.length() - 1, sb.length(), "]");// 修改最后一个字符;
			sb.append("，");// 添加字符
		}
		sb.replace(sb.length() - 1, sb.length(), "}");// 修改最后的一个字符
		return sb.toString();// 转换为字符串并返回
	}

}
