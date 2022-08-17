/*******
Problem 1:(https://leetcode.com/problems/design-hashset/)

Time Complexity :   O (1) 
Space Complexity :  O(n) 
Did this code successfully run on Leetcode :    Yes (705. Design HashSet)
Any problem you faced while coding this :       No
*******/

class MyHashSet {
    boolean[][] storage;
    int bucket;
    int bucketItems;

    public MyHashSet() {
        this.bucket = 1000;
        this.bucketItems = 1000; 
        this.storage = new boolean[bucket][];
    }
    
    // calculate the hash1
    private int getHash1(int key){
        return (key % bucket);
    }

    // calculate the hash1
    private int getHash2(int key){
        return (key / bucketItems);
    }
    
    // // Insert a value into the HashSet. 
    public void add(int key) { //   O(1)
        int hash1 = getHash1(key);
        int hash2 = getHash2(key);
        
        // if hash1 is null (elements are not present), then create new boolean array for hash1
        if( storage[hash1] == null){
            if (hash1 == 0){
                // for hash1 == 0, need extra space to store 0 hash values
                storage[hash1] = new boolean[bucketItems + 1];
            }
            else {
                storage[hash1] = new boolean[bucketItems];
            }
        }
        // set storage[hash1][hash2] as true (element is stored)
        storage[hash1][hash2] = true;
        System.out.println("Added "+ key + " at index: " + hash1 +","+hash2);
    }
    
    // // Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
    public void remove(int key) {   //   O(1)
        int hash1 = getHash1(key);
        int hash2 = getHash2(key);
        
        // if storage[hash1] == null, means element is not present
        if( storage[hash1] == null){
            return;
        }
        // set storage[hash1][hash2] as false (element is removed)
        storage[hash1][hash2] = false;
        System.out.println("Removed "+ key + " from index: " + hash1 +","+hash2);
    }
    
    // // Return whether the value exists in the HashSet or not.
    public boolean contains(int key) {    //   O(1)
        int hash1 = getHash1(key);
        int hash2 = getHash2(key);
        
        if( storage[hash1] == null){
            System.out.println(key + " is NOT present in HashSet");
            return false;
        }
        // return storage[hash1][hash2] as true/false
        return storage[hash1][hash2];
    }

    // Driver method to test above 
    public static void main(String args[]) 
    { 
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);         
        hashSet.add(2);         
        hashSet.contains(1);    // returns true
        hashSet.contains(3);    // returns false (not found)
        hashSet.add(2);          
        hashSet.contains(2);    // returns true
        hashSet.remove(2);          
        hashSet.contains(2);    // returns false (already removed)
    } 
}
