class MyHashSet {
    boolean storage[][];
    int buckets;
    int bucketitems;
    public MyHashSet() {
       
        buckets = 1000;
        bucketitems = 1000;
        storage = new boolean[1000][];
    }
    
    public void add(int key) {
        int firstindex = getprimarybucketindex(key);
        int secondindex = getsecondarybucketindex(key);
        if(storage[firstindex] == null)
        {
            if(firstindex == 0)
            {
                storage[firstindex] = new boolean[bucketitems + 1];
            }
            else
            {
                storage[firstindex] = new boolean[bucketitems];
            }
        }
        storage[firstindex][secondindex]=true;
    }
    
    private int getsecondarybucketindex(int key)
    {
        return key/buckets;
    }
    
    private int getprimarybucketindex(int key)
    {
        return key%bucketitems;
    }
    
    public void remove(int key) {
        int firstindex = getprimarybucketindex(key);
        int secondindex = getsecondarybucketindex(key);
        if(storage[firstindex]==null)
        {
            return;
        }
        storage[firstindex][secondindex] = false;
    }
    
    public boolean contains(int key) {
        int firstindex = getprimarybucketindex(key);
        int secondindex = getsecondarybucketindex(key);
        if(storage[firstindex]==null)
        {
            return false;
        }
        return storage[firstindex][secondindex];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */