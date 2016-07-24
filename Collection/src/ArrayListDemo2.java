import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Input {
	/* ����ɨ�赽������ֵ */
	public int returnInt() {
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}

	/* ����ɨ�赽��String����ֵ */
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

	/* ��дtoString()���� */
	public String toString() {
		return "[����=" + name + ", ����=" + age + ", �Ա�=" + sex + ", �绰��" + phone + ", ��ַ��" + address + "]";
	}
}

public class ArrayListDemo2 {
	public static void main(String[] args) {
		List list = new ArrayList();// �����¼���
		list.add(p());// ���һ��
		list.add(p());// ���
		list.add(p());// ���
		Object[] obj = list.toArray();// ������תΪ����
		for (int i = 0; i < obj.length; i++) {
			System.out.println(obj[i]);
		}

	}

	public static Person p() {
		/* ��ʼ�����󲢷��� */
		Person p = new Person();
		System.out.println("������������");
		p.setName(new Input().returnString());
		System.out.println("���������䣺");
		p.setAge(new Input().returnInt());
		System.out.println("�������Ա�");
		p.setSex(new Input().returnString());
		System.out.println("������绰��");
		p.setPhone(new Input().returnString());
		System.out.println("�������ַ��");
		p.setAddress(new Input().returnString());
		return p;
	}
}
