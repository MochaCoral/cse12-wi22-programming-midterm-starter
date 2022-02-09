/**
 * Name: Morales, Kyle
 * ID: A16162998
 * Email: kmmorale@ucsd.edu
 * File description: 
 * Implementation of the reverseRegion interface method within a reduced array list class
 */

/**
 * This class contains the methods and constructor for an array list, 
 * as well as the node class and its respective methods, 
 * implementing the MyReverseList<E> interface
 */
public class MyArrayList<E> implements MyReverseList<E> {
    static final int DEFAULT_CAPACITY = 5;
    
    Object[] data;
    int size;

    //IMPORTANT: DO NOT MODIFY THIS CONSTRUCTOR!
    //IMPORTANT: DO NOT ADD ANY MORE CONSTRUCTORS!

    /**
     * Constructor to create an array list with the given array's elements
     * @param arr - array of elements to be used to construct the ArrayList
     */
    public MyArrayList(E[] arr) {
        if (arr == null) {
            this.data = new Object[DEFAULT_CAPACITY];
        } else {
            this.data = arr.clone();
            this.size = arr.length;
        }
    }

    /**
     * method for reversing the order of elements in a list 
     * from position fromIndex to position toIndex
     * @param fromIndex starting position index
     * @param toIndex terminating position index
     */
    public void reverseRegion(int fromIndex, int toIndex) throws IndexOutOfBoundsException {
       E from;
        if(fromIndex >= this.size() || toIndex >= this.size() 
        || fromIndex < 0 || toIndex < 0) {
            throw new IndexOutOfBoundsException();
        }
        else if (fromIndex >= toIndex) {
            return;
        }
        else {
            for(int i = 0; i <= (toIndex - fromIndex) / 2; i++) {
                from = this.get(i + fromIndex);
                this.data[i + fromIndex] = this.get(toIndex - i);
                this.data[toIndex - i] = from;
            }
        }
    }

    @Override
    /**
     * A method that returns the number of valid elements
     * in the ArrayList 
     * @return - number of valid elements in the arraylist
     */
    public int size() {
        return this.size;
    }

    @Override
    /**
     * A method that returns an Element at the specified index
     * @param index - the index of the return Element
     * @return Element at specified index
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) data[index];
    }
}
