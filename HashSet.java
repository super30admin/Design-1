// Time Complexity : add() => O(1); remove() => O(1); contains() => O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {
    
    private boolean[][] bucketArray;
    private int bucketSize = 1000;
    private int bucketItemSize = 1000;

    public MyHashSet() {
        this.bucketArray = new boolean[this.bucketSize][];
    }
    
    private int hashFunction(int key){
        return (key % this.bucketSize);
    }

    private int secondHashFunction(int key){
        return (key / this.bucketItemSize);
    }
    
    public void add(int key) {
        int bucket = this.hashFunction(key);
        int bucketItem = this.secondHashFunction(key);

        if(bucketArray[bucket] == null){
            if(bucket == 0){
                bucketArray[bucket] = new boolean[this.bucketItemSize + 1]; // to accomodate bucketItem at 1000 and its multiple.
            }
            else{
                bucketArray[bucket] = new boolean[this.bucketItemSize];
            }
        }
        this.bucketArray[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket = this.hashFunction(key);
        int bucketItem = this.secondHashFunction(key);

        if(bucketArray[bucket] == null){
            return;
        }
        this.bucketArray[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket = this.hashFunction(key);
        int bucketItem = this.secondHashFunction(key);

        if(bucketArray[bucket] == null){
            return false;
        }
        return this.bucketArray[bucket][bucketItem];
    }
}