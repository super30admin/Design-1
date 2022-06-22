//Time Complexity: O(1)
//Space Complexity: O(B+N), where B is the no. of buckets and N is the no. of values inserted into Hashset.
// Solution accepted and submitted on LeetCode.

class MyHashSet {
	
	boolean[][] storage;
	int bucket;
	int bucketItems;

    public MyHashSet() {
    	bucket = 1000;
    	bucketItems = 1000;
        storage = new boolean[bucket][];
    }
    
    public int getBucket(int key) {
    	return key % bucket;
    }
    
    public int getBucketItems(int key) {
    	return key / bucketItems;
    }
    public void add(int key) {
    	
    	int b = getBucket(key);
    	int c = getBucketItems(key);
    	
    	if(storage[b] == null) {
    		
    		if(b == 0) {
    			storage[b] = new boolean[bucketItems+1];
    		}
    		else
    			storage[b] = new boolean[bucketItems];
    	}
    	
    	storage[b][c] = true;
        
    }
    
    public void remove(int key) {
    	
    	int b = getBucket(key);
    	int c = getBucketItems(key);
    	
    	if(storage[b] == null)
    		return;
    	
    	storage[b][c] = false;
        
    }
    
    public boolean contains(int key) {
    	
    	int b = getBucket(key);
    	int c = getBucketItems(key);
    	
    	if(storage[b] == null)
    		return false;
    	
    	return storage[b][c];
    }
}

