package algorithms;


/**
 * Simple class to reverse a string.
 * 
 * @author joeytawadrous
 */
public class ReverseString
{
	public static void main(String[] args) 
	{
		System.out.println(reverse("tree"));
	}
	
	/**
	 * Reverse string.
	 * @param string
	 * @return revString
	 */
	public static String reverse(String string)
	{
		String revString = "";
		char[] charArray = string.toCharArray();
		
		for(char c : charArray)
		{
			revString = c + revString;
		}
		
		return revString;
	}
}
