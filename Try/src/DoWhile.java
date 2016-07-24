
public class DoWhile {
	public static void main(String[] args) 
	{
		int i=5,j=5;
		do {
			i--;
			j=5;
        do {
				System.out.print(j);
				j--;
			}while(j>=5-i);
			System.out.println();
		}while(i>0);
	}
}
