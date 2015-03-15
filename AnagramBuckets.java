package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


/**
 * Prints anagrams in the same bucket.
 * 
 * @author joeytawadrous
 */
public class AnagramBuckets
{
	public static void main (String[] args)
	{
		ArrayList<String> input = new ArrayList<String>();
		input.add("star");
		input.add("rats");
		input.add("ice");
		input.add("cie");
		input.add("arts");
		anagramBuckets(input);
	}
	
	/**
	 * Prints anagrams in the same bucket.
	 * @param list to sort
	 */
	public static void anagramBuckets(List<String> input) 
	{
		HashMap<Integer, ArrayList<String>> hashMap = new HashMap<Integer, ArrayList<String>>();

		for (String s : input)
		{
			int hash = 0;
	      
			for (int i = 0; i < s.length(); i++) 
			{
				hash += s.charAt(i);
			}
	     
			if (hashMap.containsKey(hash)) 
			{
				ArrayList<String> list = hashMap.get(hash);
				list.add(s);
				hashMap.put(hash, list);
			} 
			else 
			{
				ArrayList<String> list = new ArrayList<String>();
				list.add(s);
				hashMap.put(hash, list);
			}
		}
		

		Set<Integer> keys = hashMap.keySet();
		
		for (Integer key : keys) 
		{
			System.out.println(hashMap.get(key));
		}
	}
}
