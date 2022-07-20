// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

class MyHashSet {
    private boolean[][] array;
    int bucket;
    int bucketItem;

    public MyHashSet() {
        this.bucket = 1000;
        this.bucketItem = 1000;
        this.array = new boolean[bucket][];
    }

    public int myHash1(int num){
        return num%bucket;
    }

    public int myHash2(int num){
        return num/bucketItem;
    }

    public void add(int key) {
        int hash1 = myHash1(key);
        int hash2 = myHash2(key);

        if(array[hash1] == null){
            if(hash1 == 0){
                array[hash1] = new boolean[bucketItem + 1];
            } else{
                array[hash1] = new boolean[bucketItem];
            }
        }

        array[hash1][hash2] = true;
    }

    public void remove(int key) {
        int hash1 = myHash1(key);
        int hash2 = myHash2(key);
        if(array[hash1] == null){
            return ;
        }
        array[hash1][hash2] = false;
    }

    public boolean contains(int key) {
        int hash1 = myHash1(key);
        int hash2 = myHash2(key);
        if(array[hash1] == null){
            return false;
        }
        return array[hash1][hash2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */