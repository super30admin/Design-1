//Time Complexity O(1)
//Space Complexity O(1)
//Yes
//No

class MyHashSet {
    
    boolean storage[][];

    public MyHashSet() {
        storage = new boolean[1000][];
    }
    public int getPrimaryHash(int key) {  // Hash function to calculate the primary hash (bucket index)
        return key%1000;
    }
    public int getSecondaryHash(int key) {   // Hash function to calculate the secondary hash (index within the bucket)
        return key/1000;
    }
    public boolean checkIfSecondArrayExists(int row) {
        if(storage[row] == null) {
            return false; 
        }
        return true;
    }
    
    public boolean checkIfElementExists(int row, int col) {
        if(storage[row][col] == true) {
            return true;
        }
        return false;
    }
    
    public void add(int key) {
        int row  = getPrimaryHash(key);
        int col = getSecondaryHash(key);
        if(!checkIfSecondArrayExists(row)) {
            storage[row] = new boolean[1001];
        }
        
        if(!checkIfElementExists(row, col)) {
            storage[row][col] = true;
        }
    }
    
    public void remove(int key) {
        int row  = getPrimaryHash(key);
        int col = getSecondaryHash(key);
        
        if(!checkIfSecondArrayExists(row)) {
            return;
        }
        
        if(checkIfElementExists(row, col)) {
            storage[row][col] = false;
        }
    }
    
    public boolean contains(int key) {
        int row  = getPrimaryHash(key);
        int col = getSecondaryHash(key);
        if(!checkIfSecondArrayExists(row)) {
            return false;
        }
        if(!checkIfElementExists(row, col)) {
            return false;
        }
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
