class MyHashMap {
    private int bucketsize, bucketitemsize;
    private int[][] hashmap;
    private int hkey1, hkey2;
    public MyHashMap() {
        bucketsize=1000;
        bucketitemsize=1000;
        hkey1=1000;
        hkey2=1000;
        hashmap = new int[bucketsize][];
    }
    
    public void put(int key, int value) {
        int key1= hash1(key);
        int key2 = hash2(key);
        
        if(hashmap[key1]==null)
        {
            if(key1==0)
            {hashmap[0]= new int[bucketitemsize+1]; Arrays.fill(hashmap[0],-1); }
            else
            { hashmap[key1]= new int[bucketitemsize]; 
              Arrays.fill(hashmap[key1],-1); 
            
            }
            
        }
        hashmap[key1][key2]=value;
    }
    
    private int hash1(int key) {
        return key%bucketsize;
    }
    
    private int hash2(int key) {
        return key/bucketitemsize;
    }    
    
    public int get(int key) {
        if(hashmap[hash1(key)]==null) return -1;
        return hashmap[hash1(key)][hash2(key)];
    }
    
    public void remove(int key) {
        if(hashmap[hash1(key)]==null) return;
        hashmap[hash1(key)][hash2(key)]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */