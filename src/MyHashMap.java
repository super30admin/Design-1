import java.util.Arrays;

class MyHashMap {
    int a[];

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        a = new int[1000001];
        Arrays.fill(a, -1);

    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        a[key] = value;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        return a[key];
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        a[key] = -1;
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        int x= hashMap.get(1);            // returns 1
        System.out.println(x);
        x=hashMap.get(3);            // returns -1 (not found)
        System.out.println(x);
        hashMap.put(2, 1);          // update the existing value
        x= hashMap.get(2);            // returns 1
        System.out.println(x);
        hashMap.remove(2);          // remove the mapping for 2
        x=hashMap.get(2);            // returns -1 (not found)
        System.out.println(x);

    }
}