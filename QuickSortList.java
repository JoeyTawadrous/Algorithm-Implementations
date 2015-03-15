package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;


/**
 * Quick sort algorithm (simple) based on pseudo code on Wikipedia "Quick Sort" article.
 * 
 * Complexity worst case O(N^2), best case O(N log N)
 * 
 * @see http://en.wikipedia.org/wiki/Quicksort#Simple_version
 * @author djitz
 */
public class QuickSortList 
{
	public static void main(String[] args) 
	{
		 //Generate an integer array of length 5
	    List<Integer> input = generateRandomNumbers(5);
		
	    //Before sort
	    System.out.println(input);
		
	    //After sort
	    System.out.println(quicksort(input));
	}
	
	/**
	 * This method sort the input ArrayList using quick sort algorithm.
	 * @param input the ArrayList of integers.
	 * @return sorted ArrayList of integers.
	 */
	private static List<Integer> quicksort(List<Integer> input)
	{
		if(input.size() <= 1)
		{
			return input;
		}
		
		
		int middle = input.size() / 2;
		int pivot = input.get(middle);

		
		LinkedList<Integer> less = new LinkedList<Integer>();
		LinkedList<Integer> greater = new LinkedList<Integer>();
		
		
		for (int i = 0; i < input.size(); i++) 
		{
			if(input.get(i) <= pivot)
			{
				if(i == middle)
				{
					continue;
				}
				less.add(input.get(i));
			}
			else
			{
				greater.add(input.get(i));
			}
		}
		
		
		return concatenateLists(quicksort(less), pivot, quicksort(greater));
	}
	
	/**
	 * Join the less array, pivot integer, and greater array
	 * to single array.
	 * @param less integer ArrayList with values less than pivot.
	 * @param pivot the pivot integer.
	 * @param greater integer ArrayList with values greater than pivot.
	 * @return the integer ArrayList after join.
	 */
	private static List<Integer> concatenateLists(List<Integer> less, int pivot, List<Integer> greater)
	{
		List<Integer> list = new ArrayList<Integer>();
		for (Integer i : less) 
		{
			list.add(i);
		}
		
		list.add(pivot);
		
		for (Integer i : greater) 
		{
			list.add(i);
		}
		
		return list;
	}
	
	/**
	 * This method generate a ArrayList with length n containing random integers . 
	 * @param n the length of the ArrayList to generate.
	 * @return ArrayList of random integers with length n. 
	 */
	private static List<Integer> generateRandomNumbers(int n)
	{
	    List<Integer> list = new ArrayList<Integer>();
	    Random random = new Random();
		
	    for (int i = 0; i < n; i++) 
	    {
		    list.add(random.nextInt(n * 10));
	    }
	
	    return list;
	}

}