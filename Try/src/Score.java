import java.util.Scanner;
public class Score {
	public static void main(String[] args) 
	{
		Scanner data=new Scanner(System.in);
		System.out.print("请输入学生分数：");
		int score=data.nextInt();//定义整形变量score的值，表示学生分数
		char grade='E';//定义字符型变量grade存放等级信息
		if(score>=0&score<=100)//判断输入成绩范围是否符合要求
		{	
		  switch(score/10)//简化成绩判断
		 {
		   case 10:
		   case 9:grade='A';break;//符合条件grade赋值为字符A
           case 8:grade='B';break;//符合条件grade赋值为字符B
		   case 7:grade='C';break;//符合条件grade赋值为字符C
		   case 6:grade='D';break;//符合条件grade赋值为字符D
		   default:;//默认为E
         }
		   System.out.println("成绩等级为"+grade);//打印输出等级信息
		}else   System.out.println("请输入0~100内的成绩信息");//打印输出
		data.close();
	}
}
