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
         * ArrayList is a class that represents an ordered collection of element of the same type.
         * 
         * The ArrayList is a Java Generic.
         * 
         * We have to sepecify the class type of the elements in the list in angle brackets (i.e., < >)
         *      after every ArrayList identifier.
         *      
         * Primitives (e.g., int, double, boolean) are not classes and cannot be specified as the type of the
         *      element in a generic.  Instead, we can use the corresponding wrapper classes (e.g., Integer, Double,
         *      Boolean).
         */
        ArrayList<Double> list = new ArrayList<Double>();
        
        /*
         * ArrayLists are most similar to lists in Python, and much like lists, ArrayLists have many
         *      methods which provide easy access to common operations, such as add and remove.
         */
        for(int i = 0; i < size; i++)
        {
            double value = Math.random() * range;
            /*
             * The add method adds the specifed object to the end of the list.
             * 
             * Autoboxing:
             *      primitive values are automatically converted to their corresponding wrapper class. However,
             *      type promotion does not occur.
             */
            list.add(value);
            //list.add(10);  // no type promotion; does not compile
            
        }
        
        return list;
    }
    
    /**
     * Removes numbers less than the specified limit.
     * 
     * @param list  the list of numbers to potentially remove from
     * @param limit the limit of which to remove numbers less than
     */
    public static void removeLessThan(ArrayList<Double> list, double limit)
    {
        /*
         * The size method returns the number of elements in the ArrayList.
         */
        for(int i = 0; i < list.size(); i++)
        {
            /*
             * The get method returns the value of the element at the specified index.
             * 
             * Autoboxing feature will also "unbox" the wrapper class.
             */
            double value = list.get(i);
            if(value < limit)
            {
                /*
                 * The remove method deletes the element at the specified index from the list. All subsequent 
                 *      elements get shifted "left".
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
            if(list.get(i) < limit)
            {
                list.remove(i);
            }
        }    
    }
    
    public static double sumList(ArrayList<Double> list)
    {
        int sum = 0;
        
        return sum;
    }
}