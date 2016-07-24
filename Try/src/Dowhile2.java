
public class Dowhile2 {
	public static void main(String[] args) 
	{
		int i=0,j=0,k=0;
		do{
			
			j=0;
			do{
				if(j!=0)
				{
					System.out.print(' ');
				}
				j++;
			}while(j<=i);
			k=7-2*i;
			do{
				System.out.print('*');
				k--;
			}while(k>0);
			i++;
			System.out.println();	
		}while(i<4);	
	}

}
