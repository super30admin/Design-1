// Time Complexity - O(1) for all the operations
//Space Complexity - Array[1000][1000]

class MyHashSet {
    private boolean[][] arr;
    private static final int H1_Helper =1000;
    private static final int H2_Helper = 1000;

    public MyHashSet() {
        arr = new boolean[H1_Helper][];
    }

    private int getHash1(int key){
        return key % H1_Helper;
    }
    private int getHash2(int key){
        return key / H2_Helper;
    }

    public void add(int key) {
        if(!contains(key)){
            int hash1 = getHash1(key);
            if(arr[hash1]==null){
                if(hash1 == 0){
                    arr[hash1] = new boolean [H1_Helper +1];
                }
                else arr[hash1] = new boolean[H1_Helper];
            }
            int hash2 = getHash2(key);
            arr[hash1][hash2] =  true;
        }

    }

    public void remove(int key) {
        if(contains(key)){
            int hash1 = getHash1(key);
            int hash2 = getHash2(key);
            arr[hash1][hash2] = false;
        }

    }

    public boolean contains(int key) {
        int hash1 = getHash1(key);
        if(arr[hash1] == null){
            return false;
        }
        int hash2 = getHash2(key);
        return arr[hash1][hash2];

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */