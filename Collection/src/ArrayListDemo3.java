
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

	/* ��дequals()���������ж��Ƿ�Car���ͣ������׳�����ʱ�쳣�������ж϶����Ƿ���ͬ */
	public boolean equals(Object obj) {
		if (!(obj instanceof Car)) {
			throw new RuntimeException("���Ͳ�ƥ��");
		}
		Car c = (Car) obj;
		return this.name == c.name && this.colour == c.colour;
	}

}

public class ArrayListDemo3 {
	public static void main(String[] args) {
		/* ����ArrayList���� */
		List arrayList = new ArrayList();
		/* ���Ԫ�� */
		arrayList.add(new Car("������", "��"));
		arrayList.add(new Car("��ʱ��", "��"));
		arrayList.add(new Car("������", "��"));
		arrayList.add(new Car("����QQ", "��"));
		arrayList.add(new Car("��ʱ��", "��"));
		/* ����check()����������ѯ�ظ���Ԫ�ز������ظ���Ԫ�ش��������� */
		arrayList = Check(arrayList);
		/* �������������Ԫ�� */
		for (Iterator it = arrayList.iterator(); it.hasNext();) {
			Car c = (Car) it.next();// ����ת��
			System.out.println(c);
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
