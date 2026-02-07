class MyHashSet {

    int primaryArraySize;
    int secondaryArraySize;

    boolean[][] customHashArray;

    public MyHashSet() {
        this.primaryArraySize = 1000;
        this.secondaryArraySize = 1000;
        this.customHashArray = new boolean[primaryArraySize][];
    }
    
    public int getPrimaryHashValue(int key) {
        return key % primaryArraySize;
    }

    public int getSecondaryHashValue(int key) {
        return key / secondaryArraySize;
    }

    public void add(int key) {

        int primaryPos = getPrimaryHashValue(key);
        int secondaryPos = getSecondaryHashValue(key);

        if(customHashArray[primaryPos] == null) {
            if(primaryPos == 0 && secondaryPos == 1000) {
                customHashArray[primaryPos] = new boolean[secondaryArraySize + 1];
            } else {
                customHashArray[primaryPos] = new boolean[secondaryArraySize];
            }
        }
        customHashArray[primaryPos][secondaryPos] = true;
    }
    
    public void remove(int key) {
        int primaryPos = getPrimaryHashValue(key);
        int secondaryPos = getSecondaryHashValue(key);
        if(customHashArray[primaryPos] != null) {
            customHashArray[primaryPos][secondaryPos] = false;
        }
        
    }
    
    public boolean contains(int key) {
        int primaryPos = getPrimaryHashValue(key);

        if(customHashArray[primaryPos] == null) {
            return false;
        }
        int secondaryPos = getSecondaryHashValue(key);
        return customHashArray[primaryPos][secondaryPos];

    }
}
