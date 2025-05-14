// Time Complexity : O(1) for all operations.
// Space Complexity : O(n+m) n:size of bucket & m:size of bucketElements.
// Did this code successfully run on Leetcode :  Yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach
//I am implementing this using a 2D array where we can max distribute 1000 elements in each of  the buckets. By acquiring double hashing technique i will note the presence of each number in my index using true/false.

class MyHashSet {
    int size = 1000;
    boolean arr[][] = new boolean[size][];
public MyHashSet() {
   
}

private int hash_1(int key){
    return key%1000;
}

private int hash_2(int key){
    return key/1000;
}

public void add(int key) {
    int indexP = hash_1(key);
    int indexS = hash_2(key);
    
    if(arr[indexP] == null){
        arr[indexP] = new boolean[size+1];
    }
 arr[indexP][indexS] = true;
}

public void remove(int key) {
    int indexP = hash_1(key);
    int indexS = hash_2(key);

    if(arr[indexP] == null) return;

    arr[indexP][indexS] = false;
}

public boolean contains(int key) {
    int indexP = hash_1(key);
    int indexS = hash_2(key);

    if(arr[indexP] == null) return false;

  return arr[indexP][indexS];
}
}

/**
* Your MyHashSet object will be instantiated and called as such:
* MyHashSet obj = new MyHashSet();
* obj.add(key);
* obj.remove(key);
* boolean param_3 = obj.contains(key);
*/