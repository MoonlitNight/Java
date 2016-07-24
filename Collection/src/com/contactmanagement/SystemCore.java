package com.contactmanagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class SystemCore implements Serializable {
	/**
	 * ��Ӱ汾�ţ��ڳ����޸ĺ�ı���������Ȼ���Զ�ȡ
	 */
	private static final long serialVersionUID = -8311084443342781319L;
	Input input = new Input();// ����¼��
	/* ����TreeMap����ָ���Ƚ��������ַ������� ��������ʵ����Serializable�ӿ� */
	static Map<String, Person> data = new TreeMap<>();

	static {
		/* �������뱣����Ӳ���еļ������� */
		File src = new File("D:/test/test");
		if (src.exists()) {
			// ���������л�����
			ObjectInputStream ois;
			try {
				ois = new ObjectInputStream(new FileInputStream(src));
				// ��ȡ���󣬸�ֵ��date
				try {
					data = (Map<String, Person>) ois.readObject();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				ois.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/* ��ȡ��ϵ�˷��� */
	public Person person() {
		System.out.print("��������ϵ��������");
		String name = input.returnString();
		System.out.print("��������ϵ�����䣺");
		int age = input.returnInt();
		System.out.print("��������ϵ���Ա�");
		String sex = input.returnString();
		System.out.print("��������ϵ�˵绰��");
		String phone = input.returnString();
		System.out.print("��������ϵ�˵�ַ��");
		String address = input.returnString();
		System.out.print("��������ϵ��QQ��");
		String qq = input.returnString();
		System.out.print("��������ϵ�˵������䣺");
		String email = input.returnString();
		return new Person(name, age, sex, phone, address, qq, email);// ������ϵ�˶���
	}

	/* ���ڻ�ȡMap�洢���е�Ψһkeyֵ */
	public String key(Person p) {
		return p.getName() + "_" + p.getPhone();// �������͵绰�ַ���ʹ��"_"���Ӳ�����
	}

	/* �����ϵ�˷��� */
	public void add() {
		int oldSize = data.size();// ���漯�ϴ�Сֵ�������ж��Ƿ�洢�ɹ�
		Person p = person();// ��ȡ��ϵ�˶���
		data.put(key(p), p);// ����ϵ�˶���洢��Map������
		System.out.print("��ϵ�����");// ��ӡ
		if (data.size() > oldSize) // �ж��Ƿ�洢�ɹ�
		{
			System.out.println("�ɹ�");
		} else {
			System.out.println("ʧ��");
		}
	}

	/* �����û�¼����Ϣ��ȡMap����������ƥ���Key */
	public List<String> findKey() {
		Set<String> key = data.keySet();// ��ȡMap����������Key����
		List<String> temp = new ArrayList<>();// ������ʱ����
		System.out.print("��������ϵ����������룺");
		String in = input.returnString();// ��ȡ�û�¼���ַ�����Ϣ
		for (String str : key) {
			String[] s = str.split("_");// �и��ַ�����ȡname��phone��Ϣ
			/* �����ַ����ж�������Ϣ�Ƿ���� */
			for (int i = 0; i < s.length; i++) {
				if (in.equals(s[i])) // �ж��Ƿ����
				{
					temp.add(str);// ������key��Ϣ�洢����ʱ������
				}
			}
		}
		if (temp.size() != 0) {
			System.out.println("������ϵͳ������������Ϣƥ�����ϵ��");// ϵͳ��ʾ��Ϣ
			/* �������� */
			for (int i = 0; i < temp.size(); i++) {
				Person value = data.get(temp.get(i));// ��ȡkey����Ӧ��value
				System.out.println((i + 1) + "��" + value);// ��ӡѡ��
			}
		} else {
			System.out.println("δ�ҵ�ƥ����Ϣ����ϵ��");// ��ʾ��Ϣ
		}
		return temp.size() == 0 ? null : temp;
	}

	/* ɾ����ϵ�˷��� */
	public void delete() {
		List<String> key = findKey();
		if (key != null) {
			System.out.println("��ѡ����Ҫɾ������ϵ����ţ�");
			int n = input.returnInt();// ɨ���û�¼����Ϣ
			Person f = data.remove(key.get(n - 1));// ɾ��Map�����ж�Ӧ��key�Ͷ�Ӧ��value
			System.out.print("ɾ��");
			if (f != null) // ����ֵ��Ϊnull��ɾ����Ϣ�ɹ�
			{
				System.out.println("�ɹ�");
			} else {
				System.out.println("ʧ��");
			}
		}
	}

	/* ��ϵ���޸ķ��� */
	public void update() {
		List<String> key = findKey();
		if (key != null) {
			System.out.println("��ѡ����Ҫ�޸ĵ���ϵ����ţ�");
			int n = input.returnInt();// ɨ���û�¼����Ϣ
			Person p = data.get(key.get(n - 1));// ɾ��Map�����ж�Ӧ��key�Ͷ�Ӧ��value
			re(p);// ����re()�����޸���Ϣ
			System.out.println("�޸ĳɹ���");// �޸ĳɹ���ʾ��Ϣ
		}
	}

	/* ��ϵ���޸��ӷ������ڶԻ�ȡ������ϵ�˽�����Ϣ�޸� */
	public void re(Person p) {
		System.out.println("��ѡ����Ҫ�޸ĵ���Ϣ��");
		System.out.println("1���޸���ϵ�����䣺");
		System.out.println("2���޸���ϵ�˵绰��");
		System.out.println("3���޸���ϵ�˵�ַ��");
		System.out.println("4���޸���ϵ��QQ��");
		System.out.println("5���޸���ϵ�˵������䣺");
		switch (input.returnInt()) {
		case 1:
			System.out.print("���޸���ϵ�����䣺");
			p.setAge(input.returnInt());
			break;
		case 2:
			System.out.print("���޸���ϵ�˵绰��");
			p.setPhone(input.returnString());
			break;
		case 3:
			System.out.print("���޸���ϵ�˵�ַ��");
			p.setAddress(input.returnString());
			break;
		case 4:
			System.out.print("���޸���ϵ��QQ��");
			p.setQQ(input.returnString());
			break;
		case 5:
			System.out.print("���޸���ϵ�˵������䣺");
			p.setEmail(input.returnString());
			break;
		default:
			System.out.println("����������������룺");
			re(p);// �ݹ����
		}
	}

	/* ��ѯ������ϵ�˷��� */
	public void find() {
		Collection<Person> c = data.values();
		List<Person> temp = new ArrayList<>();
		System.out.println("��������ϵ�������Ϣ��");
		String next = input.returnString();// ¼���û�������Ϣ
		if (check(next) != null) // �ж�������Ϣ�Ƿ�Ϊ����ֵ
		{
			int n = check(next);// ��ֵ
			/* ������ȡ������ϵ�� */
			for (Person p : c) {
				if (n == p.getAge()) // �ж��Ƿ����
				{
					temp.add(p);// ���Ϊtrue����ϵ�˶�����ӵ���ʱ������
				}
			}
		} else {
			/* �������� */
			for (Person p : c) {
				/* �ж���ϵ���������Ƿ���������Ϣ */
				if (attribute(p).contains(next)) {
					temp.add(p);// ���Ϊtrue����ϵ�˶�����ӵ���ʱ������
				}
			}
		}
		if (temp.size() != 0) // �ж���ʱ�������Ƿ�����ϵ�˶���
		{
			System.out.println("�����ǲ��ҵ��������ϵ����Ϣ��");// ��ӡ��Ϣ
			/* ������ʱ���� */
			for (Person p : temp) {
				System.out.println(p);// ��ӡ���
			}
		} else {
			System.out.println("δ���ҵ������ϵ����Ϣ");// ���û����ϵ�˶������ӡ���δ�ҵ�
		}
	}

	/* ����ϵ���еĸ������Ա���Ϊ���� */
	public List<String> attribute(Person p) {
		List<String> temp = new ArrayList<>();
		temp.add(p.getName());
		temp.add(p.getSex());
		temp.add(p.getPhone());
		temp.add(p.getQQ());
		temp.add(p.getAddress());
		temp.add(p.getEmail());
		return temp;
	}

	/* �����ж�������Ϣ�Ƿ�Ϊ���䣬���򷵻�����ֵ������Ϊnull����������ֵ */
	public Integer check(String str) {
		if (str.matches("\\d{1,3}")) {
			return Integer.valueOf(str);
		}
		return null;
	}

	/* ��ѯ������ϵ�˷��� */
	public void findAllContact() {
		/* �������ϻ�ȡMap�����е�Key-valueӳ���ϵ */
		for (Entry<String, Person> en : data.entrySet()) {
			Person p = en.getValue();// ��ȡvalue
			System.out.println(p);// ��ӡ
		}
	}

	/* ���沢�˳����� */
	public void save() {
		try {
			store();// ���漯�϶���
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("��ϵ����Ϣ����ɹ�");
		System.out.println("=============ллʹ��ͨ��¼����ϵͳ=================");
		System.exit(0);// �˳�
	}

	/* �������е����ݱ�����洢�� */
	public void store() throws IOException {
		// �������л�����
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("D:/test/test")));
		// ����Map���϶���
		oos.writeObject(data);
		// �ر���
		oos.close();
	}
}
