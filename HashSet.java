class MyHashSet {
    
    int size = 1000;
    boolean[][] primary = new boolean[size][];

    public MyHashSet() {
        
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