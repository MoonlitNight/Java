
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Car {
	private String name;
	private String colour;

	public String getName() {
		return name;
	}

	public Car(String name, String colour) {
		super();
		setName(name);
		setColour(colour);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public String toString() {
		return "Car [name=" + name + ", colour=" + colour + "]";
	}

	/* 重写equals()方法，并判断是否Car类型，不是抛出运行时异常，是则判断对象是否相同 */
	public boolean equals(Object obj) {
		if (!(obj instanceof Car)) {
			throw new RuntimeException("类型不匹配");
		}
		Car c = (Car) obj;
		return this.name == c.name && this.colour == c.colour;
	}

}

public class ArrayListDemo3 {
	public static void main(String[] args) {
		/* 创建ArrayList对象 */
		List arrayList = new ArrayList();
		/* 添加元素 */
		arrayList.add(new Car("法拉利", "红"));
		arrayList.add(new Car("保时捷", "蓝"));
		arrayList.add(new Car("法拉利", "红"));
		arrayList.add(new Car("奇瑞QQ", "绿"));
		arrayList.add(new Car("保时捷", "红"));
		/* 调用check()方法遍历查询重复的元素并将不重复的元素存入新数组 */
		arrayList = Check(arrayList);
		/* 迭代器遍历输出元素 */
		for (Iterator it = arrayList.iterator(); it.hasNext();) {
			Car c = (Car) it.next();// 向下转型
			System.out.println(c);
		}

	}

	private static List Check(List list) {
		List temp = new ArrayList();// 创建ArrayList集合对象temp
		/* 遍历检索元素，未重复的元素存入temp集合 */
		for (Iterator it = list.iterator(); it.hasNext();) {
			Object obj = it.next();
			if (!temp.contains(obj)) // 调用contains()方法判断temp集合中是否含有同样的元素
			{
				temp.add(obj);// false则添加该元素到temp中
			}
		}
		return temp;
	}
}
