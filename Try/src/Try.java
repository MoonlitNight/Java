import java.util.Scanner; 
public class Try {
	public static void main(String[] args)
	{
		Scanner data=new Scanner(System.in);
		System.out.print("��������ݣ�");
		int year=data.nextInt();//�������α���year
		if((year%4==0&&year%100!=0)||(year%400==0))//�ж�year�Ƿ��ܱ�4���������ܱ�100������400����
		{
			System.out.println(year+"��������");//������Ϊtrue���������ӡʱ����
		}
		else
			System.out.println(year+"�겻������");//������Ϊfalse���������ӡʱ������
        data.close();
	}
}
