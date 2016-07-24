import java.util.Scanner;
public class Season1 {
	public static void main(String[] args) 
	{
		Scanner data=new Scanner(System.in);
		System.out.print("请输入月份：");
		int month=data.nextInt();
		if(month>12||month<1)//判断月份大于12或者小于1
		{
	    	System.out.println(month+"输入月份错误");//如果成立则输入数据错误
	    }else if(month>2&&month<6)
	    {
	    	System.out.println(month+"月为春季");//为3、4、5月时是春季
	    }else if(month>5&&month<9)//否则为6、7、8月时为夏季
	    {
	    	System.out.println(month+"月为夏季");	
	    }else if(month>8&&month<12)
	    {
	    	System.out.println(month+"月为秋季");//为9、10、11月时为秋季
	    }else 
	        System.out.println(month+"月为冬季");//否则为冬季
		data.close();
	}
}
