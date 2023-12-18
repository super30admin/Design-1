// Time Complexity : For add() its O(1) and it's O(x) for other operations, Here x denotes the length of the chain at an hash index.
// Space Complexity : O(1) for this problem because the size is always 1000 but in general its O(M + N) where M denotes the table size and N denotes the buckets.
// Method used : Chaining

class MyHashSet {
    
    int size = 1000;
    boolean[][] primary;

    public MyHashSet() {
        primary = new boolean[size][];
    }
    
    public void add(int key) {
        if(contains(key) == true) return;
        
        int mod = key % size;
        int div;
        
        if(primary[mod] == null)
        {
            if(mod == 0) primary[mod] = new boolean[size + 1];
            
            else primary[mod] = new boolean[size];
        } 
        div = key / size;
        primary[mod][div] = true;
    }
    
    public void remove(int key) {
        if(contains(key) != false)
            primary[key % size][key / size] = false;
        
    }
    
    public boolean contains(int key) {
        int mod = key % size;
        int div = key / size;
        if(primary[mod] == null || primary[mod][div] == false)
            return false;
        return true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */