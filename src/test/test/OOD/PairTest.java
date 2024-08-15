package test.test.OOD;

import OOD.Pair;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

//This class contains unit tests for the Pair class
//class created via the asking to Amazon Q for unit test generation and comments generation.
class PairTest {

    //This test case checks if the constructor of the Pair class initializes the k and v fields correctly
    @Test
    void testConstructor() {
        Pair<String, Integer> pair = new Pair<>("hello", 42);
        assertEquals("hello", pair.getK()); //Asserts that the k field is initialized with "hello"
        assertEquals(42, pair.getV()); //Asserts that the v field is initialized with 42
    }

    //This test case checks if the setters of the Pair class work as expected
    @Test
    void testSetters() {
        Pair<Double, Boolean> pair = new Pair<>(3.14, true);
        pair.setK(2.718); //Sets the k field to 2.718
        pair.setV(false); //Sets the v field to false
        assertEquals(2.718, pair.getK()); //Asserts that the k field is set to 2.718
        assertFalse(pair.getV()); //Asserts that the v field is set to false
    }

    //This test case checks if the Pair class handles null values correctly
    @Test
    void testNullValues() {
        Pair<String, Integer> pair = new Pair<>(null, null);
        assertNull(pair.getK()); //Asserts that the k field is null
        assertNull(pair.getV()); //Asserts that the v field is null
    }
}

