package algorithms;


/**
 * Finds the missing number in an arithmetic progression.
 * 
 * @author joeytawadrous
 */
public class ArithmeticProgression 
{
	public static void main(String[] args) 
	{
		int[] list = {1, 3, 7};
        System.out.println(findMissing(list));
	}
	
	/**
	 * Finds the missing number in an arithmetic progression.
	 * @param list
	 * @return missing number in progression
	 */
    public static int findMissing(int[] list) 
    {
        int length = list.length;
        int sum = (length + 1) * (list[0] + list[length - 1]) / 2;
        
        for(int i = 0; i < length; i++) 
        {
            sum -= list[i];
        }

        return sum;
    }
}
