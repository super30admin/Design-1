// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes


public class MyHashSet {
	
		int MAX = 1000000;
		
		int bucketSize;
		int innerBucketSize;
		
		boolean[][] storage;
	
		
		public MyHashSet() {
			this.bucketSize = (int) Math.sqrt(MAX);
			this.innerBucketSize = MAX/bucketSize;
			this.storage = new boolean[bucketSize][];
		}
		
		public int hashIndexForBucket(int key)
		{
			return key%1000;
		}
		
		public int hashIndexForInnerBucket(int key)
		{
			return key/1000;
		}
	    
	    public void add(int key) {
	    	int bucketIndex = hashIndexForBucket(key);
	    	int innerBucketIndex = hashIndexForInnerBucket(key);
	    	if(storage[bucketIndex] == null)
	    	{
	    		if(bucketIndex == 0)
	    		{
	    			storage[bucketIndex] = new boolean[innerBucketSize+1];
	    		}else {
	    		storage[bucketIndex] = new boolean[innerBucketSize];
	    		}
	    	}
	    	storage[bucketIndex][innerBucketIndex] = true;
	    }
	    
	    public void remove(int key) {
	    	int bucketIndex = hashIndexForBucket(key);
	    	int innerBucketIndex = hashIndexForInnerBucket(key);
	    	if(storage[bucketIndex] != null)
	    	{
	    		storage[bucketIndex][innerBucketIndex] = false;
	    	}
	    }
	    
	    public boolean contains(int key) {
	    	int bucketIndex = hashIndexForBucket(key);
	    	int innerBucketIndex = hashIndexForInnerBucket(key);
	    	if(storage[bucketIndex] != null)
	    	{
	    		return storage[bucketIndex][innerBucketIndex];
	    	}
	    	return false;
	        
	    }
	
	    public static void main(String args[])
	    {
	    	
	    }

}
