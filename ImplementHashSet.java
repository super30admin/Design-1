class MyHashSet {
    
    boolean[][] storageHash;
    int primaryArray;
    int secondaryArray;

    public MyHashSet() {
        primaryArray = 1000; 
        secondaryArray = 1000; 
        storageHash = new boolean[primaryArray][];
    }
    
    public int findPrimaryArrayIndex(int key) {
        return key % primaryArray;
    }
    
    public int findSecondaryArrayIndex(int key) {
        return (key / secondaryArray);
    }
    
    public void add(int key) {
        int primaryArrayIndex = findPrimaryArrayIndex(key); 
        int secondaryArrayIndex = findSecondaryArrayIndex(key);
        if (storageHash[primaryArrayIndex] == null) {
        
            if (primaryArrayIndex == 0) {
                storageHash[primaryArrayIndex] = new boolean[1000 + 1];
                
            } else {
                storageHash[primaryArrayIndex] = new boolean[1000];
                
            }
            
        }
        
        storageHash[primaryArrayIndex][secondaryArrayIndex] = true;
                  
    }
    
    public void remove(int key) {
        int primaryArrayIndex = findPrimaryArrayIndex(key); 
        int secondaryArrayIndex = findSecondaryArrayIndex(key);
        
        if (storageHash[primaryArrayIndex] == null) {
            return;
        }
        
        storageHash[primaryArrayIndex][secondaryArrayIndex] = false;
        
    }
    
    public boolean contains(int key) {
        int primaryArrayIndex = findPrimaryArrayIndex(key); 
        int secondaryArrayIndex = findSecondaryArrayIndex(key);
        
        if (storageHash[primaryArrayIndex] == null) {
            return false;
        } else {
            return storageHash[primaryArrayIndex][secondaryArrayIndex];
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