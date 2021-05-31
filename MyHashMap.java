class MyHashMap {
    private int[][] hashArray;
    private int primArrSize;
    private int secArrSize;
    public:
    /** Initialize your data structure here. */
    MyHashMap() {
        primArrSize = 1000;
        secArrSize = 1000;
        hashArray = new int[primArrSize][secArrSize];
        // the reason we take the max length for our primary array as 1000 is because we have told value <=10^6
        //So we use the square root
    }
    int getPrimaryIndex(int key){
        return value % 1000;
    }

    int getSecondaryIndex(int key){
        return value / 1000;
    }

    /** value will always be non-negative. */
    void put(int key, int value) {
        int location1 = getPrimaryIndex(key);
        int location2 = getSecondaryIndex(key);
        if (location1 == 0 && hashArray[location1] == null){
            hashArray[location1] = new int[1001];
            hashArray[location1][location2] = value;
        }
        if(hashArray[location1] == null){
            hashArray[location1] = new int[secArrSize];
            hashArray[location1][location2] = value;
        }
        else {
            hashArray[location1][location2] = value;

        }

    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    int get(int key) {

        int location1 = getPrimaryIndex(key);
        int location2 = getSecondaryIndex(key);

        if(hashArray[location1][location2] != null){
            return hashArray[location1][location2]
        }
        else{
            return -1
        }


    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    void remove(int key) {
        int location1 = getPrimaryIndex(key);
        int location2 = getSecondaryIndex(key);

        if(hashArray[location1][location2] != null){
            hashArray[location1][location2] = null;
        }
        else{
            System.out.println("No entry found")
        }

    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */