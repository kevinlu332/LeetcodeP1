package OOD;

import java.util.List;

public class HashMapImpl<K,V> implements HashMap<K,V> {
    //requirement:
    //part 1: do the CRUD
    //part 2: do the rehash() when 75% occupied

    protected static int DEFAULT_CAPACITY = 8;
    private static int SIZE;

    private Bucket<Pair<K,V>>[] hashTable;
    public HashMapImpl(){
        this.hashTable = new Bucket[DEFAULT_CAPACITY];
        for(int i = 0; i < DEFAULT_CAPACITY; i++){
            hashTable[i] =  new Bucket<>();
        }
        SIZE = 0;
    }

    public void put(K key, V value){
        if(key == null) return;
        if(containsKey(key)) delete(key);
        int index = hash(key);
        if(hashTable[index].list.isEmpty()) SIZE++;
        hashTable[index].list.add(new Pair<K,V>(key,value));
        if(isOver75PercentCapacity()) rehash();
    }

    public V get(K key){
        int index = hash(key);
        List<Pair<K,V>> list = hashTable[index].getList();
        for(Pair<K,V> pair: list){
            if(pair.getK().equals(key)) return pair.getV();
        }
        return null;
    }

    public void delete(K key){
        if(key == null) return;
        int index = hash(key);
        List<Pair<K,V>> list = hashTable[index].getList();
        list.removeIf(pair -> pair.getK().equals(key));
    }

    protected int hash(K key){
        if(key == null) return 0;
        int hashNumber = key.hashCode();
        if (hashNumber < 0) hashNumber = -hashNumber;
        return hashNumber % DEFAULT_CAPACITY;
    }

    protected boolean containsKey(K key){
        if(key == null) return false;
        int index = hash(key);
        List<Pair<K,V>> list = hashTable[index].getList();
        for(Pair<K,V> pair: list){
            if(pair.getK().equals(key)) return true;
        }
        return false;
    }
    protected boolean isOver75PercentCapacity(){
        return SIZE > hashTable.length * 0.75;
    }

    protected void rehash(){
        DEFAULT_CAPACITY *= 2;
        Bucket<Pair<K,V>>[] newHashTable = new Bucket[DEFAULT_CAPACITY];
        for(int i = 0; i < DEFAULT_CAPACITY; i++){
            newHashTable[i] =  new Bucket<>();
        }
        for(Bucket<Pair<K,V>> bucket: hashTable){
            for(Pair<K,V> pair: bucket.getList()){
                int index = hash(pair.getK());
                newHashTable[index].getList().add(pair);
            }
        }
        hashTable = newHashTable;
    }

    public int getHashTableCapacity() {
        return DEFAULT_CAPACITY;
    }
}
