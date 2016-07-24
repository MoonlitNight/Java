
public class Narcissus {
	public static void main(String[] args) 
	{
		System.out.println("所有的水仙花数位：");//输出提示信息
	 	for(int i=100;i<1000;i++)
		{
		   int G=0,S=0,B=0;//定义整形变量GSK分别为个位十位百位
		   G=i%10;//计算个位的值
		   S=i/10%10;//计算十位数的值
		   B=i/100%10;  //计算百位数的值
		   if(i==(power(G,3)+power(S,3)+power(B,3)))//判断是否符合水仙花数的条件
		   {
			   System.out.print(i+"\t");//输出值
		   }		   
		}	
	}
	public static int power(int i,int j)//定义方法，计算x的y次方
	{
		int k=1;
		for(int x=j;x>=1;x--)
		{
			j--;	
			k=k*i; 
		}return k;
	}
}
