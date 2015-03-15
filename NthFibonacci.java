package algorithms;


/**
 * Computes the Nth Fibonacci number.
 * 
 * @author joeytawadrous
 */
public class NthFibonacci
{
	public static void main (String[] args) 
	{
        for (int i = 0; i < 10; i++) 
        {
            System.out.print (fib(i) + ", ");
        }
        
        System.out.println (fib(10));
    }
	
	/**
	 * Returns the nth Fibonacci number.
	 * @param n
	 * @return Nth Fibonacci number
	 */
	static int fib(int n) 
	{
        return n <= 1 ? n : fib(n-1) + fib(n-2);
    }
}
