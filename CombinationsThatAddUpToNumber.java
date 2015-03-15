package algorithms;

import java.util.*;


/**
 * Given a number N, write a program that returns all possible combinations of numbers that add up to N, as lists.
 * (Exclude the N+0=N) 
 * For example, if N=4 return {{1,1,1,1},{1,1,2},{2,2},{1,3}}
 * 
 * @author joeytawadrous
 */
public class CombinationsThatAddUpToNumber 
{
    public static void main(String[] args)
    {
        int target = 5;
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list;
        
        for (int last = 1; last < target; last++) 
        {
            list = new ArrayList<Integer>();
            addNext(results, list, 0, last, target, true);
        }

        print(results);
    }
    
    /**
     * Adds the next combination to the combinations list.
     * @param results
     * @param list
     * @param sum
     * @param last
     * @param target
     * @param isFirst
     */
    public static void addNext(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> list, int sum, int last, int target, boolean isFirst) 
    {
        if (sum == target)
        {
        	results.add(list);
        	return;
        }
            
        while (sum + last > target) 
        {
            last--;
        }

        int less = last - 1;
        if ( !isFirst && less > 0 && less + last < target )
        {
        	ArrayList<Integer> copyList = new ArrayList<Integer>(list);
        	addNext(results, copyList, sum, less, target, false);
        }
        
        sum = sum + last;
        list.add(last);
        
        addNext(results, list, sum, last, target, false);
    }
    
    /**
     * Prints the array combinations.
     * @param results
     */
    public static void print(ArrayList<ArrayList<Integer>> results)
    {
    	for (ArrayList<Integer> list: results) 
    	{
    		for (Integer i: list)
    		{
    			System.out.print(String.format("%d ", i));
    		}
    		System.out.println("\n----------");
    	}
    }
}
