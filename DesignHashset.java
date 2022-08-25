class MyHashSet {
    boolean[][] storage;
    int bucket;
    int bucketItems;
    public MyHashSet() {
        this.bucket=1000;
        this.bucketItems=1000;
        this.storage= new boolean[bucket][];
    }

    private int hashFunction1(int key){
        return key%bucket;
    }

    private int hashFunction2(int key){
        return key/bucketItems;
    }

    public void add(int key) {
        int hash1=hashFunction1(key);
        int hash2 = hashFunction2(key);
        if(storage[hash1] == null){
            if(hash1 == 0){
                storage[hash1] = new boolean[bucketItems+1];
            }
            else{
                storage[hash1] = new boolean[bucketItems];
            }
        }

        storage[hash1][hash2]=true;
    }

    public void remove(int key) {
        int hash1=hashFunction1(key);
        int hash2 = hashFunction2(key);

        if(storage[hash1]== null){
            return;
        }
        storage[hash1][hash2]=false;
    }

    public boolean contains(int key) {
        int hash1=hashFunction1(key);
        int hash2 = hashFunction2(key);
        if(storage[hash1]==null) return false;
        return storage[hash1][hash2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);f
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */