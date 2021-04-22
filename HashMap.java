// Amortized Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// 1. Idea here is to store each and every element in the corresponding bucket that is associated to the given input key.
// 2. We create an initial array with all the buckets initialized.
// 3. Each index in the initial array corresponds to the hash that is computed for a given key.
// 4. When a new key value pair is asked to be inserted into the map, we add that to the corresponding bucket.
// 5. But when a key value pair with an existing key is asked to be added into the map, 
//    we find the existing pair in the corresponding bucket and then update its value
// 6. To remove a element we go to the corresponding bucket and remove the pair.
import java.util.*;

class Pair{
    public int key;
    public int value;
    
    Pair(int k, int v){
        this.key = k;
        this.value = v;
    }
}

class Bucket{
    List<Pair> list;
    
    Bucket(){
        list = new LinkedList<Pair>();
    }
    
    public void add(int key, int value){
        boolean added = false;
        Iterator<Pair> iterator = list.iterator();
        while(iterator.hasNext()){
            Pair ele = iterator.next();
            if (ele.key == key){
                ele.value = value;
                added = true;
            }
        }
        
        if(!added) list.add(new Pair(key, value));
    }
    
    public int get(int key){
        if(list.isEmpty()) return -1;
        Iterator<Pair> iterator = list.iterator();
        while(iterator.hasNext()){
            Pair element = iterator.next();
            if (element.key == key){
                return element.value;
            }
        }
        return -1;
    }
    
    public void remove(int key){
        
        Iterator<Pair> iterator = list.iterator();
        while(iterator.hasNext()){
            Pair element = iterator.next();
            if (element.key == key){
                iterator.remove();
                break;
            }
        }
    }
}

class MyHashMap {
    
    int mod = 2069;
    List<Bucket> table;

    /** Initialize your data structure here. */
    public MyHashMap() {
        table = new ArrayList<>();
        for(int i = 0; i < mod; i++){
            table.add(new Bucket());
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash = key % this.mod;
        table.get(hash).add(key, value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = key % this.mod;
        return table.get(hash).get(key);
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash = key % this.mod;
        table.get(hash).remove(key);
    }

    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        obj.put(5, 2);
        obj.put(2, 1);
        obj.put(9, 11);
        obj.put(2, 7);
        int param_1 = obj.get(9);
        int param_2 = obj.get(2);
        obj.remove(5);
        System.out.println(param_1);
        System.out.println(param_2);
    }
}