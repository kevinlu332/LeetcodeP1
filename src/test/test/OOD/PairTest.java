package test.test.OOD;

import OOD.Pair;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;

//generated via Amazon Q by asking for unit tests generation.
class PairTest {

    @Test
    void testConstructor() {
        Pair<String, Integer> pair = new Pair<>("hello", 42);
        assertEquals("hello", pair.getK());
        assertEquals(42, pair.getV());
    }

    @Test
    void testSetters() {
        Pair<Double, Boolean> pair = new Pair<>(3.14, true);
        pair.setK(2.718);
        pair.setV(false);
        assertEquals(2.718, pair.getK());
        assertFalse(pair.getV());
    }

    @Test
    void testNullValues() {
        Pair<String, Integer> pair = new Pair<>(null, null);
        assertNull(pair.getK());
        assertNull(pair.getV());
    }
}