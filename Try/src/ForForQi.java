
public class ForForQi {
		public static void main(String[] args) 
		{
			for(int i=1;i<=100;i++)//��for��ѭ���ж�1��100֮�����ֵ
			{
				if(i%10==0)
				{
					System.out.print(i+"\t");//���ʽ���������*
					System.out.println();//ÿʮ�����������
				}else if(i%7==0|(i%10==7&i/10==7))//�жϸ���ֵ�Ƿ���7�ı�������λ���к���7
				{
					System.out.print("*\t");//���ʽ���������*
				}else
				{
					System.out.print(i+"\t");//���ʽ���������*
				}
			}	
		}
}
