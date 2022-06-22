/*
Time Complexity : O(1) since everything is done by hashing. Rarely it will have all same hashed elements.
Space Complexity : O(n) since we create memory when array is generated

Did this code successfully run on Leetcode :
Finished in 63 ms
false
false
-1
true
true
true
true
3
false
true
4
true
false
true

Any problem you faced while coding this :
None

Your code here along with comments explaining your approach :
Straight forward approach.
I wrote HashMap first reading the readme.md then saw the mail for HashSet.
Since I had written already so decided to submit it.
I wrote HashSet from HashMap 

The comments after sysouts were expected output and they matched.
*/
import java.util.ArrayList;
import java.util.List;

class Pair<A, B>{
    private A key;
    private B value;
    Pair(A key, B value){
        this.key = key;
        this.value = value;
    }

    boolean hasKey(A key){
        return this.key.equals(key);
    }

    A getKey(){
        return key;
    }

    void setValue(B value){
        this.value = value;
    }

    B getValue(){
        return value;
    }
}

public class MyHashMap {
    private final int HASH_SIZE = 1000;
    private List<Pair<Integer, Integer>>[] storage;

    public MyHashMap() {
        storage = new ArrayList[HASH_SIZE];
    }

    private int getHashedIndex(int key){
        return key % HASH_SIZE;
    }

    private int getPosition(int key){
        int index = getHashedIndex(key);
        if(storage[index] == null){
            return -1;
        }
        for(int pos = 0; pos < storage[index].size(); pos++){
            if(storage[index].get(pos).hasKey(key)){
                return index;
            }
        }
        return -1;
    }

    public boolean add(int key, int value){
        int index = getHashedIndex(key);
        if(storage[index] == null){
            storage[index]=new ArrayList<>();
            storage[index].add(new Pair(key, value));
            return true;
        }

        for(int pos = 0; pos < storage[index].size(); pos++){
            //To avoid duplication
            if(storage[index].get(pos).hasKey(key)){
                storage[index].get(pos).setValue(value);
                return false;
            }
        }
        storage[index].add(new Pair(key, value));
        return true;
    }

    public boolean remove(int key){
        int index = getHashedIndex(key);
        if(storage[index] == null){
            return false;
        }
        for(int pos = 0; pos < storage[index].size(); pos++){
            //To avoid duplication
            if(storage[index].get(pos).hasKey(key)){
                storage[index].remove(pos);
                if(storage[index].isEmpty()){
                    storage[index]=null;
                }
                return true;
            }
        }
        return false;
    }

    public int get(int key){
        int index = getHashedIndex(key);
        if(storage[index] == null){
            return -1;
        }
        for(int pos = 0; pos < storage[index].size(); pos++){
            //To avoid duplication
            if(storage[index].get(pos).hasKey(key)){
                return storage[index].get(pos).getValue();
            }
        }
        return -1;

    }

    public boolean contains(int key) {
        return (getPosition(key) > -1);
    }

    public static void main(String[] args) {
        MyHashMap set = new MyHashMap();
        System.out.println(set.remove(2));//false
        System.out.println(set.contains(2));//false
        System.out.println(set.get(2));//-1
        System.out.println(set.add(1, 3));//true
        System.out.println(set.contains(1));//true
        System.out.println(set.add(2, 3));//true
        System.out.println(set.contains(2));//true
        System.out.println(set.get(2));//3
        System.out.println(set.add(2, 4));//false -- 2 already present should rewrite
        System.out.println(set.contains(2));//true
        System.out.println(set.get(2));//4
        System.out.println(set.remove(2));//true
        System.out.println(set.contains(2));//false
        System.out.println(set.contains(1));//true

    }
}
