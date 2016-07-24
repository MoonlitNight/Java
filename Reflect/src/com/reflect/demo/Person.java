package com.reflect.demo;

public class Person {
	private String name;
	private int age;
	char sex; 
	public static int phone;
	public Person() {
		// TODO Auto-generated constructor stub
	}
	private Person(String name) {
		super();
		this.name = name;
	}
	public Person(String name, int age, char sex) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	public void show()
	{
		System.out.println("public show");
	}
	private void show2(int x)
	{
		System.out.println("private show2");
	}
	static void show3()
	{
		System.out.println("static show3");
	}
}
