package algorithms;


import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
 
public class FlattenLinkedList
{
	public static void main(String[] args) 
    {
        // List of strings
        LinkedList<String> stringList = new LinkedList<String>();
        for (Integer i = 0; i < 10; i++) {
        	stringList.add("String #" +i.toString());
        }

        // List of integers
        LinkedList<Integer> intList = new LinkedList<Integer>();
        for (Integer i = 10; i < 20; i++) {
            intList.add(i);
        }

        // Nested Lists
        LinkedList<Object> nestedList = new LinkedList<Object>();

        nestedList.add("Nested String 1");
        nestedList.add("Nested String 2");

        LinkedList<Object> bigList = new LinkedList<Object>();

        bigList.add("First item");
        bigList.add(stringList);
        bigList.add("Third Item");
        bigList.add(intList);
        bigList.add("Fifth Item");
        bigList.add(nestedList);
        bigList.add("Seventh Item");

        List<Object> flattenedListRecursion = flattenList(bigList);
        List<Object> flattenedList = flattenListNoRecursion(bigList);
        
        printList(flattenedListRecursion);
        printList(flattenedList);
    }
	
	@SuppressWarnings("unchecked")
	/**
	 * Flattens a given list.
	 * @param list
	 * @return
	 */
	public static List<Object> flattenList(List<Object> inList) 
	{
        List<Object> newList = new LinkedList<Object>();
 
        for (Object i : inList) 
        {
            // If it's not a list, just add it to the return list.
            if (!(i instanceof List))
            {
                newList.add(i);
            }
            else 
            {
                // It's a list, so add each item to the return list.
                newList.addAll(flattenList((List<Object>)i));
            }
        }
        return newList;
    }
 
    @SuppressWarnings("unchecked")
    public static List<Object> flattenListNoRecursion(List<Object> inList) {
        List<Object> tempList = null;
 
        // Clone the input list to newList
        List<Object> newList = new LinkedList<Object>();
        newList.addAll(inList);
 
        ListIterator<Object> iterator = newList.listIterator();
 
        int currentPosition = 0;
 
        while (iterator.hasNext()) {
            Object i = iterator.next();
            
            if (!(i instanceof List)) {
                // If it's not a list, advance the position.  Don't advance position if this IS a list.
                currentPosition++;
            } else {
                // If the current item is a list, save it to a temp var.
                tempList = (List<Object>) i;
 
                // Delete the list from the list
                iterator.remove();
 
                // Add each item from the temp list to the master list at the same position the sublist was removed.
                for (Object obj : tempList) {
                    iterator.add(obj);
                }
 
                // reset the iterator to re-walk the list that was just inserted (within the master) to check for more lists.
                iterator = newList.listIterator(currentPosition);
            }
        }
        return newList;
    }
 
    /**
     * Prints a given list.
     * @param list
     */
    public static void printList(List<Object> list)
    {
        int i = 0;
            
        for (Object item : list) 
        {
        	System.out.println("List item #"+i +": "+item);
            i++;
        }
    }
}