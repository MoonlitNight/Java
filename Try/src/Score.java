import java.util.Scanner;
public class Score {
	public static void main(String[] args) 
	{
		Scanner data=new Scanner(System.in);
		System.out.print("������ѧ��������");
		int score=data.nextInt();//�������α���score��ֵ����ʾѧ������
		char grade='E';//�����ַ��ͱ���grade��ŵȼ���Ϣ
		if(score>=0&score<=100)//�ж�����ɼ���Χ�Ƿ����Ҫ��
		{	
		  switch(score/10)//�򻯳ɼ��ж�
		 {
		   case 10:
		   case 9:grade='A';break;//��������grade��ֵΪ�ַ�A
           case 8:grade='B';break;//��������grade��ֵΪ�ַ�B
		   case 7:grade='C';break;//��������grade��ֵΪ�ַ�C
		   case 6:grade='D';break;//��������grade��ֵΪ�ַ�D
		   default:;//Ĭ��ΪE
         }
		   System.out.println("�ɼ��ȼ�Ϊ"+grade);//��ӡ����ȼ���Ϣ
		}else   System.out.println("������0~100�ڵĳɼ���Ϣ");//��ӡ���
		data.close();
	}
}
