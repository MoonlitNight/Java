import java.util.Scanner;
public class ToString {
	public static void main(String[] args) {
		Scanner data=new Scanner(System.in);//����һ��Scanner��ʵ��
		System.out.println("��������Ҫת�������������");//��ӡ�����ʾ��Ϣ
		int x=data.nextInt();//ɨ��¼���ֵ��������x
		int[] array=new int [x];//��ʼ����������
		System.out.println("��������������ݣ�");//��ӡ�����ʾ��Ϣ
		for(int i=0;i<array.length;i++)//ѭ��¼�����������
		{
			array[i]=data.nextInt();//��ֵ������
		}
		String str=toString(array);//����toString����
		System.out.println("�����Ϊ��"+str);//�����ӡת������ַ���
    	data.close();//�ر�ʵ��date������Դ
	}
	public static String toString(int[] array) //���巽��toString
	{
		String str="";//������Ҫ���ص��ַ���������ʼ��
		for(int i=0;i<array.length;i++)//forѭ�������������ݵĴ���
		{
			if(i<array.length-1)//��������������һ��ֵ�����һ��"-"�ַ�
			{
			str=str+array[i]+"-";//�㷨
			}else str=str+array[array.length-1];//�����һ���򲻼ӡ�-��
		}
		return str;//�����ַ���
	}
}
