package leetCode;

class MyHashSet {
    private int bucketSize;
    private int bucketItemSize;
    private boolean [][] storage;
    public MyHashSet() {
        this.bucketSize = 1000;
        this.bucketItemSize = 1000;
        this.storage = new boolean [1000][];
    }
    
    private int hashF1(int key)	{
    	return key%bucketSize;
    }
    private int hashF2(int key)	{
    	return key/bucketItemSize;
    }
    
    public void add(int key) {
        int hash1 = hashF1(key);
        int hash2 = hashF2(key);
        
        if(storage[hash1] == null) {
        	//ie no nested array, hence create it
        	//edge Case: handle last element which falls in bucket 0
        	if(hash1 == 0)	{
        		storage[hash1] = new boolean [bucketItemSize+1]; 
        	}
        	else	{
        		storage[hash1] = new boolean [bucketItemSize]; 
        	}
        	
        }
        else	{
        	//which means the secondary array already exists
        		storage[hash1][hash2] = true;
        		}
    }
    
    public void remove(int key) {
    	int hash1 = hashF1(key);
        int hash2 = hashF2(key);
        
        if(storage[hash1] != null) {
        	storage[hash1][hash2] = false;
        }
    }
    
    public boolean contains(int key) {
    	int hash1 = hashF1(key);
        int hash2 = hashF2(key);
        if(storage[hash1] == null) return false;
        return storage[hash1][hash2];
    	
    }
    
    public static void main(String[] args) {
		
    	MyHashSet obj = new MyHashSet();
    	obj.add(999);
    	obj.remove(400);
    	System.out.println(obj.contains(999));
    	
	}
}

 
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */