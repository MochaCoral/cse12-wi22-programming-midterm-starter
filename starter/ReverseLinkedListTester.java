/**
 * Tests to check the implementation of reverseRegion method in MyArrayList.java
*/

//other import statements
import static org.junit.Assert.*;

import org.junit.*;

//IMPORTANT: DO NOT MODIFY THE TEST HEADERS!
/**
 * This class contains various test cases to test the reverseRegion method
 */
public class ReverseLinkedListTester {
    public MyLinkedList<Integer> listFiveElements;
    public boolean exceptionThrown;
    /**
     * Run before every test
     */
    @Before
    public void setUp(){
        Integer[] arr = {1, 2, 3, 4, 5};
        listFiveElements = new MyLinkedList<Integer>(arr);
        exceptionThrown = false;

    }


    /**
     * Tests reverseRegion method when either fromIndex or toIndex
     * or both are out of bounds.
     */
    @Test
    public void testReverseIndexOutOfBounds(){
        try {
            listFiveElements.reverseRegion(-5, 3);
        }
        catch(IndexOutOfBoundsException e){
            exceptionThrown = true;
        }
        assertTrue("Index out of bounds has been thrown", exceptionThrown);
    }

    /**
     * Tests reverseRegion method when
     * fromIndex > toIndex
     */
    @Test
    public void testReverseFromIndexGreater(){
        listFiveElements.reverseRegion(4, 1);
        assertEquals("Element 0 should remain unchanged", 1, (int) listFiveElements.get(0));
        assertEquals("Element 2 should remain unchanged", 2, (int) listFiveElements.get(1));
        assertEquals("Element 3 should remain unchanged", 3, (int) listFiveElements.get(2));
        assertEquals("Element 4 should remain unchanged", 4, (int) listFiveElements.get(3));
        assertEquals("Element 5 should remain unchanged", 5, (int) listFiveElements.get(4));

    }

    /**
     * Tests reverseRegion method when
     * fromIndex and toIndex are within bounds
    */
    @Test
    public void testReverseIndexWithinBounds(){
        listFiveElements.reverseRegion(1, 4);
        assertEquals("Element 0 should remain unchanged", 1, (int) listFiveElements.get(0));
        assertEquals("Element 1 should have swapped with element 4", 5, (int) listFiveElements.get(1));
        assertEquals("Element 2 should have swapped with Element 3", 4, (int) listFiveElements.get(2));
        assertEquals("Element 3 should have swapped with element 2", 3, (int) listFiveElements.get(3));
        assertEquals("Element 4 should have swapped with Element 1", 2, (int) listFiveElements.get(4));

    }

    /**
     * Custom test
    */
    @Test
    public void testReverseCustom(){
        assertFalse(false);
    }


}

