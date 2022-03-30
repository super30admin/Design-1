// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach : Using 2D matrix 1000x100 and two hash functions. 


class MyHashSet {

    boolean hashset[][];
    int buckets = 1000;
    int bucketItems = 1000;
    
    
    public MyHashSet() {
        hashset = new boolean[buckets][];
        
    }
    
   int hash1(int key){
        return key % buckets;
    }
    
    int hash2(int key){
        return key / bucketItems;
    }
    
    public void add(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        
        if(hashset[bucket] == null){
            if(bucket == 0){
                hashset[bucket] = new boolean[bucketItems+1];
            }else{
               hashset[bucket] = new boolean[bucketItems]; 
            }
            
        }
        
        hashset[bucket][bucketItem] = true;
        
    }
    
    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        
        if(hashset[bucket] == null){
            return;
        }
        
        hashset[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        
        if(hashset[bucket] == null){
            return false;
        }
        
        return hashset[bucket][bucketItem];
    }

public static void main(String[] args){
    MyHashSet obj = new MyHashSet();
    obj.add(1000);
    obj.remove(2);
    System.out.print(obj.contains(1000));

}

}
