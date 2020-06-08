// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (706): Yes
// Any problem you faced while coding this : No

import java.util.Arrays;

public class MyHashMap {
    int arr[];

    MyHashMap() {
        arr = new int[1000001];
        Arrays.fill(arr, -1);
    }

    public void put(int key, int value) {
       arr[key] = value;
    }

    public int get(int key) {
        return arr[key];
    }

    public void remove(int key) {
        arr[key] = -1;
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();

        hashMap.put(1, 2);
        hashMap.put(2, 3);

        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(3));

        hashMap.put(2, 4);

        System.out.println(hashMap.get(2));

        hashMap.remove(2);
        System.out.println(hashMap.get(2));
    }

}
