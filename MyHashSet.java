// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// 1. Created a parent list which resembles buckets of a fixed size - 100
// 2. Computed an index to place the key by modulo of key and fixed size
// 3. To tackle collision, create a linkedlist at the computed index. If list exists at that index and doesn't contain the key, add it. If list doesn't exist at the index, create list and add key
// 4. To remove key, get the appropriate index for the bucket and remove the key from the list at that index if key exists, else no operation required
// 5. Check if key is present within the list at the computed index for the buckets 

class MyHashSet {
    
    private final int SIZE = 100;
    List<List<Integer>> buckets;
    
    public MyHashSet() {
        buckets = new ArrayList<>(SIZE);
        for(int i = 0; i < SIZE; i++) {
            buckets.add(null);
        }
    }
    
    public void add(int key) {
        
        int index = key % SIZE;
        List<Integer> bucketList = buckets.get(index);
        if(bucketList == null) {
            List<Integer> list = new LinkedList<>();
            list.add(key);
            buckets.set(index, list);
        }
        else {
            if(!bucketList.contains(key)) {
                bucketList.add(key);
            }
        }
    }
    
    public void remove(int key) {
        int index = key % SIZE;
        List<Integer> bucketList = buckets.get(index);
        if(bucketList != null) {
            bucketList.remove(Integer.valueOf(key));
        }
        
    }
    
    public boolean contains(int key) {
        int index = key % SIZE;
        List<Integer> bucketList = buckets.get(index);
        return bucketList != null && bucketList.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */