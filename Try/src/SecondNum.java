import java.util.Scanner;//������
public class SecondNum 
{
	public static void main(String[] args) 
	{
		Scanner data=new Scanner(System.in);//����һ��Scanner��ʵ��
        System.out.println("��������Ҫ���ҵ�Ԫ��");//��ӡ�����ʾ��Ϣ
		int num=data.nextInt();//ɨ��¼�븳ֵ������num
		int []  array = {12,34,23,13,45,23,9};//�����������鲢��ʼ��ֵ
		int index=index(array,num,0);//����index�������ҵ�һ�γ��ֵ�����λ��
		if(index==-1)//�������ֵΪ-1
		{
		System.out.println("��Ԫ��δ�ҵ�");//��ӡδ�ҵ���Ԫ��
		}else if(index>=0)//�������ֵ��Ϊ0˵���ҵ���Ԫ�ص�����ֵ
		{
			System.out.println("��Ԫ�س��ֵ������ǣ�"+index+"��"+"��Ԫ��Ϊarray["+index+"]="+array[index]);//�����һ�γ��ֵ�����λ�ò������Ԫ�ص�ֵ
			int index1=index(array,num,index+1);//����index�������еڶ��β���
			if(index1==-1)//�������ֵΪ-1
				{
				System.out.println("��Ԫ��δ���ֵڶ���");//��ӡδ�ҵ���Ԫ��
				}else if(index>=0)//�������ֵ��Ϊ0˵���ҵ���Ԫ�ص�����ֵ
			{
				System.out.println("��Ԫ�صڶ��γ��ֵ������ǣ�"+index1+"��"+"��Ԫ��Ϊarray["+index1+"]="+array[index1]);//����ڶ��γ��ֵ�����λ�ò������Ԫ�ص�ֵ
				}
	}
		data.close();//�ر�ʵ��date������Դ
	}
	public static int index(int [] array,int key,int initi)//����index��������������array������ֵkey����ʼ������λ��initi
	{
		for(int i=initi;i<array.length;i++)//ѭ������
		{
			if(array[i]==key)//�жϲ���ֵ������ֵ�Ƿ�ƥ��
			{
				return i;//���ҵ���������ֵ
			}
		}
		return -1;//δ�ҵ�����ֵΪ-1
	}
}

