package com.studentmanagementsystem;

public class ManagementSystem {
	Input input = new Input();
	SystemCore core = new SystemCore();

	public static void main(String[] args) {
		new ManagementSystem().Initialization();
	}

	private void Initialization() {
		println("��ʼ������ϵͳ�洢�����������벢���س�ȷ�ϣ�");
		core.setStuMag(input.returnInt());
		choose();// ���ù��ܺ���
	}

	private void choose() {
		while (true) {
			show(1);// ��ʾ����
			switch (input.returnInt()) {
			case 1:
				add();
				break;// ����ֵΪ1ʱ�������ѧ����Ϣ����
			case 2:
				revised();
				break;// ����ֵΪ2ʱ�����޸Ĺ���
			case 3:
				del();
				break;// ����ֵΪ3ʱ����ɾ������
			case 4:
				search();
				break;// ����ֵΪ4ʱ���ü�������
			case 5:
				System.exit(0);
				break;// �����˳�����
			default:
				println("������Ϣ������������");
				choose();// ����ֵ���󣬷��ع���ѡ�����
			}
		}
	}

	public void show(int x)// ���湦�ܲ���
	{
		String s1 = "\n******************************ѧ������ϵͳ******************************\n" + "1�����ѧ����Ϣ\n"
				+ "2���޸�ѧ����Ϣ\n" + "3��ɾ��ѧ����Ϣ\n" + "4����ѯѧ����Ϣ\n" + "5���˳�����ϵͳ\n"
				+ "**************************************************************************";
		String s2 = "\n ******************************��ѯѧ����Ϣ******************************\n" + "1����ѯȫ��ѧ����Ϣ\n"
				+ "2����ѧ�Ų�ѯѧ����Ϣ\n" + "3����������ѯѧ����Ϣ\n" + "4����ѧ���ɼ���ʾѧ����Ϣ������\n"
				+ "***************************************************************************";
		if (x == 1) {
			println(s1);
		} else {
			println(s2);
		}
	}

	public void println(Student stu)// ��ӡ��Ϣ
	{
		System.out.println(stu);
	}

	public void println(String str)// ��ӡ��Ϣ
	{
		System.out.println(str);
	}

	public void print(String str)// ��ӡ��Ϣ
	{
		System.out.print(str);
	}

	public void add()// �����Ϣ���ܺ���
	{
		Student s = new Student();
		println("******************************���ѧ����Ϣ******************************");// ��ӡ���
		print("������ѧ��ѧ�ţ�");// ��ӡ���
		s.setId(input.returnInt());// �趨ѧ����Ϣ
		print("������ѧ��������");
		s.setName(input.returnString());// �趨������Ϣ
		print("������ѧ���ɼ���");// ��ӡ���
		s.setScore(input.returnDouble());// �趨������Ϣ
		boolean flag = core.storage(s);
		if (flag) // �ж���Ϣ�洢�Ƿ�ɹ�
		{
			println("ѧ����Ϣ������");
		} else {
			core.defaultValue();// �����Ϲ���ָ�Ĭ��ֵ
			println("ѧ����Ϣ��Ӵ�������������");// ��ӡ��Ϣ
		}
		println("**************************************************************************");
	}

	public void revised()// ��Ϣ�޸ĺ���
	{
		println("������ѧ�Ž�����Ϣ�޸�");
		int date = core.findKey(input.returnInt());// ���ò��Һ��������ز��ҵ�������ֵ
		if (date >= 0) // �ж�ֵ�Ƿ��ҵ�
		{
			print("������ѧ�ţ�");// ��ӡ���
			int id = input.returnInt();// ¼��ѧ����Ϣ��Ž�����
			print("������������");
			String name = input.returnString();// ¼��������Ϣ��Ž�����
			print("������ɼ���");// ��ӡ���
			double score = input.returnDouble();// ¼�������Ϣ��Ž�����
			boolean flag = core.re(date, id, name, score);
			if (flag) // �ж���Ϣ�Ƿ��޸ĳɹ�
			{
				println("��Ϣ�޸����");
			} else {
				println("ѧ����Ϣ�޸Ĵ�������������");// ��ӡ������Ϣ
			}
		} else {
			println("δ�ҵ���ѧ��ѧ����Ϣ����˶Ժ�����"); // ���û�ҵ�����ʾδ�ҵ�
		}
	}

	public void del()// ��Ϣɾ������
	{
		System.out.println("������ѧ��");
		int data = core.findKey(input.returnInt());// ���ò��Һ��������ز��ҵ�������ֵ
		if (data >= 0) // �ж��Ƿ��ҵ�
		{
			core.move(data);// ����Ҫɾ�����ƶ������һλ���ָ�Ĭ��ֵ���Ǳ�index��
			println("ѧ����Ϣ��ɾ��");// ��ӡ��Ϣ
		} else {
			println("δ�ҵ���ѧ��ѧ����Ϣ����˶Ժ�����");// ���û�ҵ�����ʾδ�ҵ�
		}
	}

	// ��Ӽ������ܣ����󣬸���¼����ֵ���жϲ�ѯ��ʽ���������Ӧ��Ϣ
	// �޷�����ֵ
	public void search()// ��Ϣ��������
	{
		show(2);
		println("��ѡ���ѯ��ʽ");// ��ӡ�����Ϣ
		switch (input.returnInt()) {
		case 1:
			searchAll();
			break;// ����ֵΪ1ʱ��ѯȫ��ѧ����Ϣ
		case 2:
			searchById();
			break;// ����ֵΪ2ʱ��ѧ�Ų�ѯѧ����Ϣ
		case 3:
			searchByName();
			break;// ����ֵΪ3ʱ��������ѯѧ����Ϣ
		case 4:
			searchDown();
			break;// ����ֵΪ4ʱ��ѧ���ɼ���ʾѧ����Ϣ������
		default:
			println("������Ϣ������������");
		}
	}

	public void searchAll() {
		for (int i = 0; i < core.getIndex(); i++) {
			println(core.getStuMag()[i]);
		}
	}

	public void searchById() {
		println("������ѧ��ѧ�ţ�");
		int data = core.findKey(input.returnInt());// ���ò��Һ��������ز��ҵ�������ֵ
		if (data >= 0) // �ж�ֵ�Ƿ����
		{
			println(core.getStuMag()[data]); // �����Ϣ
		} else {
			println("δ�ҵ���ѧ��ѧ����Ϣ����˶Ժ�����");// ���û�ҵ�����ʾδ�ҵ�
		}
	}

	public void searchByName() {
		System.out.println("������ѧ��������");
		Student[] x = core.findName(input.returnString());
		if (x[0] == null) {
			println("δ�ҵ���ѧ��ѧ����Ϣ����˶Ժ�����");// ���û�ҵ�����ʾδ�ҵ�
		} else {
			for (int i = 0; i < x.length; i++) {
				if (x[i] != null) {
					println(x[i]);
				} else {
					break;
				}
			}
		}
		choose();
	}

	public void searchDown() {
		Student[] copy = core.copy();// ���������飬����󲻸ı�ԭ�����ݴ洢
		core.sort(copy);// ����ð��������
		for (int i = 0; i < copy.length; i++)// ������ӡ���
		{
			System.out.println(copy[i]);// ��ӡ
		}
	}
}
