public class MyHashSet {
	    
    private int bucket;
    private int bucketItems;
    private boolean [][] hashSet;

    public MyHashSet() {
        
        this.bucket = 1000;
        this.bucketItems = 1000;
        hashSet = new boolean[bucket][];
        
    }
    
    private int bucketHashFunction (int key) {
        return key % bucket;
    }
    
    private int bucketItemsHashFunction (int key) {
        return key/bucketItems;
    }
    
    public void add(int key) {
        
        int bucket = bucketHashFunction(key);
        int bucketItems = bucketItemsHashFunction(key);
        
        if (hashSet[bucket] == null) {
            
            if (bucket == 0) {
                
                hashSet [bucket] = new boolean [bucketItems + 1];
                
            } else {
                
                hashSet[bucket] = new boolean [bucketItems];
                
            }
                         
        }
        
        hashSet[bucket][bucketItems] = true;
        
    }
    
    public void remove(int key) {
        
        int bucket = bucketHashFunction(key);
        int bucketItems = bucketItemsHashFunction(key);
        
        if (hashSet[bucket] == null) return;
        hashSet[bucket][bucketItems] = false;
        
    }
    
    public boolean contains(int key) {
        
        int bucket = bucketHashFunction(key);
        int bucketItems = bucketItemsHashFunction(key);
        
        if (hashSet[bucket] == null) return false;
        return hashSet [bucket][bucketItems];
        
    }
    
    
    public static void main (String [] args) {
        
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(1); // return True
        myHashSet.contains(3); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(2); // return True
        myHashSet.remove(2);   // set = [1]
        myHashSet.contains(2); // return False, (already removed)
        
    }
    
} 
