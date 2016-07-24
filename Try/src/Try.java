import java.util.Scanner; 
public class Try {
	public static void main(String[] args)
	{
		Scanner data=new Scanner(System.in);
		System.out.print("请输入年份：");
		int year=data.nextInt();//定义整形变量year
		if((year%4==0&&year%100!=0)||(year%400==0))//判断year是否能被4整出但不能被100整除或被400整除
		{
			System.out.println(year+"年是闰年");//如果结果为true，则输出打印时闰年
		}
		else
			System.out.println(year+"年不是闰年");//如果结果为false，则输出打印时不闰年
        data.close();
	}
}
