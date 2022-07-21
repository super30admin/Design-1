// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO

class MyHashSet {
    boolean [][]storage;
    int buckets;
    int bucketitems;
public int hash1(int key){
    return key%buckets;
    }
public int hash2(int key){
    return key%bucketitems;
    }
public MyHashSet() {
    this.buckets=1000;
    this.bucketitems=1000;
   this.storage=new boolean[buckets][];
    
}

public void add(int key) {
    int hash1=hash1(key);
    int hash2=hash2(key);
    if(storage[hash1]== null){
        if(hash1==0)
            storage[hash1]=new boolean[bucketitems+1];
        else
            storage[hash1]=new boolean[bucketitems];
    }
    
    storage[hash1][hash2]=true;
}

public void remove(int key) {
    int hash1=hash1(key);
    int hash2=hash2(key);        
    if(storage[hash1]==null) return;
        storage[hash1][hash2]=false;
    
        
    
}

public boolean contains(int key) {
    int hash1=hash1(key);
    int hash2=hash2(key);  
    if(storage[hash1]==null)
        return false;
    return storage[hash1][hash2];
}
}

/**
* Your MyHashSet object will be instantiated and called as such:
* MyHashSet obj = new MyHashSet();
* obj.add(key);
* obj.remove(key);
* boolean param_3 = obj.contains(key);
*/