import java.util.Scanner;
public class Season {
	public static void main(String[] args) 
	{
		Scanner data=new Scanner(System.in);
		System.out.print("�������·ݣ�");
		int month=data.nextInt();
		switch(month)
		{
		   case 3:
		   case 4:
           case 5:System.out.println(month+"��Ϊ����");break;//Ϊ3��4��5��ʱ�Ǵ���
		   case 6:
		   case 7:
		   case 8:System.out.println(month+"��Ϊ�ļ�");break;//Ϊ6��7��8��ʱΪ�ļ�
           case 9:
           case 10:
           case 11:System.out.println(month+"��Ϊ�＾");break;//Ϊ9��10��11��ʱΪ�＾
           case 1:
		   case 2:
           case 12:System.out.println(month+"��Ϊ����");break;//Ϊ12��1��2��ʱΪ����
		   default:System.out.println("�����·ݴ���");//����ѡ��Ҳ��������ݴ���
		 }
		data.close();//�ر�ʵ��num������Դ
	}

}
