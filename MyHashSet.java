package design1;
//time complexity: O(1)
//space complexity: O(n)
public class MyHashSet {
	int buckets;
	int bucketItems;
	boolean array[][];
	
    public MyHashSet() {
    	buckets = 1000;
        bucketItems = 1000;
    	array = new boolean[buckets][];
    }
    
    public int getBucket(int key) {
    	 return key % buckets;
    }
    
   public int getBucketItem(int key) {
	   return key / buckets;
    }
    
    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);     
        if(array[bucket] == null)
        {
            if(bucket == 0) {
            	array[bucket] = new boolean[bucketItems + 1];
            }  	
            else {
            	array[bucket] = new boolean[bucketItems];
            } 	
            array[bucket][bucketItem] = true;
        }
        else {
        	array[bucket][bucketItem] = true;
        }	
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(array[bucket] == null) {
        	 return;
        }
        array[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(array[bucket] == null) {
            return false;
        }
        return array[bucket][bucketItem];
    }
    
    public static void main(String args[]) {
    	 MyHashSet hashset = new MyHashSet();
    	 hashset.add(1);
    	 hashset.add(5);
    	 hashset.remove(1);
    	 System.out.println(hashset.contains(5));
    	 System.out.println(hashset.contains(1));
    	
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

