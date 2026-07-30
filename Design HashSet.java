//Approach : 
//TC : O(1)
//SC : O(1)
class MyHashSet {
    int primaryKeyLen = 1000;
    int secondaryKeyLen = 1000;
    boolean[][] set;

    public MyHashSet() {
        set = new boolean[1000][]; //SC: 10^3 = constant
    }

    public void add(int key) { //TC: O(1) // SC: 10^3= constant = O(1)
        int z = key % primaryKeyLen;
        if (set[z] == null) {
            set[z] = new boolean[1000]; //SC: 10^3 = constant
        }
        int s = key / 1000;
        set[z][s] = true;
    }

    public void remove(int key) { //TC: O(1), SC: O(1)
        int z = key % 1000;
        int s = key / 1000;
        if (set[z] == null) {
            return;
        }
        set[z][s] = false;
    }

    public boolean contains(int key) {//TC: O(1), SC:O(1)
        int z = key % 1000;
        int s = key / 1000;
        if (set[z] == null) {
            return false;
        }
        if (set[z][s] == true) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */