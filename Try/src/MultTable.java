import java.util.Scanner;
public class MultTable {
	public static void main(String[] args) 
	{
		Scanner data=new Scanner(System.in);//����һ��Scanner��ʵ��
		System.out.println("��������Ҫ��ӡ���׳˷���");//��ӡ�����ʾ��Ϣ
		int num=data.nextInt();//�����������ݸ�ֵ��num
		mult(num);//���÷���nult
		data.close();//�ر�ʵ��date������Դ
	}
	public static void mult(int x)//������̬����mult
	{
		for(int i=1;i<=x;i++)//��������
		{
		 for(int j=1;j<=i;j++)//��������
		 {
			 System.out.print(j+"*"+i+"="+i*j+"\t");//��ӡ���
		 }
		 System.out.println();//����
		}	
	}
}
