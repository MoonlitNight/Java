import java.util.Scanner;//������
public class Hws {
	public static void main(String[] args) 
	{
		Scanner data=new Scanner(System.in);//����һ��Scanner��ʵ��
		System.out.println("������һ������");//��ӡ�����ʾ��Ϣ
		int num=data.nextInt();//ɨ��¼�븳ֵ������num
		if(num<0)//�������С��0��������ʾ��Ϣ����
		{
			System.out.println("�������ִ�����������ڻ���������");//�����ӡ��ʾ��Ϣ
		}else{
			int i=digit(num);//����n������ȡ�������ֵ�λ��
			int [] array=array(num,i);//����array����������ת��Ϊ����
			if(hws(array))//����hws�����ж��Ƿ��ǻ�����
			{
				System.out.println(num+"�ǻ�����");//��ӡ�����ʾ��Ϣ
				}else
					System.out.println(num+"���ǻ�����");//��ӡ�����ʾ��Ϣ
/*			if(hwsJian(num))//����hwsJian�����ٴ��ж��Ƿ��ǻ�����
			{
				System.out.println(num+"�ǻ�����");//��ӡ�����ʾ��Ϣ
				}else
					System.out.println(num+"���ǻ�����");//��ӡ�����ʾ��Ϣ
*/
			}
		data.close();//�ر�ʵ��date������Դ
		}
	public static int digit(int x)//digit��������ȡ���֣���������λ��
	{
		int n=0;
		while(x!=0)
		{
			n++;
			x=x/10;
		}
		return n;
	}
	public static int[] array(int num,int length)//array������������ת��Ϊ���飬����������
	{
		int[] array=new int[length];
		for(int a=0;a<length;a++)
		{
			array[a]=num%10;
			num/=10;
		}
		return array;
	}
	public static boolean hws(int[] array)//hws�������ж��Ƿ��ǻ��������Ƿ���true�����Ƿ���false
	{
		for(int i=0,j=array.length-1;i<=j;i++,j--)
		{
			if(array[i]!=array[j])
				return false;
			}
		return true;
	}
/*	public static boolean hwsJian(int num)//�㷨��
	{
		int x=num,y=0;
		while(x>0)
		{
			y=y*10+x%10;
			x/=10;
		}
		return y==num;
	}
*/
}
