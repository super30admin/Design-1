import java.util.LinkedList;

public class MyHashSet {
    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));    // returns true
        System.out.println(hashSet.contains(3));    // returns false (not found)
        hashSet.add(2);
        System.out.println(hashSet.contains(2));    // returns true
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));    // returns false (already removed)
    }

    int[] arr;
    public MyHashSet() {
        arr = new int[1000001];
    }

    public void add(int key) {
        arr[key] = key+1;
    }

    public void remove(int key) {
        arr[key] = 0;
    }

    public boolean contains(int key) {
        return arr[key] != 0;
    }

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
}
