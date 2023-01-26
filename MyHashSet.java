//Space complexity: O(n);
//Time complexity : O(1)

/**
 * Created an array called storage with primary and secondary indexes hash1 and hash2, 
 * to add, we simply get the position in storage from has1 and hash2 and we simply return true 
 * to remove we again return false in the storage[hash1][hash2] position
 * to check if it contains any value, return the boolean value at storage[hash1][hash2]
 */

 class MyHashSet {

    boolean[][] storage;
    int buckets;
    int bucketItems;
    public static void main(String args[]) {

        MyHashSet obj = new MyHashSet();
        obj.add(10);
        obj.add(20);
        obj.remove(10);
        boolean contains = obj.contains(10);
    }

    public MyHashSet(){
        this.buckets = 1000;
        this.bucketItems  =1000;
        this.storage = new boolean[buckets][];
    }

    private int hash1(int key){
        return buckets%1000;
    }

    private int hash2(int key){
        return bucketItems / 1000;
    }

    public void add(int key){
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(storage[hash1] == null){
            if(hash1 == 0) {
                storage[hash1] = new boolean[bucketItems+1];
            } else {
                storage[hash1] = new boolean[bucketItems];
            }
        }
        storage[hash1][hash2] = true;
    }

    public void remove(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(storage[hash1] == null) 
        return;
         storage[hash1][hash2] = false;
         System.out.println("removed" + key);
    }

    public boolean contains(int key) {
        int hash1 = hash1(key);
        int hash2  = hash2(key);
        if(storage[hash1] == null){
            return false;
        }
        return storage[hash1][hash2];
    }

}

