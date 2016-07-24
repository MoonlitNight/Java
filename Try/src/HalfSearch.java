import java.util.Scanner;//������
public class HalfSearch {
	public static void main(String[] args) 
	{
		Scanner data=new Scanner(System.in);//����һ��Scanner��ʵ��
		int[] array={11,22,33,44,55,66,77,88,99,110};
		System.out.println("��������Ҫ���ҵ�������");//��ӡ�����ʾ��Ϣ
		int key=data.nextInt();//ɨ��¼���ֵ��ֵ������x
		int index=halfSearch(array,key);//����halfSearch����
		System.out.println("index="+index);//������ҵ��ĽǱ�
		data.close();//�ر�ʵ��date������Դ
	}
	public static int halfSearch(int[] array,int key)
	{
		int min,max,index;//����Ǳ�ı����������С�Ͳ��ҵ��ĽǱ�
		min=0;//��С�Ǳ��ʼ��Ϊ0
		max=array.length-1;//���Ϊ���鳤�ȼ�һ
	   while(max>=min)//���Ǳ���ڻ������С�Ǳ�ѭ���ж�
	   {  
		   index=(max+min)>>1;//���ҵĽǱ�ֵΪ�����Сֵ�ĺͳ��Զ�
		   if(key>array[index])//�������ֵ�����м������ֵ
		   min=index+1;//��С�Ǳ�ֵΪ�м�ֵ��һ
		   else if(key<array[index])//�����������ֵС���м������ֵ
			   max=index-1;//���Ǳ�ֵΪ�м�ֵ��һ
		   else 
			   return index;//���򷵻ز��Ҵ��ĽǱ�ֵ
		   }
	   return -min-1;//�Ҳ����򷵻�-1�������ڵĲ���ֵ
	}
}
