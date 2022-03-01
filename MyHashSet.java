/*
Time Complexity : O(1) since everything is done by hashing. Rarely it will have all same hashed elements.
Space Complexity : O(n) since we create memory when array is generated

Did this code successfully run on Leetcode :
Finished in 98 ms
false
false
true
true
true
true
false
true
true
false
true

Any problem you faced while coding this :
None

Your code here along with comments explaining your approach :
Straight forward approach.
I wrote HashSet from HashMap 

The comments after sysouts were expected output and they matched.

*/
import java.util.ArrayList;
import java.util.List;

public class MyHashSet {
    private final int HASH_SIZE = 1000;
    private List<Integer>[] storage;

    public MyHashSet() {
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
            if(storage[index].get(pos).equals(key)){
                return index;
            }
        }
        return -1;
    }

    public boolean add(int key){
        int index = getHashedIndex(key);
        if(storage[index] == null){
            storage[index]=new ArrayList<>();
            storage[index].add(key);
            return true;
        }

        for(int pos = 0; pos < storage[index].size(); pos++){
            //To avoid duplication
            if(storage[index].get(pos).equals(key)){
                return false;
            }
        }
        storage[index].add(key);
        return true;
    }

    public boolean remove(int key){
        int index = getHashedIndex(key);
        if(storage[index] == null){
            return false;
        }
        for(int pos = 0; pos < storage[index].size(); pos++){
            //To avoid duplication
            if(storage[index].get(pos).equals(key)){
                storage[index].remove(pos);
                if(storage[index].isEmpty()){
                    storage[index]=null;
                }
                return true;
            }
        }
        return false;
    }

    public boolean contains(int key) {
        return (getPosition(key) > -1);
    }

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        System.out.println(set.remove(2));//false
        System.out.println(set.contains(2));//false

        System.out.println(set.add(1));//true
        System.out.println(set.contains(1));//true
        System.out.println(set.add(2));//true
        System.out.println(set.contains(2));//true
        System.out.println(set.add(2));//false -- 2 already present shouldnt add duplicate
        System.out.println(set.contains(2));//true
        System.out.println(set.remove(2));//true
        System.out.println(set.contains(2));//false
        System.out.println(set.contains(1));//true

    }
}
