package S30_Codes.Design_1;

// Time Complexity : O(1) for all Operation
// Time Complexity : O(n) // n is key count
// Design - 1

class MyHashSet {
    private boolean[][] arr;
    private static final int BUCKET_1_SIZE = 1000+1;
    private static final int BUCKET_2_SIZE = 1000;

    private int hash1(int key){
        return (key / BUCKET_1_SIZE);
    }

    private int hash2(int key){
        return (key % BUCKET_2_SIZE);
    }

    public MyHashSet() {
        arr = new boolean[BUCKET_1_SIZE][];
    }

    public void add(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);

        if(arr[hash1] == null){
            if(key == 1_000_000)
                arr[hash1] = new boolean[1];
            else
                arr[hash1] = new boolean[BUCKET_2_SIZE];
        }

        arr[hash1][hash2] = true;
    }

    public void remove(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);

        if(arr[hash1] != null)
            arr[hash1][hash2] = false;
    }

    public boolean contains(int key) {
        int hash1 = hash1(key);
        int hash2 = hash2(key);

        if(arr[hash1] != null)
            return arr[hash1][hash2];

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