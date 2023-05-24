class MyHashSet {
    private int primaryArr;
    private int secArr;
    private boolean [][] nested;

    public MyHashSet() {
        this.primaryArr = 1000;
        this.secArr = 1000;
        this.nested = new boolean [primaryArr][];
    }
    
    private int hash1(int key) {
        return key%primaryArr;
    }
    
    private int hash2(int key) {
        return key/secArr;
    }
    
    public void add(int key) {
        int primaryAddr = hash1(key);
        int secAddr = hash2(key);
        if(nested[primaryAddr] == null)
        {
            if(primaryAddr == 0)
            {
                nested[primaryAddr] = new boolean [secArr+1];
            }
            else 
            {
                nested[primaryAddr] = new boolean [secArr];
            }
            
        }
        nested[primaryAddr][secAddr] = true;
    }
    
    public void remove(int key) {
        int primaryAddr = hash1(key);
        int secAddr = hash2(key);
        if(nested[primaryAddr] == null)
        {
            return;
        }
        nested[primaryAddr][secAddr] = false;
    }
    
    public boolean contains(int key) {
        int primaryAddr = hash1(key);
        int secAddr = hash2(key);
        if(nested[primaryAddr] == null)
        {
            return false;
        }
        return nested[primaryAddr][secAddr];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */