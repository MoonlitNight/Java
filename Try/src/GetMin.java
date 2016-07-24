public class GetMin {
	public static void main(String[] args) 
	{
		double[] array={2.3,4.5,1.2,7.8,3.5,2.1,0.2};//初始化double型数组并赋值
	   double min=getMin(array);
	   System.out.println("数组中的最小值为："+min);//打印输出提示信息
	}
    	public static double getMin(double[] array) //定义方法getMin
    	{
    		double min=array[0];
    		for(int i=1;i<array.length;i++)
    		{
    			if(min>array[i])
    			{
    				min=array[i];
    			}
    		}
    		return min;
       }
}
