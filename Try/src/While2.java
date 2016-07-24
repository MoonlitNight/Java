
public class While2 {
	public static void main(String[] args) 
	{
		int i=0,j=0,k=0;
		while(i<4)
		{
			j=0;
			while(j<i)
			{
				System.out.print(' ');
				j++;
			}
			k=7-2*i;
			while(k>0)
			{
				System.out.print('*');
				k--;
			}
			System.out.println();
			i++;
		}	
	}
}
