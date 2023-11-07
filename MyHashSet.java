//TC: O(1) for all operation
//SC: O(1) as it uses constant space
public class MyHashSet {
    boolean[] arr;

    public MyHashSet() {
        arr = new boolean[100001];
    }

    public void add(int key) {
        arr[key] = true;

    }

    public void remove(int key) {
        arr[key] = false;

    }

    public boolean contains(int key) {
        return arr[key];

    }
}
