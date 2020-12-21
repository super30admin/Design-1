// Time Complexity : Not sure how to compute.
// Space Complexity : O(B+K) , where B is the number of predefined buckets, and K is the number of unique keys
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, I first did it with an integer size 1,000,001. However, that would not scale with larger inputs. Thus, I resorted to using a super simple hash function. 
//Storing key value pair with a new class called Pair with fields key and val. Also, to fix collisions, we defined a bucket, which is just an array list attached to each index in the hash map. 


// Your code here along with comments explaining your approach




class Pair{
    int key;
    int val;

    Pair(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class Bucket {
    List<Pair> bucket = new ArrayList<Pair>();

    public Integer get(Integer key){
        for(Pair pair: bucket){
            if(pair.key == key){
                return pair.val;
            }
        }
        return -1;
    }
    public void update(Integer key, Integer val){
        boolean found = false;
        for(Pair pair: bucket){
            if(pair.key == key){
                pair.val = val;
                found = true;
            }
        }
        if(found == false){
            bucket.add(new Pair(key,val));
        }
    }

    public void remove(Integer key){
        int removeIndex = -1;
        for(int i = 0; i < bucket.size(); i++){
            Pair currPair = bucket.get(i);
            if(currPair.key == key){
                removeIndex = i;
            }
        } 
        if(removeIndex != -1){
            bucket.remove(removeIndex);
        }
    }
}



class MyHashMap {    
    
    private Bucket[] map = new Bucket[2069];

    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key % 2069;
        if(this.map[index] == null){
            this.map[index] = new Bucket();
            this.map[index].bucket = new ArrayList<Pair>();   
        }
        this.map[index].update(key,value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % 2069;
        if(this.map[index] == null){
            return -1;
        }else{
            int val = this.map[index].get(key);
            return val;
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key % 2069;
        if(this.map[index] != null){
            this.map[index].remove(key);
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