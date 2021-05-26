class MyHashMap {
    
    //primary data structure
    int[] map;

    /** Initialize your data structure here. */
    public MyHashMap() {
        //initialize ds and fill with -1s
        map = new int[1000000];
        Arrays.fill(map, -1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        //"put" at index key in array
        map[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        //first check if its a -1 (not found)
        if (key < 0 || key > 1000000 || map[key] == -1) {
            return -1;
        } else {
            return map[key];
        }
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        //removing is just making it -1
        map[key] = -1;
    }
}