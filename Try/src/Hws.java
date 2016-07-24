import java.util.Scanner;//导入类
public class Hws {
	public static void main(String[] args) 
	{
		Scanner data=new Scanner(System.in);//创建一个Scanner的实例
		System.out.println("请输入一个数：");//打印输出提示信息
		int num=data.nextInt();//扫描录入赋值给变量num
		if(num<0)//如果输入小于0的数字提示信息错误
		{
			System.out.println("输入数字错误，请输入大于或等于零的数");//输出打印提示信息
		}else{
			int i=digit(num);//调用n方法获取输入数字的位数
			int [] array=array(num,i);//调用array方法将数字转化为数组
			if(hws(array))//调用hws方法判断是否是回文数
			{
				System.out.println(num+"是回文数");//打印输出提示信息
				}else
					System.out.println(num+"不是回文数");//打印输出提示信息
/*			if(hwsJian(num))//调用hwsJian方法再次判断是否是回文数
			{
				System.out.println(num+"是回文数");//打印输出提示信息
				}else
					System.out.println(num+"不是回文数");//打印输出提示信息
*/
			}
		data.close();//关闭实例date回收资源
		}
	public static int digit(int x)//digit方法，获取数字，返回数字位数
	{
		int n=0;
		while(x!=0)
		{
			n++;
			x=x/10;
		}
		return n;
	}
	public static int[] array(int num,int length)//array方法，将数字转化为数组，并返回数组
	{
		int[] array=new int[length];
		for(int a=0;a<length;a++)
		{
			array[a]=num%10;
			num/=10;
		}
		return array;
	}
	public static boolean hws(int[] array)//hws方法，判断是否是回文数，是返回true，不是返回false
	{
		for(int i=0,j=array.length-1;i<=j;i++,j--)
		{
			if(array[i]!=array[j])
				return false;
			}
		return true;
	}
/*	public static boolean hwsJian(int num)//算法二
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
