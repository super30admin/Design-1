// Time Complexity : 0(1)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach




class MyHashSet {

    private final int SIZE = 1000;
    private int[][] storage;
    public MyHashSet() {
        storage = new int[SIZE][];
    }
    
    // Returns index for outer array
    private int hash1(int key){
        return key % SIZE;
    }
    // Returns index for inner array
    private int hash2(int key){
        return key / SIZE;
    }
    public void add(int key) {
        int h1 = hash1(key);
        int h2 = hash2(key);

        if(storage[h1] == null){
            int size ;
            if(h1 == 0){
                size = SIZE + 1;
            }else{
                size = SIZE;
            }

            storage[h1] = new int[size];

            //Initialize all slots with -1
            for(int i = 0; i < size; i++){
                storage[h1][i] = -1;
            }
        }
        storage[h1][h2] = key;
    }
    
    public void remove(int key) {
        int h1 = hash1(key);
        int h2 = hash2(key);

        if( storage[h1] != null){

            // Mark the positon as empty using -1
            storage[h1][h2] = -1;
        }
        
    }
    
    public boolean contains(int key) {
        int h1 = hash1(key);
        int h2 = hash2(key);

        // Key is considered present ifthe bucket exists and the stored value matches the key
        return storage[h1] != null && storage[h1][h2] == key;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */