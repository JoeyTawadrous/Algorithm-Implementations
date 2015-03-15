package algorithms;


/**
 * Given a regular expression with characters a-z, ' * ', ' . ' 
 * the task was to find if that string could match another string with characters from: a-z 
 * where ' * ' can delete the character before it, and '.' could match whatever character. '*' always appear after a a-z character. 
 * Example: 
 * isMatch("a*", "") = true; 
 * isMatch(".", "") = false; 
 * isMatch("ab*", "a") = true; 
 * isMatch("a.", "ab") = true; 
 * isMatch("a", "a") = true;
 * 
 * @author joeytawadrous
 */
public class StringMatch 
{
	public static void main(String[] args) { 
		 String s1 = "a*abc"; 
		 String s2 = "abc"; 
		 System.out.println(isMatch(s1, s2, 0, 0)); 
		 
		 String s3 = "a*a*a"; 
		 String s4 = "a"; 
		 System.out.println(isMatch(s3, s4, 0, 0)); 
		 
		 String s5 = "a."; 
		 String s6 = "ab"; 
		 System.out.println(isMatch(s5, s6, 0, 0)); 
		 
		 String s7 = "a*bd*c"; 
		 String s8 = "abdc"; 
		 System.out.println(isMatch(s7, s8, 0, 0)); 
		 
		 String s9 = "a."; 
		 String s10 = "s"; 
		 System.out.println(isMatch(s9, s10, 0, 0)); 
	} 

	/**
	 * Checks 
	 * @param s1
	 * @param s2
	 * @param posS1
	 * @param posS2
	 * @return boolean
	 */
	public static boolean isMatch(String s1, String s2, int posS1, int posS2)
	{ 
		int l1 = s1.length(); 
		int l2 = s2.length(); 
//		System.out.println("posS1:"+posS1+"    posS2:"+posS2); 
		
		
		if(posS1 > l1 || posS2 > l2)
		{ 
			return false; 
		}
		else if(posS1 == l1 && posS2 == l2)
		{ 
			return true; 
		}
		else
		{ 
			if(posS2 < l2 && posS1 < l1 && ((s1.charAt(posS1) == s2.charAt(posS2)) || s1.charAt(posS1) == '.'))
			{ 
				return isMatch(s1, s2, posS1+1, posS2+1); 
			}
			else if(posS1 < l1 && s1.charAt(posS1) == '*')
			{ 
				if(posS2 > 0)
				{ 
					return isMatch(s1, s2, posS1+1, posS2-1) || isMatch(s1, s2, posS1+1, posS2); 
				}
				else
				{ 
					return isMatch(s1, s2, posS1+1, posS2); 
				} 
			}
			else
			{ 
				if(posS1+1 < l1 && s1.charAt(posS1+1) == '*')
				{ 
					return isMatch(s1, s2, posS1+2, posS2); 
				}
				else
				{ 
					return false; 
				} 
			} 
		} 
	} 	
}
