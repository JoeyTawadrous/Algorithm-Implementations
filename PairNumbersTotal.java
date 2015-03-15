package algorithms;


/**
 * Given an array of randomly sorted integers and an integer k, write a function which returns boolean True 
 * if a pair of numbers exists in the array such that A[i] + A[j] = k and False otherwise. 
 * Provide an O(N) and an O(N log N) solution.
 * 
 * @author joeytawadrous
 */
public class PairNumbersTotal 
{
	public static void main (String[] args) 
	{
		int[] array = {1,2,3};
		
		System.out.println(IsExistsPairThatThierSumIsK2(array, 3));
    }
	
	
	/*
	 * O(N log N)
	 */
	static boolean IsExistsPairThatThierSumIsK(int[] array, int k)
	{
	    for (int i = 0; i < array.length; i++)
	    {
	        int j = FindLeftmost(array, k - array[i]);
	        
	        if (j == -1) continue;
	        
	        if (i != j || (i + 1 < array.length && array[i] == array[i + 1])) return true;
	    }
	    
	    return false;
	}

	static int FindLeftmost(int[] array, int k)
	{
	    int l = 0;
	    int r = array.length - 1;
	    
	    while (l < r)
	    {
	        int m = l + (r - l) / 2;
	        
	        if (array[m] >= k) r = m;
	        else l = m + 1;
	    }
	    
	    return array[l] == k ? l : -1;
	}
	
	
	/*
	 * O(N)
	 */
	static boolean IsExistsPairThatThierSumIsK2(int[] array, int k)
	{
	    int l = 0;
	    int r = array.length - 1;
	    
	    while (l < r)
	    {
	        if (array[l] + array[r] == k) return true;
	        else if (array[l] + array[r] > k) r--;
	        else l++;
	    }
	    
	    return false;
	}
	
}
