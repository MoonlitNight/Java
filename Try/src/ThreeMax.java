import java.util.Scanner;
public class ThreeMax {
	public static void main(String[] args) 
	{
		Scanner num=new Scanner(System.in);//����һ��Scanner��ʵ��
		System.out.println("����������������ÿ����һ����һ�»س�������");//��ӡ�����ʾ��Ϣ
		int num1=num.nextInt();//�����һ������
		int num2=num.nextInt();//����ڶ�������
		int num3=num.nextInt();//�������������
		System.out.println("���ֵΪ��"+compare(num1,num2,num3));//����compare�����������ֵ������ӡ���
		num.close();//�ر�ʵ��num������Դ
	}
	public static int compare(int x,int y,int z)//������̬����compare
	{
		int temp=(x>=y)?x:y;//������Ԫ������ж�xy�е����ֵ����ֵ��temp
		int max=(temp>=z)?temp:z;//������Ԫ������ж�temp��z�е����ֵ
		return max;//���ؼ��������ֵ
	}
}