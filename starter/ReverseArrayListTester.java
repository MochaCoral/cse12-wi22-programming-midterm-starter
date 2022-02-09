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
public class ReverseArrayListTester {
    public MyArrayList<String> listThreeElements;
    public boolean exceptionThrown;
    /**
     * Run before every test
     */
    @Before
    public void setUp(){
        String[] arr = {"gold", "silver", "crystal"};
        exceptionThrown = false;
        listThreeElements = new MyArrayList<String>(arr);
    }


    /**
     * Tests reverseRegion method when either fromIndex or toIndex
     * or both are out of bounds.
     */
    @Test
    public void testReverseIndexOutOfBounds(){
        try{
            listThreeElements.reverseRegion(2, 4);
        }
        catch (IndexOutOfBoundsException e) {
            exceptionThrown = true;
        }
        assertTrue("Index out of bounds exception has been thrown", exceptionThrown);
    }

    /**
     * Tests reverseRegion method when
     * fromIndex > toIndex
     */
    @Test
    public void testReverseFromIndexGreater(){
        listThreeElements.reverseRegion(2, 1);
        assertEquals("Element one should remain unchanged", 
            "gold", listThreeElements.get(0));
        assertEquals("Element two should remain unchange", 
            "silver", listThreeElements.get(1));
        assertEquals("Element three should remain unchagned", 
            "crystal", listThreeElements.get(2));
    }

    /**
     * Tests reverseRegion method when
     * fromIndex and toIndex are within bounds
    */
    @Test
    public void testReverseIndexWithinBounds(){
        listThreeElements.reverseRegion(0, 2);
        assertEquals("Element one should have swapped with element three", 
            "crystal", listThreeElements.get(0));
        assertEquals("Element two should remain unchanged", 
            "silver", listThreeElements.get(1));
        assertEquals("Element three should have swapped with element one", 
            "gold", listThreeElements.get(2));
    }

    /**
     * Custom test
    */
    //test when fromIndex == toIndex
    @Test
    public void testReverseCustom(){
        listThreeElements.reverseRegion(1, 1);
        assertEquals("Element one should remain unchanged", 
            "gold", listThreeElements.get(0));
        assertEquals("Element two should remain unchange", 
            "silver", listThreeElements.get(1));
        assertEquals("Element three should remain unchagned", 
            "crystal", listThreeElements.get(2));    
    }
}
