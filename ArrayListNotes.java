import java.util.ArrayList;

/**
 * Class notes on ArrayLists.
 *
 * @author mrcallaghan
 * @version 01dec2025
 */
public class ArrayListNotes
{
    public static void main(String[] args)
    {
        ArrayList<Double> myList;
        myList = createRandomDoubleList(10, 20);
        System.out.println(myList);
        removeLessThanAlt(myList, 10.0);
        System.out.println(myList);
        System.out.println("Average: " + avgList(myList));
        System.out.println(myList);
    }
    
    /**
     * Creates and returns a reference to an ArrayList of the specified number of
     *      Double elements where each element is assigned a random value between
     *      1 and range.
     *      
     *  @param size     the number of Double elements to add to the list
     *  @param range    the range of random values to assign to each element [0, range)
     *  
     *  @return a reference to the newly created and initialized list
     */
    public static ArrayList<Double> createRandomDoubleList(int size, int range)
    {
        /*
         * The ArrayList is a class that represents an ordered collection of elements of the same type.
         * 
         * The ArrayList is a Java Generic.
         * 
         * We have to specify the class type of the elements in the list in angle brackets (e.g., < >)
         *      after every ArrayListidentifier.
         *      
         * Primitives (e.g., int, double, boolean) are not classes and cannot be speciefed as the type of the element
         *      in a generic.  Instead, we can use th corresponding wrapper class (e.g., Integer, Double, Boolean).
         */
        ArrayList<Double> list = new ArrayList<Double>();
        
        /*
         * ArrayLists are most similar to Python lists, and much like lists, ArrayLists have many mutator and accessor methods
         *      which provide easy access to common operations, such as get, add and remove.
         */
        for( int i = 0; i < size; i++)
        {
            double value = Math.random() * range;
            
            /*
             * Autoboxing:
             *      Primitive values are automatically converted to their corresponding wrapper class.  However,
             *          type promotion does not occur.
             */
            
            list.add(value);
            //list.add(10);  // no type promotion
        }
        
        return list;
    }
    
    /**
     * Removes numbers less than the specified limit.
     * 
     * @param list  the list of number of potentially remove
     * @param limit the number of which to remove values less than
     */
    public static void removeLessThan(ArrayList<Double> list, double limit)
    {
        /*
         * The size method return the number of elements in the ArrayList
         */
        for(int i = 0; i < list.size(); i++)
        {
            /*
             * The get method returns the value of the element at the specified index.
             */
            double value = list.get(i);
            if(value < limit)
            {
                /*
                 * The remove method removes the element at the specified index.  All items after the removed item
                 *      shift left.
                 */
                list.remove(i);
                i--;
            }
        }
    }
    
    public static void removeLessThanAlt(ArrayList<Double> list, double limit)
    {
        for(int i = list.size() - 1; i >= 0; i--)
        {
            if (list.get(i) < limit)
            {
                list.remove(i);
            }
        }
    }
    
    /**
     * Returns the average from a list of numbers.
     * 
     * @param list the list to average
     * @return the computed average
     */
    public static double avgList(ArrayList<Double> list)
    {
        double sum = 0;
        /*
         * Enhanced for loops
         * 
         * Iterates over each elemnt in the list.  Similar to the Python for loop (e.g., for value in...).
         * The value of the loop variable is the actual value of each element in the list, not the index.
         * 
         * Java will automatically "unbox" each Wrapper Class object (e.g., Integer, Double)
         *      into the appropriate primitive type (int, double).
         *      
         * Eliminates the possibility of an out of bound error.
         */        
        for (double value : list) // "for each value in the list"
        {
            sum += value;
            /*
             * Limitations of enhaced for loops:
             * 
             * The local variable (e.g., value) contains a copy of the value of the element in the list.
             * 
             * We cannot chnage the value of the element directly.
             */
            value += 1;
            
            /*
             * Modifying the list (e.g., add, remove, etc.) inside an enhanced for loop generates a
             *      ConcurrentModificationException.
             */
            //list.add(7.7);
            
            // We cannot access index values as easily.  The "i" in a regular for loop isn't available.
        }
        
        return sum / list.size();
    }
}