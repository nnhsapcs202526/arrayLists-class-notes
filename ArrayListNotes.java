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
        removeLessThan(myList, 10.0);
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
         * ArrayList is a class that represents an ordered collection of elements of the same type.
         * 
         * The ArrayList is a Java generic.
         * 
         * We have to specify the class type of the elements in the list in angle brackets (i.e., <>)
         *      after every ArrayList identifier.
         *      
         * Primitives (e.g., int, double, boolean) are not classes and cannot be specifed as the type of element
         *      in a generic. Instead, we can use the corresponding Wrapper Classes (e.g., Integer, Double, Boolean).
         */
        ArrayList<Double> list = new ArrayList<Double>();
        
        /*
         * ArrayLists are most similar to lists in Python, and much like lists, ArrayLists have many mutator methods which 
         *      provide easy access to common list operations, such as add, remove, etc.
         */
        
        for(int i = 0; i < size; i++)
        {
            double value = Math.random() * range;
            /*
             * The add method adds the specifed object to the end of the list.
             * 
             * Autoboxing:
             *      Primitive values are automatically converted to the thier corresponding wrapper class.
             *          However, type promotion does not occur.
             */
            
            list.add(value);
            //list.add(10);  // no type promotion
        }
        
        return list;
    }
    
    /**
     * Removes even numbers from the specified list.
     * 
     * @param list  the list of number of potentially remove
     * @param limit the number below which to remove numbers
     */
    public static void removeLessThan(ArrayList<Double> list, double limit)
    {
        /*
         * The size method returns the number of elements in the list.
         */
        for(int i = 0; i < list.size(); i++)
        {
            /*
             * The get method returns the value of the element at the specified index.
             * 
             */
            double value = list.get(i);
            if(value < limit)
            {
                /*
                 * The remove method deletes the element at the specified index from the list. All subsequent elements
                 *      are "shifted left".
                 */
                list.remove(i);
                i--;
                
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