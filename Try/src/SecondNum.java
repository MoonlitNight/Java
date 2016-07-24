import java.util.Scanner;//导入类
public class SecondNum 
{
	public static void main(String[] args) 
	{
		Scanner data=new Scanner(System.in);//创建一个Scanner的实例
        System.out.println("请输入需要查找的元素");//打印输出提示信息
		int num=data.nextInt();//扫描录入赋值给变量num
		int []  array = {12,34,23,13,45,23,9};//定义整型数组并初始化值
		int index=index(array,num,0);//调用index方法查找第一次出现的索引位置
		if(index==-1)//如果返回值为-1
		{
		System.out.println("该元素未找到");//打印未找到该元素
		}else if(index>=0)//如果返回值不为0说明找到该元素的索引值
		{
			System.out.println("该元素出现的索引是："+index+"，"+"该元素为array["+index+"]="+array[index]);//输出第一次出现的索引位置并输出该元素的值
			int index1=index(array,num,index+1);//调用index方案进行第二次查找
			if(index1==-1)//如果返回值为-1
				{
				System.out.println("该元素未出现第二次");//打印未找到该元素
				}else if(index>=0)//如果返回值不为0说明找到该元素的索引值
			{
				System.out.println("该元素第二次出现的索引是："+index1+"，"+"该元素为array["+index1+"]="+array[index1]);//输出第二次出现的索引位置并输出该元素的值
				}
	}
		data.close();//关闭实例date回收资源
	}
	public static int index(int [] array,int key,int initi)//定义index方法，传入数组array，查找值key，初始化查找位置initi
	{
		for(int i=initi;i<array.length;i++)//循环查找
		{
			if(array[i]==key)//判断查找值与数组值是否匹配
			{
				return i;//查找到返回索引值
			}
		}
		return -1;//未找到返回值为-1
	}
}

