package algorithms;


/**
 * Format an RGB value (three 1-byte numbers) as a 6-digit hexadecimal string.
 * 
 * @author joeytawadrous
 */
public class RGBtoHEX 
{
	public static void main (String[] args) 
	{
		System.out.println(formatRGB(3,3,3));
    }
	
	/**
	 * Format an RGB value (three 1-byte numbers) as a 6-digit hexadecimal string.
	 * @param r
	 * @param g
	 * @param b
	 * @return Hex numbers
	 */
	public static String formatRGB(int r, int g, int b) 
	{
        return(toHex(r) + toHex(g) + toHex(b)).toUpperCase();
    }

	/**
	 * Converts int number to Hex.
	 * @param c
	 * @return hex number
	 */
    public static String toHex(int c) 
    {
        String s = Integer.toHexString(c);
        return(s.length() == 1) ? "0" + s : s;
    }
}
