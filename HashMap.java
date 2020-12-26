// Time Complexity : O(1), O(n) to initialize
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Tried implementing it with linked list but found array to be easier with little difference in runtime



public class HashMap {

	//use an array since we are able to get an element in O(1) runtime
	private int [][] storage;
	private int buckets;
	private int bucketItems;
	/** Initialize your data structure here. */
	 /** Initialize your data structure here. */




    public HashMap() {
    	//Since there is only 0 to 1000000 elements, no need for resize method
        buckets = 1000;
        bucketItems = 1001;
        storage = new int[buckets][];
        
        //since we are dealing with integers, index can be used as key

    }
    
    //O(1) run time
    /** value will always be non-negative. */
    public void put(int key, int value) {
    	//get location of key-value pair
        int bucket = key % buckets;
        int bucketItem = key / bucketItems;
        if(storage[bucket] == null){
            storage[bucket] = new int [bucketItems];
        }
        storage[bucket][bucketItem] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucket = key % buckets;
        int bucketItem = key / bucketItems;
        if(storage[bucket] == null){
            return -1;
        }
        return storage[bucket][bucketItem];
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucket = key % buckets;
        int bucketItem = key / bucketItems;
        if(storage[bucket] == null){
            return;
        }
        storage[bucket][bucketItem] = -1;

        
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test");
	}

}
