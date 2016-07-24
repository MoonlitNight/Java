
import java.util.LinkedList;

class Stack {
	private LinkedList linkList = new LinkedList();// ����Linked���϶���

	public void add(Object obj)// �򼯺�ͷ�������Ԫ��
	{
		linkList.addFirst(obj);
	}

	public Object getElement()// �Ӽ���ͷ����ʼȡ��Ԫ��
	{
		return linkList.removeFirst();
	}

	public boolean isNull()// �жϼ����Ƿ�Ϊ��
	{
		return linkList.isEmpty();
	}
}

public class LinkedSetDemo {
	public static void main(String[] args) {
		Stack s = new Stack();
		s.add("С��");
		s.add("��Ϊ");
		s.add("����");
		while (!s.isNull()) {
			System.out.println(s.getElement());// ��ӡ
		}
	}
}
