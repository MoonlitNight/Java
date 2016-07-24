package com.studentmanagesystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class SystemCore implements Serializable {
	/**
	 * ��Ӱ汾�ţ��ڳ����޸ĺ�ı���������Ȼ���Զ�ȡ
	 */
	private static final long serialVersionUID = -2774847548741657131L;
	private static List<Student> stuMag = new ArrayList<Student>();// �������϶���洢ѧ������

	public List<Student> getStuMag() {
		return stuMag;
	}

	public void setStuMag(List<Student> stuMag) {
		this.stuMag = stuMag;
	}

	static {
		/* ���ڶ�ȡ���ش洢���� */
		File src = new File("D:/test/test");
		if (src.exists()) {
			ObjectInputStream ois;
			try {
				// ���������л�����
				ois = new ObjectInputStream(new FileInputStream(src));
				// ��ȡ����
				stuMag = (List<Student>) ois.readObject();
				// �ر���
				ois.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public boolean storage(Student s) {
		int index = stuMag.size();
		stuMag.add(s);
		return stuMag.size() > index;
	}

	public int findKey(int key)// ����ѭ����id���Һ���
	{
		for (Iterator<Student> it = stuMag.iterator(); it.hasNext();) {// ��������������
			Student s = it.next();
			if (s.getId() == key) // �ж��Ƿ����
				return stuMag.indexOf(s);// ���ҵ��򷵻�����ֵ
		} // ����������Ϣ�������в���
		return -1;// ���Ҳ����򷵻�-1
	}

	public boolean re(int x, int id, String name, double score) {// �޸�ѧ��������Ϣ
		int temp = 0;
		Student s = (Student) stuMag.get(x);
		s.setId(id);
		s.setName(name);
		s.setScore(score);
		int flag = temp + 1;
		return flag > temp;
	}

	public void move(int x)// ��Ϣ�ƶ�����
	{
		stuMag.remove(x);
	}

	public List<Student> findName(String key)// ����ѭ�����������Һ���
	{
		List<Student> temp = new ArrayList<Student>();// �������ϴ洢������ѧ������
		for (Iterator<Student> it = stuMag.iterator(); it.hasNext();) {// ����������
			Student s = it.next();
			if (key.equals(s.getName())) // �ж��ַ����Ƿ����
			{
				temp.add(s);// ��temp���������Ԫ��
			}
		}
		return temp;// ���ؼ���
	}

	public TreeSet<Student> sort()// �洢���ڴ洢ʱ����
	{
		TreeSet<Student> set = new TreeSet<Student>(new Comparator<Student>() {// ����TreeSet���ϣ�ʹ�ñȽ������бȽ�
			public int compare(Student s1, Student s2) {
				int flag = (int) ((s1.getScore() - s2.getScore()) * 100);
				return flag == 0 ? s1.getName().compareTo(s2.getName()) : flag;
			}
		});
		for (Iterator<Student> it = stuMag.iterator(); it.hasNext();) {// �������������ϲ��洢���¼���
			Student s = it.next();
			set.add(s);
		}
		return set;
	}

	// save()���������ڱ��ر���ϵͳ�е�����
	public void save() throws IOException {
		// �������л�����
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("D:/test/test")));
		// ����List���϶���
		oos.writeObject(stuMag);
		// �ر���
		oos.close();
	}
}
