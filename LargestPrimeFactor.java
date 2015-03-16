package algorithms;


/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * @author joeytawadrous
 */
public class LargestPrimeFactor {
	
	public static void main(String[] args) {
		long numberToFactor = 600851475143l; 
		int currentDivisor = 2;
		int largestDivisor = 0;
		
		while (numberToFactor != 1) { // cannot divide any further
			
			if(numberToFactor % currentDivisor == 0) { // no remainder
				numberToFactor = numberToFactor / currentDivisor;
				largestDivisor = currentDivisor;
				currentDivisor = 2;
			}
			else {
				currentDivisor++;
			}
			
		}
		
		System.out.println("NumberToFactor: " + numberToFactor + " :: CurrentDivisor: " + currentDivisor + " :: LargestDivisor: " + largestDivisor);
	}
}
