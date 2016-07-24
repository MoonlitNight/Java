package com.studentmanagementsystem;

public class ManagementSystem {
	Input input = new Input();
	SystemCore core = new SystemCore();

	public static void main(String[] args) {
		new ManagementSystem().Initialization();
	}

	private void Initialization() {
		println("初始化管理系统存储容量，请输入并按回车确认：");
		core.setStuMag(input.returnInt());
		choose();// 调用功能函数
	}

	private void choose() {
		while (true) {
			show(1);// 显示界面
			switch (input.returnInt()) {
			case 1:
				add();
				break;// 输入值为1时调用添加学生信息功能
			case 2:
				revised();
				break;// 输入值为2时调用修改功能
			case 3:
				del();
				break;// 输入值为3时调用删除功能
			case 4:
				search();
				break;// 输入值为4时调用检索功能
			case 5:
				System.exit(0);
				break;// 正常退出程序
			default:
				println("输入信息错误请新输入");
				choose();// 输入值错误，返回管理选择界面
			}
		}
	}

	public void show(int x)// 界面功能部分
	{
		String s1 = "\n******************************学生管理系统******************************\n" + "1、添加学生信息\n"
				+ "2、修改学生信息\n" + "3、删除学生信息\n" + "4、查询学生信息\n" + "5、退出管理系统\n"
				+ "**************************************************************************";
		String s2 = "\n ******************************查询学生信息******************************\n" + "1、查询全部学生信息\n"
				+ "2、按学号查询学生信息\n" + "3、按姓名查询学生信息\n" + "4、按学生成绩显示学生信息（降序）\n"
				+ "***************************************************************************";
		if (x == 1) {
			println(s1);
		} else {
			println(s2);
		}
	}

	public void println(Student stu)// 打印信息
	{
		System.out.println(stu);
	}

	public void println(String str)// 打印信息
	{
		System.out.println(str);
	}

	public void print(String str)// 打印信息
	{
		System.out.print(str);
	}

	public void add()// 添加信息功能函数
	{
		Student s = new Student();
		println("******************************添加学生信息******************************");// 打印输出
		print("请输入学生学号：");// 打印输出
		s.setId(input.returnInt());// 设定学号信息
		print("请输入学生姓名：");
		s.setName(input.returnString());// 设定姓名信息
		print("请输入学生成绩：");// 打印输出
		s.setScore(input.returnDouble());// 设定分数信息
		boolean flag = core.storage(s);
		if (flag) // 判断信息存储是否成功
		{
			println("学生信息添加完成");
		} else {
			core.defaultValue();// 不符合规则恢复默认值
			println("学生信息添加错误请重新输入");// 打印信息
		}
		println("**************************************************************************");
	}

	public void revised()// 信息修改函数
	{
		println("请输入学号进行信息修改");
		int date = core.findKey(input.returnInt());// 调用查找函数，返回查找到的索引值
		if (date >= 0) // 判断值是否找到
		{
			print("请输入学号：");// 打印输出
			int id = input.returnInt();// 录入学号信息存放进数组
			print("请输入姓名：");
			String name = input.returnString();// 录入姓名信息存放进数组
			print("请输入成绩：");// 打印输出
			double score = input.returnDouble();// 录入分数信息存放进数组
			boolean flag = core.re(date, id, name, score);
			if (flag) // 判断信息是否修改成功
			{
				println("信息修改完成");
			} else {
				println("学生信息修改错误请重新输入");// 打印错误信息
			}
		} else {
			println("未找到该学号学生信息，请核对后再输"); // 如果没找到，提示未找到
		}
	}

	public void del()// 信息删除函数
	{
		System.out.println("请输入学号");
		int data = core.findKey(input.returnInt());// 调用查找函数，返回查找到的索引值
		if (data >= 0) // 判断是否找到
		{
			core.move(data);// 把需要删除的移动到最后一位并恢复默认值，角标index从
			println("学生信息已删除");// 打印信息
		} else {
			println("未找到该学号学生信息，请核对后再输");// 如果没找到，提示未找到
		}
	}

	// 添加检索功能，需求，根据录入数值，判断查询方式，并输出相应信息
	// 无返回数值
	public void search()// 信息检索函数
	{
		show(2);
		println("请选择查询方式");// 打印输出信息
		switch (input.returnInt()) {
		case 1:
			searchAll();
			break;// 输入值为1时查询全部学生信息
		case 2:
			searchById();
			break;// 输入值为2时按学号查询学生信息
		case 3:
			searchByName();
			break;// 输入值为3时按姓名查询学生信息
		case 4:
			searchDown();
			break;// 输入值为4时按学生成绩显示学生信息（降序）
		default:
			println("输入信息错误请新输入");
		}
	}

	public void searchAll() {
		for (int i = 0; i < core.getIndex(); i++) {
			println(core.getStuMag()[i]);
		}
	}

	public void searchById() {
		println("请输入学生学号：");
		int data = core.findKey(input.returnInt());// 调用查找函数，返回查找到的索引值
		if (data >= 0) // 判断值是否相等
		{
			println(core.getStuMag()[data]); // 输出信息
		} else {
			println("未找到该学号学生信息，请核对后再输");// 如果没找到，提示未找到
		}
	}

	public void searchByName() {
		System.out.println("请输入学生姓名：");
		Student[] x = core.findName(input.returnString());
		if (x[0] == null) {
			println("未找到该学号学生信息，请核对后再输");// 如果没找到，提示未找到
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
		Student[] copy = core.copy();// 定义新数组，排序后不改变原有数据存储
		core.sort(copy);// 调用冒泡排序函数
		for (int i = 0; i < copy.length; i++)// 遍历打印输出
		{
			System.out.println(copy[i]);// 打印
		}
	}
}
