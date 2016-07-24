public class StudentManageV2 {
	public static int [] id;//定义整型数组id存放学生学号
	public static String [] name;//定义字符串类型数组name存放学生姓名
	public static double [] score;//定义double类型数组score存放学生成绩
	public static int index=0;//存取数据索引
	public static void main(String[] args) 
	{
		Initialization();
	}
	public static void Initialization()//初始化函数
	{
		System.out.println("初始化管理系统存储容量，请输入并按回车确认：");
		int data=returnInt();//定义人数
		id=new int [data];//初始化id数组存放学生学号
		name=new String [data];//初始化name数组存放学生姓名
		score=new double[data];//初始化score数组存放学生成绩
		choose();//调用功能函数
	}
	public static void choose()//选择功能函数
	{
		ui();//显示界面
		switch(returnInt())
		{
		case 1:add();break;//输入值为1时调用添加学生信息功能
		case 2:revised();break;//输入值为2时调用修改功能
		case 3:del();break;//输入值为3时调用删除功能
		case 4:search();break;//输入值为4时调用检索功能
		case 5:System.exit(0);break;//正常退出程序
		default:System.out.println("输入信息错误请新输入");
		choose();//输入值错误，返回管理选择界面
		}
	}
	public static void ui()//界面功能部分
	{
		String [] array={"\n\n"+
				                  "******************************学生管理系统******************************",
				                  "1、添加学生信息",
				                  "2、修改学生信息",
				                  "3、删除学生信息",
				                  "4、查询学生信息",
				                  "5、退出管理系统",
				                  "************************************************************************"};//定义界面内容
		for(int i=0;i<array.length;i++)//遍历输出
		{
			System.out.println(array[i]);//打印
		}	
	}
	//添加功能部分，需求：输入三个量，int类型学号、String类型的姓名、double类型成绩，录入数组
		public static void add()//添加信息功能函数
		{
			System.out.println("\n\n"+"******************************添加学生信息******************************");//打印输出
			System.out.print("请输入学生学号：");//打印输出
			id[index]=returnInt();//录入学号信息存放进数组
	        System.out.print("请输入学生姓名：");
	        name[index]=returnString();//录入姓名信息存放进数组
	        System.out.print("请输入学生成绩：");//打印输出
	        score[index]=returnDouble();//录入分数信息存放进数组
	        if(id[index]>0&&name[index]!=null&&score[index]>=0)//判断信息是否符合规则
	        {
	        	index++;//索引加一
	        	System.out.println("学生信息添加完成");
	        	System.out.println("************************************************************************");
	        }else
	        {
	        	defaultValue(index);//不符合规则恢复默认值
	    		System.out.println("学生信息添加错误请重新输入");//打印错误信息
	    		System.out.println("************************************************************************");
	        }
	        choose();//调用选择功能函数
	        }
		public static void revised()//信息修改函数
		{
			System.out.println("请输入学号修改信息");
			int i=findKey(returnInt());//调用查找函数，返回查找到的索引值
			if(i>=0)//判断值是否找到
				{
				System.out.print("请输入修改学号：");//打印输出
				id[i]=returnInt();//录入学号信息存放进数组
				System.out.print("请输入修改姓名：");
				name[i]=returnString();//录入姓名信息存放进数组
				System.out.print("请输入修改成绩：");//打印输出
				score[i]=returnDouble();//录入分数信息存放进数组
				if(id[i]>0&&name[i]!=null&&score[i]>=0)//判断信息是否符合类型
					{
					System.out.println("学生信息修改完成");
					}else
					{
						defaultValue(i);
						System.out.println("学生信息修改错误请重新输入");//打印错误信息
					}
				}else 
				{
					System.out.println("未找到该学号学生信息，请核对后再输");  //如果没找到，提示未找到 
				}
			choose();//调用选择功能函数
		}
		public static void del()//信息删除函数
		{
			System.out.println("请输入学号删除信息");
			int i=findKey(returnInt());//调用查找函数，返回查找到的索引值
			if(i>=0)//判断是否找到
			{
				move(i);//把需要删除的移动到最后一位并恢复默认值，角标index从
				System.out.println("学生信息已删除");//打印信息 
			}else
			{
				System.out.println("未找到该学号学生信息，请核对后再输");//如果没找到，提示未找到
			}
			choose();//调用选择功能函数
		}
		public static void move(int findKey)//信息移动函数
		{
			for(int i=findKey;i<index-1;i++)
			{
				transoposition(id,name,score,i);//换位	
			}
			defaultValue(index);
			index-=1;
		}
		public static void defaultValue(int i)//恢复默认值函数
		{
			id[i]=0;//数据初始化
			name[i]=null;//数据初始化
			score[i]=0.0;//数据初始化
		}
		//添加检索功能，需求，根据录入数值，判断查询方式，并输出相应信息
		//无返回数值
		 public static void search()//信息检索函数
		 {
			 System.out.println("\n\n"+ "******************************查询学生信息******************************"+
		                                              "\n"+"1、查询全部学生信息"+
		                                              "\n"+"2、按学号查询学生信息"+
		                                              "\n"+"3、按姓名查询学生信息"+
		                                              "\n"+"4、按学生成绩显示学生信息（降序）"+
		                                              "\n"+"************************************************************************");//输出信息
			 System.out.println("请选择查询方式");//打印输出信息
			 switch(returnInt())
				{
				case 1:searchAll();break;//输入值为1时查询全部学生信息
				case 2:searchId();break;//输入值为2时按学号查询学生信息
				case 3:searchName();break;//输入值为3时按姓名查询学生信息
				case 4:searchDown();break;//输入值为4时按学生成绩显示学生信息（降序）
				default:System.out.println("输入信息错误请新输入");
				choose();//输入值错误，返回管理选择界面
				}
		 }
		 public static void searchAll()
		 {
			 for(int i=0;i<index;i++)
			 {
				 System.out.println("学号："+id[i]+"\t\t"+"姓名："+name[i]+"\t\t"+ "成绩："+ score[i]);
			 }		
			 choose();
		 }
		 public static void searchId()
		 {
			 System.out.println("请输入学生学号：");
			 int key=returnInt();//扫描键盘输入数值
			 int i=findKey(key);//调用查找函数，返回查找到的索引值
			 if(i>=0)//判断值是否相等
			 {
				 System.out.println("学号："+id[i]+"\t\t"+"姓名："+name[i]+"\t\t"+ "成绩："+ score[i]);  //输出信息
			 }else
			 {
				 System.out.println("未找到该学号学生信息，请核对后再输");//如果没找到，提示未找到
			 }
			 choose();
		 }
		 public static void searchName()
		 {
			 System.out.println("请输入学生姓名：");
			 String key=returnString();//扫描键盘输入数值
			 int flag=findName(key);
			 if(flag==-1)
			 {
				 System.out.println("未找到该学号学生信息，请核对后再输");//如果没找到，提示未找到 
			 }else
			 {
				 int [] x=array(flag,digit(flag));
				 for(int y=x.length-2;y>=0;y--)
				 {
				     System.out.println("学号："+id[x[y]]+"\t\t"+"姓名："+name[x[y]]+"\t\t"+ "成绩："+ score[x[y]]);//打印
				 }
			 }
			 choose();
		 }
		 public static void searchDown()
		 {
			 int [] idSort=copyInt();//调用函数创建新数组
			 String [] nameSort=copyString();//调用函数创建新数组
			 double [] scoreSort=copyDouble();//定义新数组，排序后不改变原有数据存储
			 sort(idSort,nameSort,scoreSort);//调用冒泡排序函数
			 for(int i=0;i<idSort.length;i++)//遍历打印输出
			 {
				 System.out.println("学号："+idSort[i]+"\t\t"+"姓名："+nameSort[i]+"\t\t"+ "成绩："+ scoreSort[i]);//打印
			 }
			 choose();
		 }
		 public static int findKey(int key)//数组循环按id查找函数
		 {
			 for(int i=0;i<index;i++)//根据输入信息数量进行查找
			 {
				 if(id[i]==key)//判断是否相等
					 return i;//查找到则返回索引值
			 }
			 return -1;//查找不到则返回-1
		 }
		 public static int findName(String key)//数组循环按姓名查找函数
		 {
			 int b=0,encryption=1;
			 for(int i=0;i<index;i++)//根据输入信息数量进行查找
			 {
				 if(key.equals(name[i]))//判断字符串是否相等
				 {
					 encryption=i+encryption*10;
					 b++;
				 }
				 }
			if(b!=0)
			{
				return encryption;
			}else
			    return -1;
		 }
			public static int digit(int x)//digit方法，解密获取数字，返回数字位数
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
		 public static void sort(int [] array1,String [] array2,double [] array3)//sort方法对数组进行冒泡排序
			{
				for(int i=0;i<index-1;i++)
					for(int j=0;j<index-1-i;j++)
				{
					if(array3[j]<array3[j+1])
					{
						transoposition(array1,array2,array3,j);
					}
				}
			}
		 public static void transoposition(int [] array1,String [] array2,double [] array3,int i)//换位函数
		 {
			    int temp1=array1[i];
			    array1[i]=array1[i+1];
			    array1[i+1]=temp1;//学号换位
				String temp2=array2[i];
				array2[i]=array2[i+1];
				array2[i+1]=temp2;//姓名换位
				double temp3=array3[i];
				array3[i]=array3[i+1];
				array3[i+1]=temp3;//分数换位		
		 }
		 public static int returnInt()//用于接收整型数据类型
		 {
			 java.util.Scanner input=new java.util.Scanner(System.in);//创建input对象，使用Scanner扫描键盘输入信息
			 return input.nextInt();		//返回输入信息 
		 }
		 public static String returnString()//用于接收字符串数据类型
		 {
			 java.util.Scanner input=new java.util.Scanner(System.in);//创建input对象，使用Scanner扫描键盘输入信息
			 return input.next();		 //返回输入信息 
		 }
		 public static Double returnDouble()
		 {
			 java.util.Scanner input=new java.util.Scanner(System.in);//创建input对象，使用Scanner扫描键盘输入信息
			 return input.nextDouble();		//返回输入信息  
		 }
		 public static int [] copyInt()//创建新数组
		 {
			 int [] array=new int [index];
					 for(int i=0;i<index;i++)
					 {
						 array[i]=id[i];
					 }
					 return array;
		 }
		 public static String [] copyString()//创建新数组
		 {
			 String [] array=new String [index];
					 for(int i=0;i<index;i++)
					 {
						 array[i]=name[i];
					 }
					 return array;
		 }
		 public static double [] copyDouble()//创建新数组
		 {
			 double [] array=new double [index];
					 for(int i=0;i<index;i++)
					 {
						 array[i]=score[i];
					 }
					 return array;
		 }
}
