
public class XiaoXue {
	public static void main(String[] args) 
	{
		int rabbit=0,chicken=0,foot=94,head=35;//初始化整型变量，代表兔子和鸡的数量，定义脚和头的数量
		for(chicken=1;chicken<=35;chicken++)//采用for循环，计算判断鸡的数量
		{
		 rabbit=head-chicken;//计算当前值下兔子的数量
		 if(foot==chicken*2+rabbit*4)//判断是否符合条件
		 {
			 System.out.println("兔子共有"+rabbit+"只"+"，鸡共有"+chicken+"只"); //符合则输出打印运算结果
		 }	
		}	
	}
}
