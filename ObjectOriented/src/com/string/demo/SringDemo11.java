package com.string.demo;

/*定义Student类*/
class Student {
	private String name;// 姓名
	private int age;// 年龄
	private char sex;// 性别
	private String address;// 地址
	/* 构造函数初始化Student对象 */

	Student(String name, int age, char sex, String address) {
		setName(name);// 调用setName()方法设置姓名
		setAge(age);// 调用setAge()方法设置年龄
		setSex(sex);// 调用setSex()方法设置性别
		setAddress(address);// 调用setAddress()方法设置地址
	}

	/* getName()方法对外提供获取name值方法 */
	public String getName() {
		return name;
	}

	/* setName()方法对外提供设置name值方法 */
	public void setName(String name) {
		this.name = name;
	}

	/* getAge()方法对外提供获取age值方法 */
	public int getAge() {
		return age;
	}

	/* setAge()方法对外提供获取age值方法 */
	public void setAge(int age) {
		this.age = age;
	}

	/* getSex()方法对外提供获取Sex值方法 */
	public char getSex() {
		return sex;
	}

	/* setSex()方法对外提供设置sex值方法 */
	public void setSex(char sex) {
		this.sex = sex;
	}

	/* getAddress()方法对外提供获取address值方法 */
	public String getAddress() {
		return address;
	}

	/* setAddress()方法对外提供获取address值方法 */
	public void setAddress(String address) {
		this.address = address;
	}

	/* toString()方法返回对象属性字符串 */
	public String toString() {
		return "name=\"" + this.name + "\"," + "age=" + this.age + ",sex='" + this.sex + "',address=\"" + this.address
				+ "\"";
	}
}

public class SringDemo11 {

	public static void main(String[] args) {
		Student stu1 = new Student("赵大", 16, '男', "乌有一号");// 创建对象stu1
		Student stu2 = new Student("钱二", 17, '男', "乌有二号");// 创建对象stu2
		Student stu3 = new Student("李三", 18, '男', "乌有三号");// 创建对象stu3
		String[] array = { stu1.toString(), stu2.toString(), stu3.toString() };// 创建String数组将对象属性字符串保存
		//String str = stuToString(array);// 调用方法连接字符串
	//	System.out.println(str);// 输出打印
		System.out.println(stu1);// 输出打印

	}

	/* stuToString()方法按规律连接字符串 */
	public static String stuToString(String[] str) {
		StringBuilder sb = new StringBuilder();// 创建StringBuilder字符串缓冲区对象
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
