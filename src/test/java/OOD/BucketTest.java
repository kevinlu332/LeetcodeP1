package OOD;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BucketTest {
    private Bucket<String> bucket;

    @BeforeEach
    void setUp() {
        bucket = new Bucket<>();
    }

    @Test
    void testConstructor() {
        assertNotNull(bucket.getList());
        assertTrue(bucket.getList().isEmpty());
    }

    @Test
    void testAddElement() {
        bucket.getList().add("apple");
        bucket.getList().add("banana");
        bucket.getList().add("cherry");

        List<String> list = bucket.getList();
        assertEquals(3, list.size());
        assertTrue(list.contains("apple"));
        assertTrue(list.contains("banana"));
        assertTrue(list.contains("cherry"));
    }

    @Test
    void testRemoveElement() {
        bucket.getList().add("apple");
        bucket.getList().add("banana");
        bucket.getList().add("cherry");

        bucket.getList().remove("banana");

        List<String> list = bucket.getList();
        assertEquals(2, list.size());
        assertTrue(list.contains("apple"));
        assertFalse(list.contains("banana"));
        assertTrue(list.contains("cherry"));
    }

    @Test
    void testClearBucket() {
        bucket.getList().add("apple");
        bucket.getList().add("banana");
        bucket.getList().add("cherry");

        bucket.getList().clear();

        assertTrue(bucket.getList().isEmpty());
    }
}
