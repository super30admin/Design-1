class MyHashMap {

    ArrayList<int[]> arrli = null;

    /** Initialize your data structure here. */
    public MyHashMap() {

        arrli = new ArrayList<int[]>();
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {

        for(int[] a : arrli){
            if(a[0] == key) {
                a[1] = value;
                return;
            }
        }

        int[] arr = {key,value};
        arrli.add(arr);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {

        for(int[] a : arrli){
            if(a[0] == key) return a[1];
        }

        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {

        for(int[] a : arrli){
            if(a[0] == key) {
                arrli.remove(a);
                break;
            }
        }

    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
