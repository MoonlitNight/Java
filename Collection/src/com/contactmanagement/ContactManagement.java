package com.contactmanagement;

import java.io.IOException;

public class ContactManagement {
	Input input = new Input();
	SystemCore core = new SystemCore();
	public static void main(String[] args) {
		System.out.println("=============��ӭʹ��ͨ��¼����ϵͳ=================");
		new  ContactManagement().window();
	}
	//���������Ҫ�������û���ʾ���ֲ���������
	public void window(){
		while( true ){
			System.out.println("��ѡ����������ͣ�");
			System.out.println("1��������ϵ�ˣ�");
			System.out.println("2��ɾ����ϵ�ˣ�");
			System.out.println("3���޸���ϵ�ˣ�");
			System.out.println("4����ѯ������ϵ�ˣ�");
			System.out.println("5����ѯ������ϵ�ˣ�");
			System.out.println("6���˳�");			
			//���û������Ӧ�Ĳ�������ȡ���ж��û�����Ĳ�������,ʹ��switch���
			switch( input.returnInt() ){
				case 1:
					//����������ϵ�˵Ĺ���
					core.add();
					break;
				case 2:
					//����ɾ����ϵ�˵Ĺ���
					core.delete();
					break;
				case 3:
					//�����޸���ϵ�˵Ĺ���
					core.update();
					break;
				case 4:
					//�����ѯ������ϵ�˵Ĺ���
					core.find();
					break;
				case 5:
					//�����ѯ������ϵ�˵Ĺ���
					core.findAllContact();
					break;
				case 6:
					//�˳�
					core.save();
					return;
				default:
					System.out.println("����Ĳ������ʹ������������룺");
			}
		}
	}
}

