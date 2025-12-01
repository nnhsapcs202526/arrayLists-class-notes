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
            }
        }
    }
    
    public static void removeLessThanAlt(ArrayList<Double> list, double limit)
    {
        
    }
    
    public static double sumList(ArrayList<Double> list)
    {
        int sum = 0;
        
        return sum;
    }
}