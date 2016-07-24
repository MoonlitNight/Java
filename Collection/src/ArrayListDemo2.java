import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Input {
	/* 返回扫描到的整型值 */
	public int returnInt() {
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}

	/* 返回扫描到的String类型值 */
	public String returnString() {
		Scanner input = new Scanner(System.in);
		return input.next();
	}
}

class Person {
	private String name;
	private int age;
	private String sex;
	private String phone;
	private String address;

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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
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

	/* 重写toString()方法 */
	public String toString() {
		return "[姓名=" + name + ", 年龄=" + age + ", 性别=" + sex + ", 电话：" + phone + ", 地址：" + address + "]";
	}
}

public class ArrayListDemo2 {
	public static void main(String[] args) {
		List list = new ArrayList();// 创建新集合
		list.add(p());// 添加一人
		list.add(p());// 添加
		list.add(p());// 添加
		Object[] obj = list.toArray();// 将集合转为数组
		for (int i = 0; i < obj.length; i++) {
			System.out.println(obj[i]);
		}

	}

	public static Person p() {
		/* 初始化对象并返回 */
		Person p = new Person();
		System.out.println("请输入姓名：");
		p.setName(new Input().returnString());
		System.out.println("请输入年龄：");
		p.setAge(new Input().returnInt());
		System.out.println("请输入性别：");
		p.setSex(new Input().returnString());
		System.out.println("请输入电话：");
		p.setPhone(new Input().returnString());
		System.out.println("请输入地址：");
		p.setAddress(new Input().returnString());
		return p;
	}
}
