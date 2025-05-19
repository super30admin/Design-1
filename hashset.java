// Time Complexity : O(1)
// Space Complexity : O(N) -- that is 10^6 because that is the max case
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : this is working fine but the storage problem is there.
// The above solution is a simple and direct solution.

// This solution is 10^6 * 1 byte for every boolean value.


// Previous Method
int size = 1000001;
	boolean[] flag;
    public MyHashSet() {
		flag = new boolean[size];
	}
    
    public void add(int key) {
        flag[key]=true;
    }
    
    public void remove(int key) {
        flag[key]=false;
    }
    
    public boolean contains(int key) {
        return flag[key];
    }

//New Method added

Time Complexity : O(1)
// Space Complexity : O(N) -- that is 10^6 because that is the max case
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Coming up whith this solution was hard. With help of instructor i was able to learn this meghtond and implement.
class MyHashSet {
    private boolean [][] storage;
    private int bucketSize;
    private int bucketItemSize;

    private int hashKey1(int key){
        return key%1000;
    }
    private int hashKey2(int key){
        return key/1000;
    }

    public MyHashSet() {
        this.bucketSize = 1000;
        this.bucketItemSize = 1000;
        this.storage = new boolean[bucketSize][];
    }
    
    public void add(int key) {
        int firstHash = hashKey1(key);
        if(storage[firstHash] == null){
            if(firstHash == 0)
                storage[firstHash] = new boolean[bucketItemSize+1];
            else
                storage[firstHash] = new boolean[bucketItemSize];
        }
        int secondHash = hashKey2(key);
        storage[firstHash][secondHash] = true;
    }
    
    public void remove(int key) {
        int firstHash = hashKey1(key);
        if(storage[firstHash] == null) return;
        int secondHash = hashKey2(key);
        storage[firstHash][secondHash] = false;
    }
    
    public boolean contains(int key) {
        int firstHash = hashKey1(key);
        if(storage[firstHash] == null) return false;
        int secondHash = hashKey2(key);
        return storage[firstHash][secondHash];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
