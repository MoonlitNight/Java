
public class While1 {
	public static void main(String[] args) 
	{
		int i=5,j=5;
		while(i>0)
		{
			i--;
			j=5;
			while(j>=5-i)
			{
				System.out.print(j);
				j--;
			}
			System.out.println();
		}	
	}
}
