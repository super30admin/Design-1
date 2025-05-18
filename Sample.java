// Time Complexity :O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
//HASH SET:
class MyHashSet {
    private boolean [][] storage;
    int buckets;
    int bucketItems;

    public MyHashSet() { // intializing buckets and bucket items and storage
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }
    public int HashFunctionInitial(int key){
        int idx1 = key%1000;
        return idx1;
    }
    public int HashFunctionFinal(int key){
        int idx2 = key/1000;
        return idx2;
    }

    public void add(int key) { //O(1)
        int idx1 = HashFunctionInitial(key);
        if(storage[idx1] == null){
            if(idx1 == 0)
            {
                storage[idx1] = new boolean[bucketItems+1]; // zero i will get 10001 items
            }
            else{
                storage[idx1] = new boolean[bucketItems];
            }
        }
        int idx2 = HashFunctionFinal(key);
        storage[idx1][idx2] = true;
    }

    public void remove(int key) { //O(1)
        int idx1 = HashFunctionInitial(key);
        if(storage[idx1] == null) return;
        int idx2 = HashFunctionFinal(key);
        storage[idx1][idx2] = false;

    }

    public boolean contains(int key) { //O(1)
        int idx1 = HashFunctionInitial(key);
        int idx2 = HashFunctionFinal(key);
        if(storage[idx1] == null) return false;
        return storage[idx1][idx2];
    }
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

