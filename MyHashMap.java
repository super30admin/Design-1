class MyHashMap {

    int counter = 0;
    int[][] store = new int[900][];

    /** Initialize your data structure here. */
    public MyHashMap() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        counter++;
        int hashedIndex = hash_fun(key);

        int[] temp = store[hashedIndex];

        if (temp == null || temp[0] == 0 || temp[0] == key) {
            store[hashedIndex] = new int[] { key, value };
        } else {
            store[hashedIndex + 21 + (key % 3)] = new int[] { key, value };
        }
    }

    public int hash_fun(int key) {
        int index = key % 20;
        return index;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(int key) {
        int[] temp = store[key % 20];

        if (temp[0] == key) {
            return temp[1];
        } else if (temp[0] != key && temp[0] > 0) {
            return store[(key % 20) + 21 + (key % 3)][1];
        } else {
            return -1;
        }
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping
     * for the key
     */
    public void remove(int key) {
        counter--;
    }

    // drive
    public static void main(String[] args) {
        MyHashMap objHash = new MyHashMap();
        objHash.put(1, 2);
        objHash.put(2, 3);
        objHash.put(3, 44);
        objHash.put(4, 245645);
        objHash.put(555, 7787);
        System.out.println(objHash.get(555));
        System.out.println(objHash.get(1));
        System.out.println(objHash.get(3));

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */