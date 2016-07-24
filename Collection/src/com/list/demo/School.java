package com.list.demo;

import java.util.ArrayList;
import java.util.List;

public class School {
	private String name;// 名称

	public School(String name) {
		super();
		setName(name);
	}

	List tea = new ArrayList();// 创建集合对象

	public void addTeacher(Teacher t) {
		tea.add(t);// 在集合中添加对象
	}

	public List getTeacher()// 对外提供获取集合方法
	{
		return tea;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
