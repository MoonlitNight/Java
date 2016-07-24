package com.contactmanagement;

import java.io.IOException;

public class ContactManagement {
	Input input = new Input();
	SystemCore core = new SystemCore();
	public static void main(String[] args) {
		System.out.println("=============欢迎使用通信录管理系统=================");
		new  ContactManagement().window();
	}
	//这个方法主要用来给用户显示各种操作的输入
	public void window(){
		while( true ){
			System.out.println("请选择操作的类型：");
			System.out.println("1、增加联系人：");
			System.out.println("2、删除联系人：");
			System.out.println("3、修改联系人：");
			System.out.println("4、查询单个联系人：");
			System.out.println("5、查询所有联系人：");
			System.out.println("6、退出");			
			//让用户输入对应的操作，获取并判断用户输入的操作类型,使用switch完成
			switch( input.returnInt() ){
				case 1:
					//处理增加联系人的功能
					core.add();
					break;
				case 2:
					//处理删除联系人的功能
					core.delete();
					break;
				case 3:
					//处理修改联系人的功能
					core.update();
					break;
				case 4:
					//处理查询单个联系人的功能
					core.find();
					break;
				case 5:
					//处理查询所有联系人的功能
					core.findAllContact();
					break;
				case 6:
					//退出
					core.save();
					return;
				default:
					System.out.println("输入的操作类型错误，请重新输入：");
			}
		}
	}
}

