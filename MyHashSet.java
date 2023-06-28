/*
 * Time Complexity:
 * add, remove, contains - O(1)
 * Space Complexity: O(N) for storing elements in the 2D array
 * successfully ran this on leetcode
 * Used Double hashing technique to construct space efficient and time efficienct hash set 
 */


public class MyHashSet {
    boolean[][] storage;
    int buckets;
    int bucketItems;
    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[this.buckets][];
    }

    private int hashOne(int key){
        return key%1000;
    }

    private int hashTwo(int key){
        return key/1000;
    }
    
    public void add(int key) {
        int bucket = hashOne(key);
        int bucketItem = hashTwo(key);
        if(storage[bucket] == null){
            if(bucket == 0){
                storage[bucket] = new boolean[this.bucketItems + 1];
            }
            else {
                storage[bucket] = new boolean[this.bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = hashOne(key);
        int bucketItems = hashTwo(key);
        if(storage[bucket] == null) return;
        storage[bucket][bucketItems] = false;
    }
    
    public boolean contains(int key) {
        int bucket = hashOne(key);
        int bucketItems = hashTwo(key);
        if(storage[bucket] == null) return false;
        return storage[bucket][bucketItems]; 
    }

    public static void main(String[] args){
        MyHashSet obj = new MyHashSet();
        int key = 10;
        obj.add(key);
        System.out.println(obj.contains(key));
        obj.remove(key);     
        System.out.println(obj.contains(key));   
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */