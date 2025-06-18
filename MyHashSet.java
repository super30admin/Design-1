class MyHashSet {

    //int buckets[];
    //int bucketItems[];
    boolean hashset[][];
    public MyHashSet() {
        //this.buckets = new int[1000];
        //this.bucketItems = new int[];
        this.hashset = new boolean[1000][];
    }
    public int getBucket(int key){
        return key%1000;
    }
    public int getBIndex(int key){
        return key/1000;
    }
    public void add(int key) {
        int i = getBucket(key);
        if(i == 0 && hashset[i] == null){
            hashset[i] = new boolean[1001];
        }
        else if(i !=0 && hashset[i] == null){
            hashset[i] = new boolean[1000];
        }
        hashset[i][getBIndex(key)] = true;
    }
    
    public void remove(int key) {
        if(hashset[getBucket(key)] != null){
            hashset[getBucket(key)][getBIndex(key)] = false;
        }
    }
    
    public boolean contains(int key) {
        if(hashset[getBucket(key)] != null){
            return  hashset[getBucket(key)][getBIndex(key)];
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
