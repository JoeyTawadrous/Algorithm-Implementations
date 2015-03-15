package algorithms;

import java.util.HashSet;
import java.util.Set;


/**
 * Prints all Palindromes of a word.
 * 
 * @author joeytawadrous
 */
public class Palindrome 
{
	public static void main(String[] args) 
	{
		String word = "abba";
		System.out.println(isPalindrome(word.toCharArray()));
		System.out.println(isPalindrome2(word));
		System.out.println(isPalindrome3(word));
		System.out.println(substringPalindrome(word));
	}

	/**
	 * Finds all substring palindromes.
	 * @param input
	 * @return result
	 */ 
	public static Set<String> substringPalindrome(final String input) 
	{
		final HashSet<String> result = new HashSet<String>();

	    for (int i = 0; i < input.length(); i++) 
	    {
	    	// searching for even length palindromes:
	        searchForPalindromes(input, i, i+1, result);
	        // searching for odd length palindromes:
	        searchForPalindromes(input, i, i, result);
	    } 
	    return result;
	 }

	 public static void searchForPalindromes(String input, int i, int j, Set<String> result)
	 {
	     while (i >= 0 && j < input.length() && input.charAt(i) == input.charAt(j)) 
	     {
	    	 result.add(input.substring(i, j+1));
	    	 i--;
	         j++;
	     }
	 }
	
	 /**
	  * Test's whether input chars form a palindrome or not.
	  * @param word
	  * @return boolean
	  */
	 public static boolean isPalindrome(char[] word)
	 {
		 int i = 0;
		 int i2 = word.length - 1;
	    
		 while (i2 > i) 
		 {
			 if (word[i] != word[i2]) 
			 {
				 return false;
			 }
			 i++;
			 i2--;
		 }
		 return true;
	 }
	
	 /**
	  * Test's whether input chars form a palindrome or not.
	  * @param str
	  * @return boolean
	  */
	 public static boolean isPalindrome2(String str) 
	 {    
		 int n = str.length();
		 for (int i = 0; i < n/2; i++) 
		 {
			 if (str.charAt(i) != str.charAt(n-i-1)) 
			 {
				 return false;
			 }
		 }
		 return true;    
	 }
	
	 /**
	  * Test's whether input chars form a palindrome or not.
	  * @param str
	  * @return boolean
	  */
	 public static boolean isPalindrome3(String str) 
	 {
		 return str.equals(new StringBuilder(str).reverse().toString());
	 }
}
