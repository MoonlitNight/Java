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

	public void defaultValue()// 恢复默认值
	{
		stuMag[index] = null;// 数据初始化
		index--;
	}

	public int findKey(int key)// 数组循环按id查找函数
	{
		for (int i = 0; i < index; i++)// 根据输入信息数量进行查找
		{
			if (stuMag[i].getId() == key) // 判断是否相等
				return i;// 查找到则返回索引值
		}
		return -1;// 查找不到则返回-1
	}

	public boolean re(int x, int id, String name, double score) {
		int temp = 0;
		stuMag[x].setId(id);
		stuMag[x].setName(name);
		stuMag[x].setScore(score);
		int flag = temp + 1;
		return flag > temp;
	}

	public void move(int x)// 信息移动函数
	{
		for (int i = x; i < index - 1; i++) {
			transoposition(i);// 换位
		}
		stuMag[index - 1] = null;// 删除数据
		index -= 1;
	}

	public void transoposition(int x)// 换位函数
	{
		Student temp = stuMag[x];
		stuMag[x] = stuMag[x + 1];
		stuMag[x + 1] = temp;// 换位
	}

	public Student[] findName(String key)// 数组循环按姓名查找函数
	{
		Student[] temp = new Student[index];
		int x = 0;
		for (int i = 0; i < index; i++)// 根据输入信息数量进行查找
		{
			if (key.equals(stuMag[i].getName())) // 判断字符串是否相等
			{
				temp[x] = stuMag[i];
				x++;
			}
		}
		return temp;
	}

	public Student[] copy()// 创建新数组
	{
		Student[] temp = new Student[index];
		for (int i = 0; i < index; i++) {
			temp[i] = stuMag[i];
		}
		return temp;
	}

	public void sort(Student[] st)// sort方法对数组进行冒泡排序
	{
		for (int i = 0; i < index - 1; i++)
			for (int j = 0; j < index - 1 - i; j++) {
				if (st[j].getScore() < st[j + 1].getScore()) {
					transoposition(j);
				}
			}
	}
}
