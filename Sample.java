/*
Time Complexity :
    Add: O(1)
    Remove: O(1)
    Contains: O(1)
Space Complexity :
    Worst Case: O(n)
// Did this code successfully run on Leetcode : Yes

*/


// Your code here along with comments explaining your approach
class MyHashSet {
    private int primaryBuckets;
    private int secondaryBuckets;
    private boolean[][] buckets;

    public MyHashSet() {
        primaryBuckets = 1000;
        secondaryBuckets = 1000;
        buckets = new boolean[primaryBuckets][];
    }

    public int getPrimaryIndex(int key){
        return key%1000;
    }

    public int getSecondaryIndex(int key){
        return key/1000;
    }

    public void add(int key) {
        int primaryIndex = getPrimaryIndex(key);
        int secondaryIndex = getSecondaryIndex(key);
        if(buckets[primaryIndex] == null){
            if(primaryIndex == 0){
                buckets[primaryIndex] = new boolean[secondaryBuckets+1];
                buckets[primaryIndex][secondaryIndex] = true;
            }
            else{
                buckets[primaryIndex] = new boolean[secondaryBuckets];
                buckets[primaryIndex][secondaryIndex] = true;
            }
        }
        else
        {
            buckets[primaryIndex][secondaryIndex] = true;
        }
    }

    public void remove(int key) {
        int primaryIndex = getPrimaryIndex(key);
        int secondaryIndex = getSecondaryIndex(key);
        if(buckets[primaryIndex] == null){
            return;
        }
        else{
            buckets[primaryIndex][secondaryIndex] = false;
        }
    }

    public boolean contains(int key) {
        int primaryIndex = getPrimaryIndex(key);
        int secondaryIndex = getSecondaryIndex(key);
        if(buckets[primaryIndex] == null){
            return false;
        }
        else{
            return buckets[primaryIndex][secondaryIndex];
        }
    }


}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
