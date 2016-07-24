
public class ForForQi {
		public static void main(String[] args) 
		{
			for(int i=1;i<=100;i++)//用for来循环判断1到100之间的数值
			{
				if(i%10==0)
				{
					System.out.print(i+"\t");//表达式成立则输出*
					System.out.println();//每十个数换行输出
				}else if(i%7==0|(i%10==7&i/10==7))//判断该数值是否是7的倍数或者位数中含有7
				{
					System.out.print("*\t");//表达式成立则输出*
				}else
				{
					System.out.print(i+"\t");//表达式成立则输出*
				}
			}	
		}
}
