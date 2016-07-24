
public class AddT {
	public static void main(String[] args) 
	{
		int n=50;
		long sum=1L;
		int[] a=new int[n];
		a[0]=1;
		System.out.print("a[0]="+a[0]+"\t");
		for(int i=1;i<n;i++)
		{
			if(i==1)
				a[i]=a[i-1];
			else
			a[i]=a[i-1]+a[i-2];
			sum=sum+a[i];
			System.out.print("a["+i+"]="+a[i]+"\t");
		}
		System.out.println();
		System.out.println("sum="+sum);
	}
}
