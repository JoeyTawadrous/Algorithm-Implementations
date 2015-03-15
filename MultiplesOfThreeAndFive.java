package algorithms;


/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
 * The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 * 
 * @author joeytawadrous
 */
public class MultiplesOfThreeAndFive 
{
	public static void main (String[] args)
	{
		System.out.print(calc());
	}
	
	public static int calc()
	{
		int total = 0;
		
		for(int i = 0; i < 1000; i++)
		{ 
			if(i % 3 == 0 || i % 5 == 0)
			{
				total += i;
			}
		}
		
		return total;
	}
}
