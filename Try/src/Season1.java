import java.util.Scanner;
public class Season1 {
	public static void main(String[] args) 
	{
		Scanner data=new Scanner(System.in);
		System.out.print("�������·ݣ�");
		int month=data.nextInt();
		if(month>12||month<1)//�ж��·ݴ���12����С��1
		{
	    	System.out.println(month+"�����·ݴ���");//����������������ݴ���
	    }else if(month>2&&month<6)
	    {
	    	System.out.println(month+"��Ϊ����");//Ϊ3��4��5��ʱ�Ǵ���
	    }else if(month>5&&month<9)//����Ϊ6��7��8��ʱΪ�ļ�
	    {
	    	System.out.println(month+"��Ϊ�ļ�");	
	    }else if(month>8&&month<12)
	    {
	    	System.out.println(month+"��Ϊ�＾");//Ϊ9��10��11��ʱΪ�＾
	    }else 
	        System.out.println(month+"��Ϊ����");//����Ϊ����
		data.close();
	}
}
