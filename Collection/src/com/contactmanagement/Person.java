package com.contactmanagement;

import java.io.Serializable;

public class Person implements Serializable{
	/**
	 * ��Ӱ汾�ţ��ڳ����޸ĺ�ı���������Ȼ���Զ�ȡ
	 */
	private static final long serialVersionUID = 6476376490446887945L;
	//����в�ϣ������ı�����Ӧ����˲̬�ؼ���transient
	private String name;
	private int age;
	private String sex;
	private String phone;
	private String address;
	private String qq;
	private String email;
	public Person(String name, int age, String sex, String phone, String address, String qq, String email) {
		super();
		setName(name);
		setAge(age);
		setSex(sex);
		setPhone(phone);
		setAddress(address);
		setQQ(qq);
		setEmail(email);
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the qq
	 */
	public String getQQ() {
		return qq;
	}
	/**
	 * @param qq the qq to set
	 */
	public void setQQ(String qq) {
		this.qq = qq;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "��ϵ�� [������" + name + "�� ���䣺" + age + "�� �Ա�" + sex + "�� �绰��" + phone + "����ַ��" + address
				+ "��QQ��" + qq + "���������䣺" + email + "]";
	}
	
}
