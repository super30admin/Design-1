/*
Time Complexity: O(K) where k is the max bucket size. In the worst case scenarion K could also be N.
Space Complexity: O(N) to store all the values.

Did this code successfully run on Leetcode : Yes
Difficulties: Hash to come up with an effective hash function and also handle the collection in the map by using an LinkedList to store multiple values for that hash key.

*/


class MyHashMap {

    /** Initialize your data structure here. */
    Bucket map[];
    int hash=2069;
    public MyHashMap() {
        this.map = new Bucket[this.hash];
        for(int i=0;i<map.length;i++){
            map[i]=new Bucket();
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashKey = key%this.hash;
        Bucket bucket = this.map[hashKey];
        bucket.put(key, value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashKey = key%this.hash;
        Bucket bucket = this.map[hashKey];
        return bucket.get(key);
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashKey = key%this.hash;
        Bucket bucket = this.map[hashKey];
        bucket.remove(key);
    }
}

class Pair<U,V>{
    U key;
    V value;
    public Pair(U key, V value){
        this.key = key;
        this.value = value;
    }
}
class Bucket{
    List<Pair<Integer, Integer>> bucket;
    public Bucket(){
        this.bucket = new LinkedList<>();
    }
    public void put(Integer key, Integer value){
        for(int i=0;i<this.bucket.size();i++){
            Pair pair = bucket.get(i);
            if(pair.key.equals(key)){
                pair.value= value;
                return;
            }
        }
        this.bucket.add(new Pair(key, value));
    }
    
    public int get(Integer key){
        for(int i=0;i<this.bucket.size();i++){
            Pair pair = bucket.get(i);
            if(pair.key.equals(key)){
                return (int)pair.value;
            }
        }
        return -1;
    }
    
    public void remove(Integer key){
        for(int i=0;i<this.bucket.size();i++){
            Pair pair = bucket.get(i);
            if(pair.key.equals(key)){
                this.bucket.remove(pair);
                break;
            }
        }
    }
    
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */