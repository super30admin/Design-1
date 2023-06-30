// Time Complexity : 0(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class MyHashSet {
    boolean[][] arr;
    int L1;
    int L2;
    public MyHashSet() {
        L1 = 1000;
        L2 = 1000;
        arr = new boolean[L1][];
    }

    public void add(int key) {
        int bucketIndex = key % L1;
        int bucketListIndex = key / L2;
        if(arr[bucketIndex] == null){
            if(bucketIndex == 0) {
                arr[bucketIndex] = new boolean[L2+1];
            }
            else{
                arr[bucketIndex] = new boolean[L2];
            }
        }
        arr[bucketIndex][bucketListIndex] = true;

    }

    public void remove(int key) {
        int bucketIndex = key % L1;
        int bucketListIndex = key/ L2;
        if(arr[bucketIndex] == null) return;
        arr[bucketIndex][bucketListIndex] = false;
    }

    public boolean contains(int key) {
        int bucketIndex = key % L1;
        int bucketListIndex = key / L2;
        if(arr[bucketIndex] == null){return false;}
        return arr[bucketIndex][bucketListIndex];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */