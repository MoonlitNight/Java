
public class StudentManageV1 {
	public static void main(String[] args) 
	{
		Initialization();
	}
	public static void Initialization()//初始化函数
	{
		System.out.println("初始化管理系统存储容量，请输入并按回车确认：");
		int num=returnInt();//定义人数
		int [] id=new int [num];//初始化id数组存放学生学号
		String [] name=new String [num];//初始化name数组存放学生姓名
		double [] score=new double[num];//初始化score数组存放学生成绩
		int index=0;//存取数据索引
		choose(id,name,score,index);//调用功能函数
	}
	public static void choose(int [] id,String [] name,double [] score,int index)//选择功能函数
	{
		ui();//显示界面
		int num=returnInt();//扫描输入值
		switch(num)
		{
		case 1:add(id,name,score,index);break;//输入值为1时调用添加学生信息功能
		case 2:revised(id,name,score,index);break;//输入值为2时调用修改功能
		case 3:del(id,name,score,index);break;//输入值为3时调用删除功能
		case 4:search(id,name,score,index);break;//输入值为4时调用检索功能
		case 5:System.exit(0);break;//正常退出程序
		default:System.out.println("输入信息错误请新输入");
		choose(id,name,score,index);//输入值错误，返回管理选择界面
		}
	}
	public static void ui()//界面功能部分
	{
		String [] array={"\n"+"\n"+
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
		public static void add(int [] id,String [] name,double [] score,int index)//添加信息功能函数
		{
			System.out.println("\n"+"\n"+"******************************添加学生信息******************************");//打印输出
			System.out.print("请输入学生学号：");//打印输出
			id[index]=returnInt();//录入学号信息存放进数组
	        System.out.print("请输入学生姓名：");
	        name[index]=returnString();//录入姓名信息存放进数组
	        System.out.print("请输入学生成绩：");//打印输出
	        score[index]=returnDouble();//录入分数信息存放进数组
	        if(id[index]>0&&name[index]!=null&&score[index]>=0)//判断信息是否符合类型
	        {
	        	index++;//索引加一
	        	System.out.println("学生信息添加完成");
	        	System.out.println("************************************************************************");

	        }else
	        {
	        	id[index]=0;//不符合类型该数据初始化
	        	name[index]=null;//不符合类型该数据初始化
	        	score[index]=0.0;//不符合类型该数据初始化
	    		System.out.println("学生信息添加错误请重新输入");//打印错误信息
	    		System.out.println("************************************************************************");
	        }
	        choose(id,name,score,index);//调用选择功能函数
	        }
		public static void revised(int [] id,String [] name,double [] score,int index)//信息修改函数
		{
			if(index!=0)//判断index不为0时才可以修改信息
			{
			System.out.println("请输入学号修改信息");
			int date=returnInt();//扫描键盘输入数值
			int i=findKey(id,index,date);//调用查找函数，返回查找到的索引值
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
						id[i]=0;//不符合类型该数据初始化
						name[i]=null;//不符合类型该数据初始化
						score[i]=0.0;//不符合类型该数据初始化
						System.out.println("学生信息修改错误请重新输入");//打印错误信息
					}
				}else 
				{
					System.out.println("未找到该学号学生信息，请核对后再输");  //如果没找到，提示未找到 
				}
			}else
			{
				System.out.println("暂无学生信息，请添加后再使用本功能");//判断index为0时提示无学生信息
			}
			choose(id,name,score,index);//调用选择功能函数
		}
		public static void del(int [] id,String [] name,double [] score,int index)//信息删除函数
		{
			if(index!=0)//判断index不为0时才可以删除信息
			{
			System.out.println("请输入学号删除信息");
			int data=returnInt();//扫描键盘输入数值
			int i=findKey(id,index,data);//调用查找函数，返回查找到的索引值
			if(i>=0)//判断值是否相等
			{
				id[i]=0;//数据初始化
				name[i]=null;//数据初始化
				score[i]=0.0;//数据初始化
				System.out.println("学生信息已删除");//打印信息 
			}else
			{
				System.out.println("未找到该学号学生信息，请核对后再输");//如果没找到，提示未找到
			}
			}else
			{
				System.out.println("暂无学生信息，请添加后再使用本功能");//判断index为0时提示无学生信息
			}
			choose(id,name,score,index);//调用选择功能函数
		}
		//添加检索功能，需求，根据录入数值，判断查询方式，并输出相应信息
		//无返回数值
		 public static void search(int [] id,String [] name,double [] score,int index)//信息检索函数
		 {
			 if(index!=0)//判断index不为0时才可以检索查看信息
			 {
			 System.out.println("\n"+"\n"+ "******************************查询学生信息******************************"+
		                                              "\n"+"1、查询全部学生信息"+
		                                              "\n"+"2、按学号查询学生信息"+
		                                              "\n"+"3、按学生成绩显示学生信息（降序）"+
		                                              "\n"+"************************************************************************");//输出信息
			 System.out.println("请选择查询方式");//打印输出信息
			 int data=returnInt();//扫描键盘输入数值
			 if(data==1)
			 {
				 for(int i=0;i<index;i++)
				 {
					 System.out.println("学号："+id[i]+"\t"+"\t"+"姓名："+name[i]+"\t"+"\t"+ "成绩："+ score[i]);
				 }		 //输入值为1时循环输出学生信息
			 }else  if(data==2)
			 {
				 System.out.println("请输入学生学号：");
				 int key=returnInt();//扫描键盘输入数值
				 int i=findKey(id,index,key);//调用查找函数，返回查找到的索引值
				 if(i>=0)//判断值是否相等
				 {
					 System.out.println("学号："+id[i]+"\t"+"\t"+"姓名："+name[i]+"\t"+"\t"+ "成绩："+ score[i]);  //输出信息
				 }else
				 {
					 System.out.println("未找到该学号学生信息，请核对后再输");//如果没找到，提示未找到
				 }
			 }else  if(data==3)//判断num值为3时，排序
			 {
				 int [] idSort=copyid(id,index);//调用函数创建新数组
				 String [] nameSort=copyname(name,index);//调用函数创建新数组
				 double [] scoreSort=copyscore(score,index);//定义新数组，排序后不改变原有数据存储
				 sort(idSort,nameSort,scoreSort,index);//调用冒泡排序函数
				 for(int i=0;i<idSort.length;i++)//遍历打印输出
				 {
					 System.out.println("学号："+idSort[i]+"\t"+"\t"+"姓名："+nameSort[i]+"\t"+"\t"+ "成绩："+ scoreSort[i]);//打印
				 }
			 }
			 }else 
			 {
				 System.out.println("暂无学生信息，请添加后再使用本功能");//判断index为0时提示无学生信息
			 }
			 choose(id,name,score,index);//调用选择功能函数
		 }
		 public static int findKey(int [] array,int index,int key)//id数组循环查找函数
		 {
			 for(int i=0;i<index;i++)//根据输入信息数量进行查找
			 {
				 if(array[i]==key)//判断是否相等
					 return i;//查找到则返回索引值
			 }
			 return -1;//查找不到则返回-1
		 }
		 public static void sort(int [] id,String [] name,double [] score,int index)//sort方法对数组进行冒泡排序
			{
				for(int i=0;i<index-1;i++)
					for(int j=0;j<index-1-i;j++)
				{
					if(score[j]<score[j+1])
					{
						double temp=score[j];
						score[j]=score[j+1];
						score[j+1]=temp;//分数换位
						String temp1=name[j];
						name[j]=name[j+1];
						name[j+1]=temp1;//姓名换位
						int temp2=id[j];
						id[j]=id[j+1];
						id[j+1]=temp2;//学号换位
					}
				}
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
		 public static int [] copyid(int [] array,int index)//创建新数组
		 {
			 int [] array1=new int [index];
					 for(int i=0;i<index;i++)
					 {
						 array1[i]=array[i];
					 }
					 return array1;
		 }
		 public static String [] copyname(String [] array,int index)//创建新数组
		 {
			 String [] array2=new String [index];
					 for(int i=0;i<index;i++)
					 {
						 array2[i]=array[i];
					 }
					 return array2;
		 }
		 public static double [] copyscore(double [] array,int index)//创建新数组
		 {
			 double [] array3=new double [index];
					 for(int i=0;i<index;i++)
					 {
						 array3[i]=array[i];
					 }
					 return array3;
		 }
}
