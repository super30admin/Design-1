import java.util.Arrays;

// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
class MyHashMap {
    int map[] = new int[100];

    /** Initialize your data structure here. */
    public MyHashMap() {
        Arrays.fill(map, -1);
    }

    // Time Complexity : Average case -> O(1); Worst case -> O(N)
    public void put(int key, int value) {
        if (key >= map.length) {
            map = increaseCapacity(map, key);
        }
        map[key] = value;
    }

    // Time Complexity : O(1)
    public int get(int key) {
        if (key >= map.length) {
            return -1;
        }
        return map[key];
    }

    // Time Complexity : O(1)
    public void remove(int key) {
        if (key >= map.length) {
            return;
        }
        map[key] = -1;
    }

    public static int[] increaseCapacity(int arr[], int capacity) {
        int temp[] = new int[capacity * 2];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = (i < arr.length) ? arr[i] : -1;
        }
        return temp;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */