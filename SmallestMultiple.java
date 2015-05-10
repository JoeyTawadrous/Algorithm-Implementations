package algorithms;


/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * 
 * @author joeytawadrous
 */
public class SmallestMultiple {
	
	public static void main(String[] args) {
		smallestMultiple();
	}
	
	public static void smallestMultiple() {
		
		int j = 100; 
		
		for(int i = 2; i < 11; i++) {
			
			while(!(j % i == 0)) {
				j++;
			}
			
			System.out.println(j);
		}
		
		
	}
}
