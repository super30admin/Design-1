//Approach 1: Using the Double Hashing
//Overall Time Complexity: O(1)
//Overall Space Complexity: O(N)
class MyHashSet {
    int buckets;
    int bucketEntries;
    boolean[][] data;

    public MyHashSet() {
        buckets = 1000;
        bucketEntries = 1000;
        // Initially we are creating list of bucket that are null
        data = new boolean[buckets][];
    }

    //Time Complexity: O(1)
    public void add(int key) {
        int buckIndx = key % buckets;
        if(data[buckIndx] == null) {
            if(buckIndx == 0){
                //This is to handle the 1000000 value
                data[buckIndx] = new boolean[bucketEntries + 1];
            }else{
                data[buckIndx] = new boolean[bucketEntries];
            }

        }
        data[buckIndx][key / bucketEntries] = true;
    }

    //Time Complexity: O(1)
    public void remove(int key) {
        int buckIndx = key % buckets;
        if(data[buckIndx] == null) return;

        data[buckIndx][key / bucketEntries] = false;
    }

    //Time Complexity: O(1)
    public boolean contains(int key) {
        int buckIndx = key % buckets;
        if(data[buckIndx] == null) return false;

        return data[buckIndx][key / bucketEntries];
    }
}
