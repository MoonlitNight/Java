package com.list.demo;

import java.util.ArrayList;
import java.util.List;

public class School {
	private String name;// ����

	public School(String name) {
		super();
		setName(name);
	}

	List tea = new ArrayList();// �������϶���

	public void addTeacher(Teacher t) {
		tea.add(t);// �ڼ�������Ӷ���
	}

	public List getTeacher()// �����ṩ��ȡ���Ϸ���
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
