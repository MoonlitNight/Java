
public class Traversal {
	public static void main(String[] args) 
	{
		char[] array={'A','B','C','D','E','F','J','H','I','J'};//初始化char型数组并赋值
	   sop(array);//调用方法
	}
    	public static void sop(char[] array) //定义方法sop
    	{
    		for(int i=0;i<array.length;i++)
    		{
    			System.out.println("array["+i+"]="+array[i]);//遍历输出
    		}
    	}
}
