import java.util.Scanner;//导入类
public class HalfSearch {
	public static void main(String[] args) 
	{
		Scanner data=new Scanner(System.in);//创建一个Scanner的实例
		int[] array={11,22,33,44,55,66,77,88,99,110};
		System.out.println("请输入需要查找的整数：");//打印输出提示信息
		int key=data.nextInt();//扫描录入的值赋值给变量x
		int index=halfSearch(array,key);//调用halfSearch方法
		System.out.println("index="+index);//输出查找到的角标
		data.close();//关闭实例date回收资源
	}
	public static int halfSearch(int[] array,int key)
	{
		int min,max,index;//定义角标的变量，最大最小和查找到的角标
		min=0;//最小角标初始化为0
		max=array.length-1;//最大为数组长度减一
	   while(max>=min)//最大角标大于或等于最小角标循环判断
	   {  
		   index=(max+min)>>1;//查找的角标值为最大最小值的和除以二
		   if(key>array[index])//如果查找值大于中间的数组值
		   min=index+1;//最小角标值为中间值加一
		   else if(key<array[index])//否则如果查找值小于中间的数组值
			   max=index-1;//最大角标值为中间值减一
		   else 
			   return index;//否则返回查找带的角标值
		   }
	   return -min-1;//找不到则返回-1或数组内的插入值
	}
}
