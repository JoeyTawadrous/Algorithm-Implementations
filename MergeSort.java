package algorithms;

import java.util.Arrays;
import java.util.Random;


/**
 * Merge sort algorithm (Top down) based on pseudocode at Wikipedia "Merge sort" article.
 * 
 * @see <a href="http://en.wikipedia.org/wiki/Merge_sort"/> 
 * @author djitz
 */
public class MergeSort 
{
	public static void main(String[] args) 
	{
	    //Generate an integer array of length 7
	    int[] input = generateRandomNumbers(7);
		
	    //Before sort
	    System.out.println(Arrays.toString(input));
		
	    //After sort
	    System.out.println(Arrays.toString(mergeSort(input)));
	}
	
	/**
	 * Sorts the input array using top-down merge sort algorithm.
	 * @param the array of integers to sort
	 * @return sorted array of integers
	 */
	private static int[] mergeSort(int[] input)
	{
		if(input.length == 1)
		{
			return input;
		}
		
		int middle = (int) Math.ceil((double)input.length / 2);
		int[] left = new int[middle];
		
		int rightLength = 0;
		if(input.length % 2 == 0)
		{
			rightLength = middle;
		}
		else
		{
			rightLength = middle - 1;
		}
		int[] right = new int[rightLength];
		
		int leftIndex = 0; 
		int rightIndex = 0;
		
		for (int i = 0; i < input.length; i++) 
		{
			if(i < middle)
			{
				left[leftIndex] = input[i];
				leftIndex++;
			}
			else
			{
				right[rightIndex] = input[i];
				rightIndex++;
			}
		}
		
		left = mergeSort(left);
		right = mergeSort(right);
		
		return merge(left, right);
	}
	
	/**
	 * Merges two integer arrays into a sorted integer array.
	 * @param left first array
	 * @param right second array
	 * @return a sorted integer array
	 */
	private static int[] merge(int[] left, int[] right)
	{
		int[] result = new int[left.length + right.length];
		int leftIndex = 0;
		int rightIndex = 0;
		int resultIndex = 0;
		
		while(leftIndex < left.length || rightIndex < right.length)
		{
			if(leftIndex < left.length && rightIndex < right.length)
			{
				if(left[leftIndex] < right[rightIndex])
				{
					result[resultIndex] = left[leftIndex];
					leftIndex++;
					resultIndex++;
				}
				else
				{
					result[resultIndex] = right[rightIndex];
					rightIndex++;
					resultIndex++;
				}
			}
			else if(leftIndex < left.length)
			{
				for (int i = resultIndex; i < result.length; i++)
				{
					result[i] = left[leftIndex];
					leftIndex++;
				}
			}
			else if(rightIndex < right.length)
			{
				for (int i = resultIndex; i < result.length; i++) 
				{
					result[i] = right[rightIndex];
					rightIndex++;
				}
			}
		}
		
		return result;
	}
	
	/**
	 * Generates an array of random integers with length n.
	 * @param the length of the array to generate
	 * @return array of random integers with length n 
	 */
	private static int[] generateRandomNumbers(int n)
	{
	    int[] result = new int[n];
	    Random random = new Random();
		
	    for (int i = 0; i < result.length; i++)
	    {
		    result[i] = random.nextInt(n * 10);
	    }
	
	    return result;
	}
}