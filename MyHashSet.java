// Time Complexity : O(1)
// Space Complexity : O(1)

public class MyHashSet {
	
	boolean[][] arr;
	int buckets;
	int bucketCapacity;

    public MyHashSet() {
    	
    	buckets = 1000;
    	bucketCapacity = 1000;
    	arr = new boolean[buckets][];
        
    }
    
	public void add(int key) {

		int bucket = getBucket(key);
		int bucketItem = getBucketItem(key);

		if (arr[bucket] == null) {
			if (bucket == 0) {
				arr[bucket] = new boolean[bucketCapacity + 1];
			} else {
				arr[bucket] = new boolean[bucketCapacity];
			}
		}
		
		arr[bucket][bucketItem] = true;		

	}
    
    private int getBucketItem(int key) {
		// TODO Auto-generated method stub
		return key % buckets;
	}

	private int getBucket(int key) {
		// TODO Auto-generated method stub
		return key / bucketCapacity;
	}

	public void remove(int key) {
		

		int bucket = getBucket(key);
		int bucketItem = getBucketItem(key);
		
		if(arr[bucket] == null)
			return;
		 
		if(arr[bucket][bucketItem])
			arr[bucket][bucketItem]=false;	
		        
    }
    
    public boolean contains(int key) {
        
		int bucket = getBucket(key);
		int bucketItem = getBucketItem(key);
		
		if(arr[bucket] == null)
			return false;
		 
		if(arr[bucket][bucketItem])
			return true;
		
		return false;
    }
     
    public static void main(String[] args) {
    	
    	 MyHashSet obj = new MyHashSet();
    	 int key = 12;
    	 obj.add(key);
    	 
    	 boolean param_3 = obj.contains(key);
    	 System.out.println(param_3);
    	 
    	 obj.remove(key);
    	 
    	 boolean param_2 = obj.contains(key);
    	 System.out.println(param_2);
    	 
	}
}