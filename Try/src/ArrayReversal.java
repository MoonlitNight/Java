import java.util.Scanner;//������
public class ArrayReversal {
	public static void main(String[] args) 
	{
		Scanner data=new Scanner(System.in);//����һ��Scanner��ʵ��
		System.out.println("��������Ҫת�������������");//��ӡ�����ʾ��Ϣ
		int x=data.nextInt();//ɨ��¼���ֵ��ֵ������x
		int[] array=new int [x];//��ʼ����������
		System.out.println("��������������ݣ�");//��ӡ�����ʾ��Ϣ
		for(int i=0;i<array.length;i++)//ѭ��¼�����������
		{
			array[i]=data.nextInt();//��λ��ֵ������
		}
		System.out.println("��������Ϊ��");//��ӡ�����ʾ��Ϣ
		for(int i=0;i<array.length;i++)
		{
			System.out.println("array["+i+"]="+array[i]);//ѭ����������ֵ
		}
		arrayReversal(array);//����arrayReversal����
		System.out.println("��ת������Ϊ��");//�����ʾ��Ϣ
		for(int i=0;i<array.length;i++)
		{
			System.out.println("array["+i+"]="+array[i]);//�����ת�������ֵ
		}
		    data.close();//�ر�ʵ��date������Դ
	}
    	public static void arrayReversal(int[] array) //���巽��arrayReversal
    	{
    		for(int i=0;i<array.length/2;i++)//����λ���㷨
    		{
    		int temp=array[i];
            array[i]=array[array.length-1-i];
    		array[array.length-1-i]=temp;		
    		}
       }
}

