import java.util.Scanner;
public class ThreeMax {
	public static void main(String[] args) 
	{
		Scanner num=new Scanner(System.in);//创建一个Scanner的实例
		System.out.println("请输入三个整数（每输入一个按一下回车键）：");//打印输出提示信息
		int num1=num.nextInt();//输入第一个数字
		int num2=num.nextInt();//输入第二个数字
		int num3=num.nextInt();//输入第三个数字
		System.out.println("最大值为："+compare(num1,num2,num3));//调用compare方法计算最大值，并打印输出
		num.close();//关闭实例num回收资源
	}
	public static int compare(int x,int y,int z)//声明静态方法compare
	{
		int temp=(x>=y)?x:y;//利用三元运算符判断xy中的最大值并赋值给temp
		int max=(temp>=z)?temp:z;//利用三元运算符判断temp与z中的最大值
		return max;//返回计算后的最大值
	}
}