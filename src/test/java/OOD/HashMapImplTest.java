package OOD;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class HashMapImplTest {
    private HashMapImpl<String, Integer> hashMap;

    @BeforeEach
    public void setUp() {
        hashMap = new HashMapImpl<>();
    }

    @Test
    public void testPutAndGet() {
        hashMap.put("apple", 1);
        hashMap.put("banana", 2);
        hashMap.put("cherry", 3);

        assertEquals(Integer.valueOf(1), hashMap.get("apple"));
        assertEquals(Integer.valueOf(2), hashMap.get("banana"));
        assertEquals(Integer.valueOf(3), hashMap.get("cherry"));
        assertNull(hashMap.get("orange"));
    }

    @Test
    public void testDelete() {
        hashMap.put("apple", 1);
        hashMap.put("banana", 2);
        hashMap.put("cherry", 3);

        hashMap.delete("banana");

        assertNull(hashMap.get("banana"));
        assertEquals(Integer.valueOf(1), hashMap.get("apple"));
        assertEquals(Integer.valueOf(3), hashMap.get("cherry"));
    }

    @Test
    public void testNullKey() {
        hashMap.put(null, 1); // Should not add null key
        assertNull(hashMap.get(null));
    }

    @Test
    public void testResize() {
        // Add enough elements to trigger resizing
        for (int i = 0; i < 10; i++) {
            hashMap.put("key" + i, i);
        }

        // Check that all elements are still accessible
        for (int i = 0; i < 10; i++) {
            assertEquals(Integer.valueOf(i), hashMap.get("key" + i));
        }
    }

    @Test
    public void testHashFunction() {
        // Test the hash function with different keys
        String key1 = "apple";
        String key2 = "banana";
        String key3 = "cherry";

        int hash1 = hashMap.hash(key1);
        int hash2 = hashMap.hash(key2);
        int hash3 = hashMap.hash(key3);

        assertNotEquals(hash1, hash2);
        assertNotEquals(hash2, hash3);
        assertNotEquals(hash1, hash3);
    }

    @Test
    void testContainsKey_NullKey() {
        assertFalse(hashMap.containsKey(null));
    }

    @Test
    void testContainsKey_EmptyHashMap() {
        assertFalse(hashMap.containsKey("apple"));
    }

    @Test
    void testContainsKey_KeyPresent() {
        hashMap.put("apple", 1);
        hashMap.put("banana", 2);
        hashMap.put("cherry", 3);

        assertTrue(hashMap.containsKey("apple"));
        assertTrue(hashMap.containsKey("banana"));
        assertTrue(hashMap.containsKey("cherry"));
    }

    @Test
    void testContainsKey_KeyNotPresent() {
        hashMap.put("apple", 1);
        hashMap.put("banana", 2);
        hashMap.put("cherry", 3);

        assertFalse(hashMap.containsKey("orange"));
    }

    @Test
    void testContainsKey_DuplicateKeys() {
        hashMap.put("apple", 1);
        hashMap.put("banana", 2);
        hashMap.put("apple", 3); // Duplicate key

        assertTrue(hashMap.containsKey("apple"));
        assertTrue(hashMap.containsKey("banana"));
    }

    @Test
    void testContainsKey_AfterDelete() {
        hashMap.put("apple", 1);
        hashMap.put("banana", 2);
        hashMap.put("cherry", 3);

        hashMap.delete("banana");

        assertFalse(hashMap.containsKey("banana"));
        assertTrue(hashMap.containsKey("apple"));
        assertTrue(hashMap.containsKey("cherry"));
    }
}
