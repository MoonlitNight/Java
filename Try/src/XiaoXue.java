
public class XiaoXue {
	public static void main(String[] args) 
	{
		int rabbit=0,chicken=0,foot=94,head=35;//��ʼ�����ͱ������������Ӻͼ�������������ź�ͷ������
		for(chicken=1;chicken<=35;chicken++)//����forѭ���������жϼ�������
		{
		 rabbit=head-chicken;//���㵱ǰֵ�����ӵ�����
		 if(foot==chicken*2+rabbit*4)//�ж��Ƿ��������
		 {
			 System.out.println("���ӹ���"+rabbit+"ֻ"+"��������"+chicken+"ֻ"); //�����������ӡ������
		 }	
		}	
	}
}
