package algorithms;

import java.io.BufferedReader;
import java.io.FileReader;


/**
 * Prints the sum of numbers in a file (one number per line in the file).
 * 
 * @author joeytawadrous
 */
public class FileSum
{
	public static void main (String[] args) 
	{
		sumFile("FileSumFile.txt");
    }
	
	/**
	 * Prints the sum of numbers in a file.
	 * @param name
	 */
	public static void sumFile(String name)
	{
        try
        {
            int total = 0;
            BufferedReader in = new BufferedReader(new FileReader(name));
            
            for(String s = in.readLine(); s != null; s = in.readLine())
            {
                total += Integer.parseInt(s);
            }
            
            System.out.println(total);
            in.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
