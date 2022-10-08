// Time Complexity: O(1) for all 3 functions
// Space Complexity: O(1) 
class MyHashSet {
    
        int buckets;
        int bucketItems;
        boolean storage[][];
    
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }
    
    private int hash1(int key) {
        return key%buckets;
    }
    private int hash2(int key) {
        return key/bucketItems;
    }
    
    public void add(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);

        if (storage[hash1] == null){
           if(hash1 == 0){
               storage[hash1] = new boolean[bucketItems+1];
           }
            else{
                storage[hash1] = new boolean[bucketItems];
            }
        }
        storage[hash1][hash2] = true;
    }
    
    
    public void remove(int key) {
        int hash1 = hash1(key);

        if (storage[hash1] != null)
        {
            int hash2 = hash2(key);
            storage[hash1][hash2] = false;
        } else{
            return;
        }
    }
    
    public boolean contains(int key) {
        int hash1 = hash1(key);
        if (storage[hash1] == null){
            return false;
        }
        else{
            int hash2 = hash2(key);
            return storage[hash1][hash2];
        }
    }

    public static void main(String args[]) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1); //[1]
        myHashSet.add(2); //[1,2]
        myHashSet.contains(1); //True
        myHashSet.contains(3); //False
        myHashSet.add(2); //[1,2]
        myHashSet.contains(2); //True 
        myHashSet.remove(2); //[1]
        myHashSet.contains(2); //False
    }
}