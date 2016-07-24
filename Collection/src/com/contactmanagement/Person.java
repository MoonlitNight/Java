package com.contactmanagement;

import java.io.Serializable;

public class Person implements Serializable{
	/**
	 * 添加版本号，在程序修改后的本地数据依然可以读取
	 */
	private static final long serialVersionUID = 6476376490446887945L;
	//如果有不希望保存的变量，应加上瞬态关键字transient
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
		return "联系人 [姓名：" + name + "， 年龄：" + age + "， 性别：" + sex + "， 电话：" + phone + "，地址：" + address
				+ "，QQ：" + qq + "，电子邮箱：" + email + "]";
	}
	
}
