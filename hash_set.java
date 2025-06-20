// This solution, we create 2D boolean array to store unique values. We use two seperate functions for hashing to avoid collisions.
// One hashing function (n % size) will be applied first and if there exists a value, then (n / size) will be applied.
// Here, we have 2D array of size - 1000 rows and 1000 columns therefors, 10^6 values can be stored.
// Time complexity : O(1)
// Space Complexity : O(1)

class MyHashSet {
    private static final int size = 1000;
    private boolean[][] hashSet;
    private int index1;
    private int index2;

    public MyHashSet() {
        hashSet = new boolean[size][size+1];
    }

    public int getIndex1(int key){
        return key % size;
    }

    public int getIndex2(int key){
        return key / size;
    }
    
    public void add(int key) {
        index1 = getIndex1(key);
        index2 = getIndex2(key);
        if (hashSet[index1] == null){
            if (index1 == 0){
                hashSet[index1] = new boolean[size+1];
            }
            else { 
                hashSet[index1] = new boolean[size];
            }
        }
        hashSet[index1][index2] = true;
    }
    
    public void remove(int key) {
        index1 = getIndex1(key);
        index2 = getIndex2(key);
        if(hashSet[index1]!=null){
            hashSet[index1][index2] = false;
        }
    }
    
    public boolean contains(int key) {
        index1 = getIndex1(key);
        index2 = getIndex2(key);
        if(hashSet[index1]==null){
            return false;
        }
        return hashSet[index1][index2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
