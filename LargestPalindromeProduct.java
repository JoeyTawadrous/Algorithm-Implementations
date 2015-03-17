package algorithms;


/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * @author joeytawadrous
 */
public class LargestPalindromeProduct {
	
	public static void main(String[] args) {
		System.out.println(sixDigitPalindrome());
	}
	
	public static int sixDigitPalindrome() {
		
		int max = 0;
		
		for(int i = 999; i > 100; i--) {
			
			for(int j = i; j > 100; j--) {
				String number = Integer.toString((i * j));

				if(number.length() == 6
				&& number.charAt(0) == number.charAt(5) 
				&& number.charAt(1) == number.charAt(4) 
				&& number.charAt(2) == number.charAt(3) 
				&& Integer.parseInt(number) > max) {
					max = i * j;
				}
			}
		}
		
		return max;
	}
}