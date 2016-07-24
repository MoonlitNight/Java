package com.list.demo;

import java.util.Iterator;

public class Demo {
	public static void main(String[] args) {
		School s = new School("���д�ѧ");// ����ѧУʵ��
		Teacher t1 = new Teacher("�Դ�", 34);// ������ʦʵ��
		Teacher t2 = new Teacher("����", 32);// ������ʦʵ��
		t1.addStudent(new Student("����", 17));// Ϊ��ʦ���ѧ��
		t1.addStudent(new Student("Ǯ��", 18));// Ϊ��ʦ���ѧ��
		t2.addStudent(new Student("����", 19));// Ϊ��ʦ���ѧ��
		s.addTeacher(t1);// ��ѧУ�����ʦ
		s.addTeacher(t2);// ��ѧУ�����ʦ
		System.out.println(toString(s));// ������ת��Ϊ�ַ�������ӡ
	}

	public static String toString(School s) {
		StringBuilder sb = new StringBuilder();// �����ַ�������������
		sb.append(s.getName() + "��{");// ���
		for (Iterator it1 = s.getTeacher().iterator(); it1.hasNext();) {// ��ȡ��ʦ���ϲ�ʹ�õ�������������
			Teacher te = (Teacher) it1.next();// ��ȡ��Ԫ������ת��
			sb.append(te.getName() + "[");// ���
			for (Iterator it2 = te.getStudent().iterator(); it2.hasNext();) {// ��ȡѧ�����ϲ�ʹ�õ�������������
				Student st = (Student) it2.next();// ��ȡѧ��Ԫ�ز�����ת��
				sb.append(st.getName() + "��");// ���
			}
			sb.replace(sb.length() - 1, sb.length(), "]");// �޸����һ���ַ�;
			sb.append("��");// ����ַ�
		}
		sb.replace(sb.length() - 1, sb.length(), "}");// �޸�����һ���ַ�
		return sb.toString();// ת��Ϊ�ַ���������
	}

}
