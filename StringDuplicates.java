package algorithms;

import java.util.LinkedHashSet;


/**
 * Remove duplicates from a string.
 * 
 * @author joeytawadrous
 */
public class StringDuplicates 
{
	public static void main(String[] args) 
	{
		String string = "aabbccdef";
		LinkedHashSet<Character> set = new LinkedHashSet<Character>();
		
		for(char c : string.toCharArray())
		{
			set.add(Character.valueOf(c));
		}
		
		System.out.println(set);
	}
}
