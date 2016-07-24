package demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Person {
	private String name;
	private int age;
	private char sex;
	private String phone;
	private String address;

	public Person(String name, int age, char sex, String phone, String address) {
		this.setName(name);
		this.setAge(age);
		this.setSex(sex);
		this.setPhone(phone);
		this.setAddress(address);
	}

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

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
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
}

public class ArrayListDemo3 {
	public static void main(String[] args) {
		List list = new ArrayList();// �����¼���
		Person p1 = new Person("�Դ�", 23, '0', "132", "����һ��");// ��������
		Person p2 = new Person("����", 21, 'Ů', "133", "����һ��");
		Person p3 = new Person("����", 16, '��', "134", "����һ��");
		list.add(p1);// ���һ��
		list.add(p2);// ���
		list.add(p3);// ���
		for (Iterator it = list.iterator(); it.hasNext();) {// ʹ�õ�������������
			Person p = (Person) it.next();// ����ת��
			if (p.getAge() < 20) {// �ж������Ƿ�С��20��
				it.remove();// true ��ɾ���ö��󲢽�������ѭ��
				continue;
			} else if (p.getSex() != '��' || p.getSex() != 'Ů') {// �ж�sex�Ƿ���ȷ����
				p.setSex('��');// false������Ĭ��ֵ��
			}
			System.out.println(toString(p));// ��ӡ
		}
	}

	private static String toString(Person p) {
		StringBuilder sb = new StringBuilder();// �����ַ�������������
		sb.append("[����=" + p.getName() + ", ����=" + p.getAge() + ", �Ա�=" + p.getSex() + ", �绰��" + p.getPhone() + ", ��ַ��"
				+ p.getAddress() + "]");// �����Ϣ
		return sb.toString();// �����ַ���
	}

}
