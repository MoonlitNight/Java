public class Zi {
	public static void main(String[] args)
	{
		char zi='D';//����һ���ַ��ͱ�������ֵ
		if(zi>='0'&zi<='9')//�жϸ��ַ��Ƿ�Ϊ�����ַ�
		{
			System.out.println(zi+"�ַ�Ϊ����");//��ӡ���
		}else if(zi>='A'&zi<='Z')//�жϸ��ַ��Ƿ�Ϊ��дӢ���ַ�
		{
			System.out.println(zi+"�ַ�Ϊ��дӢ����ĸ");//��ӡ���
		}else if(zi>='a'&zi<='z')//�жϸ��ַ��Ƿ�ΪСдӢ���ַ�
		{
			System.out.println(zi+"�ַ�ΪСдӢ����ĸ");//��ӡ���
		}else
		    System.out.println(zi+"�ַ�Ϊ�����ַ�");//��ӡ���
	}
}
