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
	 * 添加版本号，在程序修改后的本地数据依然可以读取
	 */
	private static final long serialVersionUID = -8311084443342781319L;
	Input input = new Input();// 键盘录入
	/* 创建TreeMap对象，指定比较器按照字符串排序 。集合已实现了Serializable接口 */
	static Map<String, Person> data = new TreeMap<>();

	static {
		/* 用于载入保存在硬盘中的集合数据 */
		File src = new File("D:/test/test");
		if (src.exists()) {
			// 创建反序列化对象
			ObjectInputStream ois;
			try {
				ois = new ObjectInputStream(new FileInputStream(src));
				// 读取对象，赋值给date
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

	/* 获取联系人方法 */
	public Person person() {
		System.out.print("请输入联系人姓名：");
		String name = input.returnString();
		System.out.print("请输入联系人年龄：");
		int age = input.returnInt();
		System.out.print("请输入联系人性别：");
		String sex = input.returnString();
		System.out.print("请输入联系人电话：");
		String phone = input.returnString();
		System.out.print("请输入联系人地址：");
		String address = input.returnString();
		System.out.print("请输入联系人QQ：");
		String qq = input.returnString();
		System.out.print("请输入联系人电子邮箱：");
		String email = input.returnString();
		return new Person(name, age, sex, phone, address, qq, email);// 返回联系人对象
	}

	/* 用于获取Map存储序列的唯一key值 */
	public String key(Person p) {
		return p.getName() + "_" + p.getPhone();// 将姓名和电话字符串使用"_"连接并返回
	}

	/* 添加联系人方法 */
	public void add() {
		int oldSize = data.size();// 保存集合大小值，用于判断是否存储成功
		Person p = person();// 获取联系人对象
		data.put(key(p), p);// 将联系人对象存储在Map集合中
		System.out.print("联系人添加");// 打印
		if (data.size() > oldSize) // 判断是否存储成功
		{
			System.out.println("成功");
		} else {
			System.out.println("失败");
		}
	}

	/* 根据用户录入信息获取Map集合中所有匹配的Key */
	public List<String> findKey() {
		Set<String> key = data.keySet();// 获取Map集合中所有Key集合
		List<String> temp = new ArrayList<>();// 定义临时集合
		System.out.print("请输入联系人姓名或号码：");
		String in = input.returnString();// 获取用户录入字符串信息
		for (String str : key) {
			String[] s = str.split("_");// 切割字符串获取name和phone信息
			/* 遍历字符串判断输入信息是否存在 */
			for (int i = 0; i < s.length; i++) {
				if (in.equals(s[i])) // 判断是否符合
				{
					temp.add(str);// 符合则将key信息存储在临时集合中
				}
			}
		}
		if (temp.size() != 0) {
			System.out.println("以下是系统中与您输入信息匹配的联系人");// 系统提示信息
			/* 遍历集合 */
			for (int i = 0; i < temp.size(); i++) {
				Person value = data.get(temp.get(i));// 获取key所对应的value
				System.out.println((i + 1) + "：" + value);// 打印选项
			}
		} else {
			System.out.println("未找到匹配信息的联系人");// 提示信息
		}
		return temp.size() == 0 ? null : temp;
	}

	/* 删除联系人方法 */
	public void delete() {
		List<String> key = findKey();
		if (key != null) {
			System.out.println("请选择需要删除的联系人序号：");
			int n = input.returnInt();// 扫描用户录入信息
			Person f = data.remove(key.get(n - 1));// 删除Map集合中对应的key和对应的value
			System.out.print("删除");
			if (f != null) // 返回值不为null则删除信息成功
			{
				System.out.println("成功");
			} else {
				System.out.println("失败");
			}
		}
	}

	/* 联系人修改方法 */
	public void update() {
		List<String> key = findKey();
		if (key != null) {
			System.out.println("请选择需要修改的联系人序号：");
			int n = input.returnInt();// 扫描用户录入信息
			Person p = data.get(key.get(n - 1));// 删除Map集合中对应的key和对应的value
			re(p);// 调用re()方法修改信息
			System.out.println("修改成功！");// 修改成功提示信息
		}
	}

	/* 联系人修改子方法用于对获取到的联系人进行信息修改 */
	public void re(Person p) {
		System.out.println("请选择需要修改的信息：");
		System.out.println("1、修改联系人年龄：");
		System.out.println("2、修改联系人电话：");
		System.out.println("3、修改联系人地址：");
		System.out.println("4、修改联系人QQ：");
		System.out.println("5、修改联系人电子邮箱：");
		switch (input.returnInt()) {
		case 1:
			System.out.print("请修改联系人年龄：");
			p.setAge(input.returnInt());
			break;
		case 2:
			System.out.print("请修改联系人电话：");
			p.setPhone(input.returnString());
			break;
		case 3:
			System.out.print("请修改联系人地址：");
			p.setAddress(input.returnString());
			break;
		case 4:
			System.out.print("请修改联系人QQ：");
			p.setQQ(input.returnString());
			break;
		case 5:
			System.out.print("请修改联系人电子邮箱：");
			p.setEmail(input.returnString());
			break;
		default:
			System.out.println("输入错误，请重新输入：");
			re(p);// 递归调用
		}
	}

	/* 查询单个联系人方法 */
	public void find() {
		Collection<Person> c = data.values();
		List<Person> temp = new ArrayList<>();
		System.out.println("请输入联系人相关信息：");
		String next = input.returnString();// 录入用户输入信息
		if (check(next) != null) // 判断输入信息是否为年龄值
		{
			int n = check(next);// 赋值
			/* 遍历获取到的联系人 */
			for (Person p : c) {
				if (n == p.getAge()) // 判断是否相等
				{
					temp.add(p);// 结果为true则将联系人对象添加到临时集合中
				}
			}
		} else {
			/* 遍历集合 */
			for (Person p : c) {
				/* 判断联系人属性中是否含有输入信息 */
				if (attribute(p).contains(next)) {
					temp.add(p);// 结果为true则将联系人对象添加到临时集合中
				}
			}
		}
		if (temp.size() != 0) // 判断临时集合中是否含有联系人对象
		{
			System.out.println("以下是查找到的相关联系人信息：");// 打印信息
			/* 变量临时集合 */
			for (Person p : temp) {
				System.out.println(p);// 打印输出
			}
		} else {
			System.out.println("未查找到相关联系人信息");// 如果没有联系人对象则打印输出未找到
		}
	}

	/* 将联系人中的各项属性保存为集合 */
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

	/* 用于判断输入信息是否为年龄，是则返回年龄值，返回为null不属于年龄值 */
	public Integer check(String str) {
		if (str.matches("\\d{1,3}")) {
			return Integer.valueOf(str);
		}
		return null;
	}

	/* 查询所有联系人方法 */
	public void findAllContact() {
		/* 遍历集合获取Map集合中的Key-value映射关系 */
		for (Entry<String, Person> en : data.entrySet()) {
			Person p = en.getValue();// 获取value
			System.out.println(p);// 打印
		}
	}

	/* 保存并退出功能 */
	public void save() {
		try {
			store();// 保存集合对象
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("联系人信息保存成功");
		System.out.println("=============谢谢使用通信录管理系统=================");
		System.exit(0);// 退出
	}

	/* 将集合中的数据保存外存储器 */
	public void store() throws IOException {
		// 创建序列化对象
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("D:/test/test")));
		// 保存Map集合对象
		oos.writeObject(data);
		// 关闭流
		oos.close();
	}
}
