// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class MyHashSet {
    boolean[][] storage;
    int buckets;
    int  items;

    public MyHashSet() {
        this.buckets = 1000;
        this.items = 1000;
        this.storage = new boolean[buckets][];
        
    }

    public int hash1(int key){ //o(1)
         return key%1000; //constant operation
    }

    public int hash2(int key){ //o(1)
         return key/1000; //constant operation
    }
    
    public void add(int key) { o(1)
        int bucket = hash1(key);
        int bucketitem = hash2(key);
        if(storage[bucket] == null){
            if(bucket == 0){
                storage[bucket] = new boolean[items+1];
            }
            else{
                storage[bucket] = new boolean[items];
            }
        }
        storage[bucket][bucketitem] = true;
    }
    
    public void remove(int key) { o(1)
        int bucket = hash1(key);
        int items = hash2(key);
        if(storage[bucket]==null){
            return;
        }
        else{
            storage[bucket][items] = false;
        }
        
    }
    
    public boolean contains(int key) { o(1)
        int bucket = hash1(key);
        int bucketitem = hash2(key);
        if(storage[bucket]==null){
            return false;
        }
        else{
            return storage[bucket][bucketitem];
        }
    }
}

// Your code here along with comments explaining your approach
