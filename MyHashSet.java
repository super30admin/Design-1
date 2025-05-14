// Time Complexity : all methods have amortized time:O(1),
// Space Complexity : O(n) for n elements in the hashset
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 
// Approach: Internally using double hashing
class MyHashSet {
    boolean data[][];
    int buckets, bucketItems;
    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        data = new boolean[buckets][];
    }
    int hashFunction1(int key){
        return key%1000;
    }
    int hashFunction2(int key){
        return key/1000;
    }
    
    public void add(int key) {
        int i1 = hashFunction1(key);
        if(data[i1] == null){
            if(i1 == 0){
                data[i1] = new boolean[bucketItems + 1];
            }
            else
                data[i1] = new boolean[bucketItems];
        }
        int i2 = hashFunction2(key);
        data[i1][i2] = true;
    }
    
    public void remove(int key) {
        int i1 = hashFunction1(key);
        int i2 = hashFunction2(key);
        if(data[i1] == null){
            return;
        }
        data[i1][i2] = false;
    }
    
    public boolean contains(int key) {
        int i1 = hashFunction1(key);
        int i2 = hashFunction2(key);
        if(data[i1] == null){
            return false;
        }
        return data[i1][i2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */