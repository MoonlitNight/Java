import java.util.Scanner;//导入类
public class ArrayReversal {
	public static void main(String[] args) 
	{
		Scanner data=new Scanner(System.in);//创建一个Scanner的实例
		System.out.println("请输入需要转换数组的容量：");//打印输出提示信息
		int x=data.nextInt();//扫描录入的值赋值给变量x
		int[] array=new int [x];//初始化整型数组
		System.out.println("请输入数组的数据：");//打印输出提示信息
		for(int i=0;i<array.length;i++)//循环录入数组的数据
		{
			array[i]=data.nextInt();//按位赋值给数组
		}
		System.out.println("输入数组为：");//打印输出提示信息
		for(int i=0;i<array.length;i++)
		{
			System.out.println("array["+i+"]="+array[i]);//循环输出数组的值
		}
		arrayReversal(array);//调用arrayReversal方法
		System.out.println("反转后数组为：");//输出提示信息
		for(int i=0;i<array.length;i++)
		{
			System.out.println("array["+i+"]="+array[i]);//输出反转后的数组值
		}
		    data.close();//关闭实例date回收资源
	}
    	public static void arrayReversal(int[] array) //定义方法arrayReversal
    	{
    		for(int i=0;i<array.length/2;i++)//交换位置算法
    		{
    		int temp=array[i];
            array[i]=array[array.length-1-i];
    		array[array.length-1-i]=temp;		
    		}
       }
}

