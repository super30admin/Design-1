class MyHashSet {
    boolean[][] storage;
    int buckets;
    int bucketItems;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
        
    }

    private int hash1(int key){
        return key%buckets;
    }

    private int hash2(int key){
        return key/bucketItems;
    }
    
    public void add(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(storage[hash1] == null){
            if(hash1 == 0){
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
        if(storage[hash1] == null) return;
        storage[hash1][hash2] = false;
    }
    
    public boolean contains(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);
        if(storage[hash1] == null) {
            return false;
        }
        return storage[hash1][hash2];
    }

    public static void main(String[] args){
        MyHashSet obj = new MyHashSet();
        obj.add(1);      // set = [1]
        obj.add(2);      // set = [1, 2]
        System.out.println(obj.contains(1)); // return True
        System.out.println(obj.contains(3)); // return False, (not found)
        obj.add(2);      // set = [1, 2]
        System.out.println(obj.contains(2)); // return True
        obj.remove(2);   // set = [1]
        System.out.println(obj.contains(2));  // return False, (already removed)
    }
}

