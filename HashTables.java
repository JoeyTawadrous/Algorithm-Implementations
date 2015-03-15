package algorithms;

import java.util.*;


/**
 * Simple HashTable operations.
 * 
 * @author joeytawadrous
 */
public class HashTables
{
   public static void main(String args[])
   {
      // Create a hash map
      Hashtable<String, Double> balance = new Hashtable<String, Double>();
      Enumeration<String> names;
      String str;
      double bal;

      balance.put("Zara", new Double(3434.34));
      balance.put("Ayan", new Double(1378.00));
      balance.put("Paud", new Double(-19.08));

      
      // Show all balances in hash table.
      names = balance.keys();
      while(names.hasMoreElements()) 
      {
         str = names.nextElement();
         System.out.println(str + ": " + balance.get(str));
      }
      System.out.println();
      
      
      // Deposit 1,000 into Zara's account
      bal = balance.get("Zara");
      balance.put("Zara", new Double(bal+1000));
      System.out.println("Zara's new balance: " + balance.get("Zara"));
   }
}

