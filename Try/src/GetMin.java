public class GetMin {
	public static void main(String[] args) 
	{
		double[] array={2.3,4.5,1.2,7.8,3.5,2.1,0.2};//��ʼ��double�����鲢��ֵ
	   double min=getMin(array);
	   System.out.println("�����е���СֵΪ��"+min);//��ӡ�����ʾ��Ϣ
	}
    	public static double getMin(double[] array) //���巽��getMin
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
