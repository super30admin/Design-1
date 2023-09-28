// Time Complexity : add--> O(1), remove --> O(1), contains--> O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach


// created class with required data members and hash function for the main and nested bucket

 public class MyHashSet {
 private boolean [][] storage; 
 private int buckets;
 private int bucketItems;

 private int hash1(int key) {
     return key%buckets;
}

 private int hash2(int key) {
     return key/bucketItems;
}

public MyHashSet() {

    this.buckets = 1000;
    this.bucketItems = 1000;
    this.storage = new boolean[1000][];
        
  }
  // created add method which will check if the primary bucket has a value and if not it will create a nested boolean array at that index and add the vlaue using hash2 function
  //check the offset , if it is 0 create an additonal bucket items to deal with edge case of 1000000 being added.  
public void add(int key) {
    int bucket = hash1(key);
    if(storage[bucket] == null){
    if(bucket == 0){
        storage[bucket] = new boolean[bucketItems + 1];
    } else {

        storage[bucket] = new boolean[bucketItems];
    }
}

    int bucketItem = hash2(key);
    storage[bucket][bucketItem]= true;
        
    }

    // if the value is not present in primary bucket it will just return, if not it will go for nested bucketitems turn the value to false
    
public  void remove(int key) {

    int bucket = hash1(key);
    if(storage[bucket] == null) return;
    int bucketItem = hash2(key);
    storage[bucket][bucketItem]= false;

}

//if the value in offset location is not present in primary bucket it returns false, or else it will return the condition in that nested bucket
    
 public boolean contains(int key) {

     int bucket = hash1(key);

     if(storage[bucket] == null) return false;

     int bucketItem = hash2(key);

     return storage[bucket][bucketItem];
 }

};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
