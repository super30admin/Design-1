//approach used is double hashing
//took two arrays one primary and one secondary
//imlemented hash functions to use in add, remove and contains methods with time complexity of O(1)
class MyHashSet {

    private boolean storage[][];
    private int buckets; //length of primary array
    private int bucketItems;// length of secondary array

    private int hash1(int key){
        return key%buckets;
    }

    private int hash2(int key){
        return key/bucketItems;
    }

    public MyHashSet() {
        this.buckets=1000;
        this.bucketItems=1000;
        this.storage=new boolean[buckets][];
    }
    
    public void add(int key) { //O(1)
        int bucket=hash1(key);
        if(storage[bucket]==null){
            if(bucket==0){
                storage[bucket]= new boolean[bucketItems+1];
            }
            else{
            storage[bucket]= new boolean[bucketItems];
            }
        }
        int bucketItem= hash2(key);
        storage[bucket][bucketItem]=true;
        
    }
    
    public void remove(int key) { //O(1)
        int bucket=hash1(key);
        if(storage[bucket]==null){
            return;
        }
        int bucketItem= hash2(key);
        storage[bucket][bucketItem]=false;
    }
    
    public boolean contains(int key) { //O(1)
        int bucket=hash1(key);
        int bucketItem= hash2(key);
        if(storage[bucket]==null) return false;
        return storage[bucket][bucketItem];

        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */