package algorithms;


/**
 * Print multiplication tables up to a certain number.
 * 
 * @author joeytawadrous
 */
public class MultiplicationTables 
{
	public static void main (String[] args) 
	{
		multTables(12);
    }
	
	/**
	 * Print multiplication tables up to max.
	 * @param max
	 */
	public static void multTables(int max)
    {
        for (int i = 1; i <= max; i++) 
        {
            for (int j = 1; j <= max; j++) 
            {
                System.out.print(String.format("%4d", j * i ));
            }
            System.out.println();
        }
    }
}
