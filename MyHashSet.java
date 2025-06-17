// Time Complexity : For all operations: O(1)
// Space Complexity : For all operations: O(1) 
// constant space as we declare size = 10^6 + 1.

class MyHashSet {
    private boolean[] hashSet;

    public MyHashSet() {
        hashSet = new boolean[1000001];
    }

    public void add(int key) {
        hashSet[key] = true;
    }

    public void remove(int key) {
        hashSet[key] = false;
    }

    public boolean contains(int key) {
        return hashSet[key];
    }
}