import java.util.Scanner;
public class ToString {
	public static void main(String[] args) {
		Scanner data=new Scanner(System.in);//创建一个Scanner的实例
		System.out.println("请输入需要转换数组的容量：");//打印输出提示信息
		int x=data.nextInt();//扫描录入的值赋给变量x
		int[] array=new int [x];//初始化整型数组
		System.out.println("请输入数组的数据：");//打印输出提示信息
		for(int i=0;i<array.length;i++)//循环录入数组的数据
		{
			array[i]=data.nextInt();//赋值给数组
		}
		String str=toString(array);//调用toString方法
		System.out.println("处理后为："+str);//输出打印转换后的字符串
    	data.close();//关闭实例date回收资源
	}
	public static String toString(int[] array) //定义方法toString
	{
		String str="";//定义需要返回的字符串，并初始化
		for(int i=0;i<array.length;i++)//for循环进行数组数据的处理
		{
			if(i<array.length-1)//如果不是数组最后一个值则加上一个"-"字符
			{
			str=str+array[i]+"-";//算法
			}else str=str+array[array.length-1];//是最后一个则不加“-”
		}
		return str;//返回字符串
	}
}
