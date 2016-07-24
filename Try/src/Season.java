import java.util.Scanner;
public class Season {
	public static void main(String[] args) 
	{
		Scanner data=new Scanner(System.in);
		System.out.print("请输入月份：");
		int month=data.nextInt();
		switch(month)
		{
		   case 3:
		   case 4:
           case 5:System.out.println(month+"月为春季");break;//为3、4、5月时是春季
		   case 6:
		   case 7:
		   case 8:System.out.println(month+"月为夏季");break;//为6、7、8月时为夏季
           case 9:
           case 10:
           case 11:System.out.println(month+"月为秋季");break;//为9、10、11月时为秋季
           case 1:
		   case 2:
           case 12:System.out.println(month+"月为冬季");break;//为12、1、2月时为冬季
		   default:System.out.println("输入月份错误");//以上选项都找不到则数据错误
		 }
		data.close();//关闭实例num回收资源
	}

}
