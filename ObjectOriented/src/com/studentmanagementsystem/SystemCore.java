package com.studentmanagementsystem;

public class SystemCore {
	private Student[] stuMag = null;
	private int index = 0;

	public Student[] getStuMag() {
		return stuMag;
	}

	public void setStuMag(int num) {
		this.stuMag = new Student[num];
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean storage(Student s) {
		int oldIndex = index;
		stuMag[index] = s;
		index++;
		return index > oldIndex;
	}

	public void defaultValue()// �ָ�Ĭ��ֵ
	{
		stuMag[index] = null;// ���ݳ�ʼ��
		index--;
	}

	public int findKey(int key)// ����ѭ����id���Һ���
	{
		for (int i = 0; i < index; i++)// ����������Ϣ�������в���
		{
			if (stuMag[i].getId() == key) // �ж��Ƿ����
				return i;// ���ҵ��򷵻�����ֵ
		}
		return -1;// ���Ҳ����򷵻�-1
	}

	public boolean re(int x, int id, String name, double score) {
		int temp = 0;
		stuMag[x].setId(id);
		stuMag[x].setName(name);
		stuMag[x].setScore(score);
		int flag = temp + 1;
		return flag > temp;
	}

	public void move(int x)// ��Ϣ�ƶ�����
	{
		for (int i = x; i < index - 1; i++) {
			transoposition(i);// ��λ
		}
		stuMag[index - 1] = null;// ɾ������
		index -= 1;
	}

	public void transoposition(int x)// ��λ����
	{
		Student temp = stuMag[x];
		stuMag[x] = stuMag[x + 1];
		stuMag[x + 1] = temp;// ��λ
	}

	public Student[] findName(String key)// ����ѭ�����������Һ���
	{
		Student[] temp = new Student[index];
		int x = 0;
		for (int i = 0; i < index; i++)// ����������Ϣ�������в���
		{
			if (key.equals(stuMag[i].getName())) // �ж��ַ����Ƿ����
			{
				temp[x] = stuMag[i];
				x++;
			}
		}
		return temp;
	}

	public Student[] copy()// ����������
	{
		Student[] temp = new Student[index];
		for (int i = 0; i < index; i++) {
			temp[i] = stuMag[i];
		}
		return temp;
	}

	public void sort(Student[] st)// sort�������������ð������
	{
		for (int i = 0; i < index - 1; i++)
			for (int j = 0; j < index - 1 - i; j++) {
				if (st[j].getScore() < st[j + 1].getScore()) {
					transoposition(j);
				}
			}
	}
}
