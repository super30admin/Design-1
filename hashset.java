class MyHashSet {

int buckets;
int bucketSize;
boolean[][] storage;
    public MyHashSet() {
        this.buckets = 1000;
        this.bucketSize = 1000;
        storage = new boolean[buckets][];
    }
    
    public int innerhash(int key){
return key/bucketSize;

    }
    public int outerhash(int key){
        return key % buckets;
    }
    //time complexity - O(1)
    public void add(int key) {
        int outerhash = outerhash(key);
        if(storage[outerhash] == null){
storage[outerhash] = new boolean[bucketSize];
        }
        int inner = innerhash(key);
        storage[outerhash][inner] = true;

    }
    //time complexity - O(1)
    public void remove(int key) {
        int outerhash = outerhash(key);
        if(storage[outerhash] != null){
            int inner = innerhash(key);
            storage[outerhash][inner] = false;
        }
    }
    //time complexity - O(1)
    public boolean contains(int key) {
        int outerhash = outerhash(key);
        if(storage[outerhash] == null){
            return false;
        }
        else{
            int inner = innerhash(key);
            return storage[outerhash][inner];
        }
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */