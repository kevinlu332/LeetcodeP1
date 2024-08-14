package OOD;

import java.util.ArrayList;
import java.util.List;

public class HashMapImpl implements HashMap {
    Bucket[] hashTable;
    public HashMapImpl(){
        hashTable = new Bucket[100];
        for(int i = 0; i < 100; i++){
            hashTable[i] =  new Bucket();
        }
    }

    public void put(String key, String value){

    }
    public String get(String key){

        return "ans";
    }
    public void delete(String key){

    }


}
