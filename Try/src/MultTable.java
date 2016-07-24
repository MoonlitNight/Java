import java.util.Scanner;
public class MultTable {
	public static void main(String[] args) 
	{
		Scanner data=new Scanner(System.in);//创建一个Scanner的实例
		System.out.println("请输入需要打印几阶乘法表：");//打印输出提示信息
		int num=data.nextInt();//接受输入数据赋值给num
		mult(num);//调用方法nult
		data.close();//关闭实例date回收资源
	}
	public static void mult(int x)//声明静态方法mult
	{
		for(int i=1;i<=x;i++)//控制行数
		{
		 for(int j=1;j<=i;j++)//控制列数
		 {
			 System.out.print(j+"*"+i+"="+i*j+"\t");//打印输出
		 }
		 System.out.println();//换行
		}	
	}
}
