
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo1 {
	public static void main(String[] args) {
		/* ����ArrayList���� */
		List arrayList = new ArrayList();
		/* ���Ԫ�� */
		arrayList.add("JAVA");
		arrayList.add("C++");
		arrayList.add("IOS");
		arrayList.add("C");
		arrayList.add("JAVA");
		arrayList.add("Hello World!");
		arrayList.add("JAVA");
		/* ����check()����������ѯ�ظ���Ԫ�ز������ظ���Ԫ�ش��������� */
		arrayList = Check(arrayList);
		/* �������������Ԫ�� */
		for (Iterator it = arrayList.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}

	}

	private static List Check(List list) {
		List temp = new ArrayList();// ����ArrayList���϶���temp
		/* ��������Ԫ�أ�δ�ظ���Ԫ�ش���temp���� */
		for (Iterator it = list.iterator(); it.hasNext();) {
			Object obj = it.next();
			if (!temp.contains(obj)) // ����contains()�����ж�temp�������Ƿ���ͬ����Ԫ��
			{
				temp.add(obj);// false����Ӹ�Ԫ�ص�temp��
			}
		}
		return temp;
	}
}
