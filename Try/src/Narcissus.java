
public class Narcissus {
	public static void main(String[] args) 
	{
		System.out.println("���е�ˮ�ɻ���λ��");//�����ʾ��Ϣ
	 	for(int i=100;i<1000;i++)
		{
		   int G=0,S=0,B=0;//�������α���GSK�ֱ�Ϊ��λʮλ��λ
		   G=i%10;//�����λ��ֵ
		   S=i/10%10;//����ʮλ����ֵ
		   B=i/100%10;  //�����λ����ֵ
		   if(i==(power(G,3)+power(S,3)+power(B,3)))//�ж��Ƿ����ˮ�ɻ���������
		   {
			   System.out.print(i+"\t");//���ֵ
		   }		   
		}	
	}
	public static int power(int i,int j)//���巽��������x��y�η�
	{
		int k=1;
		for(int x=j;x>=1;x--)
		{
			j--;	
			k=k*i; 
		}return k;
	}
}
