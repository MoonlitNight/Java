import java.util.Scanner;//导入类
public class StudentManage {
	public static void main(String[] args) 
	{
		Scanner data=new Scanner(System.in);//创建一个Scanner的实例
		System.out.println("初始化班级学生人数，请输入学生人数：");
		int num=data.nextInt();//定义人数
		int [] id=new int [num];//初始化id数组存放学生学号
		String [] name=new String [num];//初始化name数组存放学生姓名
		double [] score=new double[num];//初始化score数组存放学生成绩
		int index=0;//存取数据索引
		function(id,name,score,index);//调用功能函数
		data.close();
	}
	public static void function(int [] id,String [] name,double [] score,int index)//功能函数
	{
		Scanner dataFun=new Scanner(System.in);//创建一个Scanner的实例
		 jieMian();//显示界面
         int num1=dataFun.nextInt();//扫描输入值
         if(num1==1)
         {
        	 add(id,name,score,index); //num为1时调用添加学生信息功能
         }else if(num1==2)
         {
        	 revised(id,name,score,index);//num为2时调用修改功能
        	 function(id,name,score,index);//迭代
         }else if(num1==3)
         {
        	 del(id,name,score,index);//num为3时调用删除功能
        	 function(id,name,score,index);//迭代
         }else if(num1==4)
         {
        	 search(id,name,score,index);//num为4时调用查找功能
        	 function(id,name,score,index);//迭代
         }else
         {
        	 System.out.println("输入信息错误");//输入其他错误值提示
        	 function(id,name,score,index);//迭代
         }
         dataFun.close();
	}
	public static void jieMian()//界面功能部分
	{
		String [] array={"\n"+"\n"+
				                  "******************************学生管理系统******************************",
				                  "1、添加学生信息",
				                  "2、修改学生信息",
				                  "3、删除学生信息",
				                  "4、查询学生信息",
				                  "************************************************************************"};//定义界面内容
		for(int i=0;i<array.length;i++)//遍历输出
		{
			System.out.println(array[i]);//打印
		}	
	}
	//添加功能部分，需求：输入三个量，int类型学号、String类型的姓名、double类型成绩，录入数组
		public static void add(int [] id,String [] name,double [] score,int index)//添加信息功能函数
		{
			Scanner dataIn=new Scanner(System.in);//创建一个Scanner的实例
			System.out.println("\n"+"\n"+"******************************添加学生信息******************************");//打印输出
			System.out.print("请输入学生学号：");//打印输出
			int idn=dataIn.nextInt();//扫描键盘输入数值
	        id[index]=idn;//录入学号信息存放进数组
	        System.out.print("请输入学生姓名：");
			String ming=dataIn.next();//扫描键盘输入数值
	        name[index]=ming;//录入姓名信息存放进数组
	        System.out.print("请输入学生成绩：");//打印输出
			double scoreNum=dataIn.nextDouble();//扫描键盘输入数值
	        score[index]=scoreNum;//录入分数信息存放进数组
	        if(id[index]>0&&name[index]!=null&&score[index]>=0)//判断信息是否符合类型
	        {
	        	index++;//索引加一
	        	System.out.println("学生信息添加完成");
	        	System.out.println("************************************************************************");
	        	function(id,name,score,index);//调用功能函数
	        }else
	        {
	        	id[index]=0;//不符合类型该数据初始化
	        	name[index]=null;//不符合类型该数据初始化
	        	score[index]=0.0;//不符合类型该数据初始化
	    		System.out.println("学生信息添加错误请重新输入");//打印错误信息
	    		System.out.println("************************************************************************");
	        	function(id,name,score,index);//调用功能函数
	        }
	        dataIn.close();
			}
		public static void revised(int [] id,String [] name,double [] score,int index)//信息修改函数
		{
			Scanner dataRev=new Scanner(System.in);//创建一个Scanner的实例
			System.out.println("请输入学号修改信息");
			int numRev=dataRev.nextInt();//扫描键盘输入数值
			 for(int i=0;i<index;i++)//循环查找
			 {
				 if(id[i]==numRev)//判断值是否相等
				 {
					 System.out.print("请输入修改学号：");//打印输出
				     int idn=dataRev.nextInt();//扫描键盘输入数值
				     id[i]=idn;//录入学号信息存放进数组
				     System.out.print("请输入修改姓名：");
					 String ming=dataRev.next();//扫描键盘输入数值
				     name[i]=ming;//录入姓名信息存放进数组
				     System.out.print("请输入修改成绩：");//打印输出
					 double scoreNum=dataRev.nextDouble();//扫描键盘输入数值
				     score[i]=scoreNum;//录入分数信息存放进数组
				     if(id[i]>0&&name[i]!=null&&score[i]>=0)//判断信息是否符合类型
				    {
				        	System.out.println("学生信息修改完成");
				        	function(id,name,score,index);//调用功能函数
				        }else
				        {
				        	id[i]=0;//不符合类型该数据初始化
				        	name[i]=null;//不符合类型该数据初始化
				        	score[i]=0.0;//不符合类型该数据初始化
				    		System.out.println("学生信息修改错误请重新输入");//打印错误信息
				        	function(id,name,score,index);//调用功能函数
				        }
				     }else
				     {
					 System.out.println("未找到该学号学生信息，请核对后再输");  //如果没找到，提示未找到
					 function(id,name,score,index);//调用功能函数
					 }
			 }	
			 dataRev.close();
		}
		public static void del(int [] id,String [] name,double [] score,int index)//信息删除函数
		{
			Scanner dataDel=new Scanner(System.in);//创建一个Scanner的实例
			System.out.println("请输入学号删除信息");
			int numDel=dataDel.nextInt();//扫描键盘输入数值
			 for(int i=0;i<index;i++)//循环查找
			 {
				 if(id[i]==numDel)//判断值是否相等
				 {
					 id[i]=0;//数据初始化
			         name[i]=null;//数据初始化
			         score[i]=0.0;//数据初始化
			    	 System.out.println("学生信息已删除");//打印信息
			    	 function(id,name,score,index);//调用功能函数
				 }else
				 {
					 System.out.println("未找到该学号学生信息，请核对后再输");  //如果没找到，提示未找到
					 function(id,name,score,index);//调用功能函数
				 }
				 }
			 dataDel.close();
		}
		//添加检索功能，需求，根据录入数值，判断查询方式，并输出相应信息
		//无返回数值
		 public static void search(int [] id,String [] name,double [] score,int index)//信息检索函数
		 {
			 Scanner dataSch=new Scanner(System.in);//创建一个Scanner的实例
			 System.out.println("\n"+"\n"+"******************************查询学生信息******************************"+"\n"+
		 "1、查询全部学生信息"+"\n"+"2、按学号查询学生信息"+"\n"+"3、按学生成绩显示学生信息（降序）"+"\n"+
		                                     "************************************************************************");//输出信息
			 System.out.println("请选择查询方式");//打印输出信息
			 int num=dataSch.nextInt();//扫描键盘输入数值
			 if(num==1)
			 {
				 for(int i=0;i<index;i++)
				 {
					 System.out.println("学号："+id[i]+"\t"+"姓名："+name[i]+"\t"+ "成绩："+ score[i]);
				 }		 //输入值为1时循环输出学生信息
				 function(id,name,score,index);//调用功能函数
			 }else  if(num==2)
			 {
				 System.out.println("请输入学生学号：");
				 int key=dataSch.nextInt();//扫描键盘输入数值
				 if(key>0)//判断输入值是否符合要求
				 {
					 for(int i=0;i<index;i++)//循环查找
					 {
						 if(id[i]==key)//判断值是否相等
						 {
							System.out.println("学号："+id[i]+"\t"+"姓名："+name[i]+"\t"+ "成绩："+ score[i]);  //输出信息
							function(id,name,score,index);//调用功能函数
						 }else
						 {
							 System.out.println("未找到该学号学生信息，请核对后再输");  //如果没找到，提示未找到
							 search(id,name,score,index);//返回重新输入
						 }
					 }	
				 }else 
				 {
					 System.out.println("输入错误，请核对后再输");//判断输入值为负值时提示输入错误
					 function(id,name,score,index);//调用功能函数
				 }
			 }else  if(num==3)//判断num值为3时，排序
			 {
				 int [] idSort=copyid(id,index);//调用函数创建新数组
				 String [] nameSort=copyname(name,index);//调用函数创建新数组
				 double [] scoreSort=copyscore(score,index);//定义新数组，排序后不改变原有数据存储
				 sort(idSort,nameSort,scoreSort,index);//调用冒泡排序函数
				 for(int i=0;i<idSort.length;i++)//遍历打印输出
				 {
					 System.out.println("学号："+idSort[i]+"\t"+"姓名："+nameSort[i]+"\t"+ "成绩："+ scoreSort[i]);//打印
				 }
				 function(id,name,score,index);//调用功能函数
			 }
			 dataSch.close();
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
