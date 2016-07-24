package com.string.demo;

/*����Student��*/
class Student {
	private String name;// ����
	private int age;// ����
	private char sex;// �Ա�
	private String address;// ��ַ
	/* ���캯����ʼ��Student���� */

	Student(String name, int age, char sex, String address) {
		setName(name);// ����setName()������������
		setAge(age);// ����setAge()������������
		setSex(sex);// ����setSex()���������Ա�
		setAddress(address);// ����setAddress()�������õ�ַ
	}

	/* getName()���������ṩ��ȡnameֵ���� */
	public String getName() {
		return name;
	}

	/* setName()���������ṩ����nameֵ���� */
	public void setName(String name) {
		this.name = name;
	}

	/* getAge()���������ṩ��ȡageֵ���� */
	public int getAge() {
		return age;
	}

	/* setAge()���������ṩ��ȡageֵ���� */
	public void setAge(int age) {
		this.age = age;
	}

	/* getSex()���������ṩ��ȡSexֵ���� */
	public char getSex() {
		return sex;
	}

	/* setSex()���������ṩ����sexֵ���� */
	public void setSex(char sex) {
		this.sex = sex;
	}

	/* getAddress()���������ṩ��ȡaddressֵ���� */
	public String getAddress() {
		return address;
	}

	/* setAddress()���������ṩ��ȡaddressֵ���� */
	public void setAddress(String address) {
		this.address = address;
	}

	/* toString()�������ض��������ַ��� */
	public String toString() {
		return "name=\"" + this.name + "\"," + "age=" + this.age + ",sex='" + this.sex + "',address=\"" + this.address
				+ "\"";
	}
}

public class SringDemo11 {

	public static void main(String[] args) {
		Student stu1 = new Student("�Դ�", 16, '��', "����һ��");// ��������stu1
		Student stu2 = new Student("Ǯ��", 17, '��', "���ж���");// ��������stu2
		Student stu3 = new Student("����", 18, '��', "��������");// ��������stu3
		String[] array = { stu1.toString(), stu2.toString(), stu3.toString() };// ����String���齫���������ַ�������
		//String str = stuToString(array);// ���÷��������ַ���
	//	System.out.println(str);// �����ӡ
		System.out.println(stu1);// �����ӡ

	}

	/* stuToString()���������������ַ��� */
	public static String stuToString(String[] str) {
		StringBuilder sb = new StringBuilder();// ����StringBuilder�ַ�������������
		for (int i = 0; i < str.length; i++) {
			if (i == 0) {
				sb.append("{[" + str[i] + "],");
			} else if (i == str.length - 1) {
				sb.append("[" + str[i] + "]}");
			} else {
				sb.append("[" + str[i] + "],");
			}
		}
		return sb.toString();
	}
}
