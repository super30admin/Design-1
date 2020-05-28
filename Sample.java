// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : creating the custome data structure design took some time
//time complexity is - O(n/k) 
// n - number of keys
//k - number of buckets
// space complexity - O(M+K) 
// M - unique keys // K - predefined buckets



// Your code here along with comments explaining your approach

class Pair<U,V> {
    public U first;
    public V second;
    
public Pair(U first, V second){
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
        for(Pair<Integer,Integer>pair: this.bucket){
            if(pair.first.equals(key))
                return pair.second;
        }
            return -1;
    }
    
    public void update(Integer key, Integer value){
        boolean found = false;
        for(Pair<Integer,Integer> pair : this.bucket){
            if(pair.first.equals(key)){
                pair.second = value;
                found = true;
            }
        }
        if(!found)
            this.bucket.add(new Pair<Integer,Integer>(key,value));
    }
    
    public void remove(Integer key){
        for(Pair<Integer,Integer>pair : this.bucket){
            if(pair.first.equals(key)){
                this.bucket.remove(pair);
                break;
            }
        }
    }
}

//create your own custom data structure
class MyHashMap {

    private int key_space;
    private List<Bucket> hash_table;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
    this.key_space = 2069;
        this.hash_table = new ArrayList<Bucket>();
        for(int i =0; i<this.key_space; ++i){
            this.hash_table.add(new Bucket());
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash_key = key % key_space;
        this.hash_table.get(hash_key).update(key,value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash_key = key % key_space;
        return this.hash_table.get(hash_key).get(key);
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash_key = key % this.key_space;
        this.hash_table.get(hash_key).remove(key);
    }
}

