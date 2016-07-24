
import java.util.LinkedList;

class Stack {
	private LinkedList linkList = new LinkedList();// 创建Linked集合对象

	public void add(Object obj)// 向集合头部中添加元素
	{
		linkList.addFirst(obj);
	}

	public Object getElement()// 从集合头部开始取出元素
	{
		return linkList.removeFirst();
	}

	public boolean isNull()// 判断集合是否为空
	{
		return linkList.isEmpty();
	}
}

public class LinkedSetDemo {
	public static void main(String[] args) {
		Stack s = new Stack();
		s.add("小米");
		s.add("华为");
		s.add("魅族");
		while (!s.isNull()) {
			System.out.println(s.getElement());// 打印
		}
	}
}
