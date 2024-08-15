package OOD;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashMapImplTest {
    private HashMapImpl<String, Integer> hashMap;

    @BeforeEach
    void setUp() {
        hashMap = new HashMapImpl<>();
    }

    @Test
    void testPut() {
        hashMap.put("apple", 1);
        hashMap.put("banana", 2);
        hashMap.put("cherry", 3);

        assertEquals(1, hashMap.get("apple"));
        assertEquals(2, hashMap.get("banana"));
        assertEquals(3, hashMap.get("cherry"));
    }

    @Test
    void testPutNullKey() {
        hashMap.put(null, 1);
        assertNull(hashMap.get(null));
    }

    @Test
    void testPutOverwriteExistingKey() {
        hashMap.put("apple", 1);
        hashMap.put("apple", 2);
        assertEquals(2, hashMap.get("apple"));
    }

    @Test
    void testGet() {
        hashMap.put("apple", 1);
        hashMap.put("banana", 2);
        hashMap.put("cherry", 3);

        assertEquals(1, hashMap.get("apple"));
        assertEquals(2, hashMap.get("banana"));
        assertEquals(3, hashMap.get("cherry"));
        assertNull(hashMap.get("orange"));
    }

    @Test
    void testDelete() {
        hashMap.put("apple", 1);
        hashMap.put("banana", 2);
        hashMap.put("cherry", 3);

        hashMap.delete("banana");

        assertNull(hashMap.get("banana"));
        assertEquals(1, hashMap.get("apple"));
        assertEquals(3, hashMap.get("cherry"));
    }

    @Test
    void testDeleteNullKey() {
        hashMap.put("apple", 1);
        hashMap.delete(null);
        assertEquals(1, hashMap.get("apple"));
    }

    @Test
    void testRehash() {
        int initialCapacity = hashMap.getHashTableCapacity();
        for (int i = 0; i < 10; i++) {
            hashMap.put("key" + i, i);
        }

        assertTrue(initialCapacity < hashMap.getHashTableCapacity());

        for (int i = 0; i < 10; i++) {
            assertEquals(i, hashMap.get("key" + i));
        }
    }

    @Test
    void testHash() {
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
    void testContainsKey() {
        hashMap.put("apple", 1);
        hashMap.put("banana", 2);
        hashMap.put("cherry", 3);

        assertTrue(hashMap.containsKey("apple"));
        assertTrue(hashMap.containsKey("banana"));
        assertTrue(hashMap.containsKey("cherry"));
        assertFalse(hashMap.containsKey("orange"));
        assertFalse(hashMap.containsKey(null));
    }

    @Test
    void testIsOver75PercentCapacity() {
        assertFalse(hashMap.isOver75PercentCapacity());

        for (int i = 0; i < 6; i++) {
            hashMap.put("key" + i, i);
        }
        assertFalse(hashMap.isOver75PercentCapacity());

        hashMap.put("key6", 6);
        assertEquals(16, hashMap.getHashTableCapacity());
    }
}
