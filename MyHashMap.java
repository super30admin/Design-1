import java.util.*;

class Pair<x,y>{
    public x first;
    public y second;
    
    public Pair(x first, y second){
        this.first = first;
        this.second = second;
    }
}
class Bucket{
    private List<Pair<Integer, Integer>> bucket;
    
    public Bucket(){
        this.bucket = new LinkedList<Pair<Integer, Integer>>();
    }
    
    public Integer get(Integer key){
        for(Pair<Integer, Integer> pair : this.bucket){
            if(pair.first.equals(key)){
                return pair.second;
            }
        }
        return -1;
    }
    
    public void update(Integer key, Integer value){
        boolean found = false;
        for(Pair<Integer, Integer> pair : this.bucket){
            if(pair.first.equals(key)){
                pair.second = value;
                found = true;
                System.out.println("The value" + pair.second);
            }
        }
        if(!found){
            this.bucket.add(new Pair<Integer,Integer>(key,value));
        }
    }
    
    public void remove(Integer key){
        for(Pair<Integer, Integer> pair : this.bucket){
            if(pair.first.equals(key)){
                this.bucket.remove(pair);
                break;
             }
        }
    }
}

class MyHashMap {
    private int space;
    private List<Bucket> hash_map;
    /** Initialize your data structure here. */
    
    public MyHashMap() {
        this.space = 1000;    
        this.hash_map = new ArrayList<Bucket>();
        for(int i = 0; i < this.space; i++){
            this.hash_map.add(new Bucket());
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash_key = key % this.space;
        this.hash_map.get(hash_key).update(key,value);          
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
    
        int hash_key = key % this.space;
        return this.hash_map.get(hash_key).get(key);
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash_key = key % this.space;
        this.hash_map.get(hash_key).remove(key);
    }


    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 2);          
        hashMap.put(2, 3);         
        hashMap.get(1);            // returns 2
        hashMap.get(3);            // returns -1 (not found)
        hashMap.put(2, 4);          // update the existing value
        hashMap.get(2);            // returns 4
        hashMap.remove(2);          // remove the mapping for 2
        hashMap.get(2);            // returns -1 (not found)
    }
}