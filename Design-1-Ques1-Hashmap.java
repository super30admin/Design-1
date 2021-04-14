// ## Problem 1:
//Design Hashmap (https://leetcode.com/problems/design-hashmap/)


// Time Complexity : Worst case scenarios:-
// To put a key,value - O(N)
// To get a key,value - O(N)
// To remove a key,value - O(N)
// Space Complexity : - O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : A little may be

// I have an ArrayList of objects of Bucket called hmap. 
// Each element of hmap is an object of type bucket that has an Arraylist of Pairs associated with it.
// Each pair is an object of class Pair, which has a key, and a value.
// An index in the ArrayList of hmap that is associated with each bucket is computed using a modulous operaator.
// I have used "2069" as the prime number for generating the index for the hmap.
// To update a key,value pair I first check if that key,value pair is present in the ArrayList
// associated with that bucket or not.
// If it it present then update to the new value.
// Else insert the new key,value pair in that ArrayList of the bucket.

// Your code here along with comments explaining your approach
class Pair{
    int u;
    int v;
    public Pair(int u, int v)
    {
        this.u = u;
        this.v = v;
    }
}

class Bucket{
    ArrayList<Pair> bucket;
    
    public Bucket(){
        bucket = new ArrayList<Pair>();
    }
    
    // this fucntion tells if the key is present or not.
    public int get(int key){
        for(Pair p:bucket){
            if(p.u == key)
                return p.v;
        }
        return -1; // Key is not present
    }
    
    public void update(int key,int value){
        int present = get(key);
        if(present==-1){
            bucket.add(new Pair(key,value));
        }
        else{
           for(Pair p:bucket)
           {
               if(p.u == key){
                   p.v = value;
               }
           }
        }
    }
    
    public void remove(int key){
        for(Pair p:bucket){
                if(p.u == (key)){
                    bucket.remove(p);
                    break;
                }
            }
        }
}


class MyHashMap {
    
    int key_size;
    ArrayList<Bucket> hmap;
    /** Initialize your data structure here. */
    public MyHashMap() {
        key_size = 2069;
        hmap = new ArrayList<Bucket>();
        for(int i=0;i<key_size;i++)
        {
            hmap.add(new Bucket());
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hash_key = key%key_size;
        hmap.get(hash_key).update(key,value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash_key = key%key_size;
        return hmap.get(hash_key).get(key);
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hash_key = key%key_size;
        if(hmap.get(hash_key).get(key)!=-1){
            hmap.get(hash_key).remove(key);
        }
    }
}
