//design-1 Hashset
//LC 705

//As discussed in the lecture I shall be using double hashing technique to avoid collisions
//For 1M items, we picked the primary array of size 1000 items and secondary arrays of 1000 items
//First hashing function: key%1000 - to spread the data evenly
//Second hashing function: key/1000 - to avoid nested collisions
//Shall be storing TRUE / FALSE instead of values 

class MyHashSet {
    
    private boolean[][] storage;
    int buckets;
    int bucketitems;
    
    public MyHashSet() {
        buckets = 1000;
        bucketitems = 1000;
        storage = new boolean[buckets][];
    }
    //Functions to return hashing index
    private int hash1(int key){
        return key%1000;
    }
    private int hash2(int key){
        return key/1000;
    }
    
    public void add(int key) {
        int bucketlocation = hash1(key);
        int bucketnum = hash2(key);
        //First check if there exists a secondary array at that index
        if (storage[bucketlocation]==null){
            if (bucketlocation==0){
            storage[bucketlocation]= new boolean[1000+1];
            }
            else{
            storage[bucketlocation]= new boolean[1000];
            }  
        }
        //Once an array is created at that bucketlocation, we save that position as true
        storage[bucketlocation][bucketnum]= true; 
    }
    
    public void remove(int key) {
        //For remove, we will again check if there exists a secondary array at that bucket location, if found, we will look for the correct bucket to change it to false
        int bucketlocation = hash1(key);
        int bucketnum = hash2(key); 
        if (storage[bucketlocation]==null) return;
        if (storage[bucketlocation][bucketnum]==false) 
            return;
        else 
            storage[bucketlocation][bucketnum]= false; 
    }
    
    public boolean contains(int key) {
        int bucketlocation = hash1(key);
        int bucketnum = hash2(key);
        if (storage[bucketlocation]== null) return false;
        return storage[bucketlocation][bucketnum];     
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */