// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.ArrayList;
class MyHashSet {

    ArrayList<Integer> list;
    public MyHashSet() {
        list = new ArrayList<>();
    }
    public void add(int key) {
        if (!list.contains(key)) {
            list.add(key);
        }
    }
    public void remove(int key) {
        if (list.contains(key)) {
            list.remove(Integer.valueOf(key));
        }
    }
    public boolean contains(int key) {
        return list.contains(key);
    }

    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        obj.add(1);
        obj.add(2);
        System.out.println("Contains 1: " + obj.contains(1));
        System.out.println("Contains 3: " + obj.contains(3)); 
        obj.add(2);
        System.out.println("Contains 2: " + obj.contains(2));
        obj.remove(2);
        System.out.println("Contains 2 after remove: " + obj.contains(2));
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */