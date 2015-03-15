package algorithms;

import java.util.ArrayList;


/**
 * Determines which number is missing from an unsorted array of values 1-100.
 * Iterate through the array and compute the sum of all numbers. 
 * Now, sum of natural numbers from 1 to N, can be expressed as N(N+1)/2. In your case N=100.
 * Subtract the sum of the array from N(N+1)/2, where N=100.
 * 
 * Complexity: O(n)
 * 
 * @author joeytawadrous
 */
public class UnsortedArray 
{
	public static void main(String[] args) 
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < 101; i++) // leave 100 out
		{
			if(i != 77) 
			{
				list.add(i);
			}
		}
		
		getMissingNumber(list);
		getMissingNumber2();
	}
	
	/**
	 * Prints the missing number in a list of numbers.
	 * @param list
	 */
	public static void getMissingNumber(ArrayList<Integer> list)
	{
		int sum = 0;
		
		for (int i = 0; i < list.size(); i++) 
		{
			sum += list.get(i);
		}
	
		// the total sum of numbers between 1 and arr.length.
		int total = (list.size() + 1) * list.size() / 2;
	
		System.out.println("Missing number is: " + (total - sum));
	}
	
	/**
	 * Prints the missing number in an array of numbers.
	 */
	public static void getMissingNumber2()
	{
		int[] arr = {1,2,3,5};  
	      
	    int indexes = 5;  
	    int values = 0;  
	      
	    for (int i = 0; i < arr.length; i++)
	    {  
	        indexes += i + 1;  
	        values += arr[i];  
	    }  
	      
	    int result = indexes - values;  
	      
	    System.out.println("Missing number is: " + result);  
	}
}
