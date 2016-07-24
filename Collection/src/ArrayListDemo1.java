
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo1 {
	public static void main(String[] args) {
		/* 创建ArrayList对象 */
		List arrayList = new ArrayList();
		/* 添加元素 */
		arrayList.add("JAVA");
		arrayList.add("C++");
		arrayList.add("IOS");
		arrayList.add("C");
		arrayList.add("JAVA");
		arrayList.add("Hello World!");
		arrayList.add("JAVA");
		/* 调用check()方法遍历查询重复的元素并将不重复的元素存入新数组 */
		arrayList = Check(arrayList);
		/* 迭代器遍历输出元素 */
		for (Iterator it = arrayList.iterator(); it.hasNext();) {
			System.out.println(it.next());
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
