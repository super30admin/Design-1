// Time Complexity : add - O(1), remove - O(1) , contains - O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none
/*
 * In this solution we first take a boolean array of the size sqrt(n);
 * We have set up 2 hash functions, 1 for getting the index within the main array and second one is to get the index inside the subarray;
 * On push, using the hash function we get the indices and we check if the value is null. If then null then we initialize the subaary of size sqrt(n) and set the value at the index returned 
 * by the 2nd hash function as True. On contains and remove we check if the value at the indices is true or not.
 */

//https://leetcode.com/problems/design-hashset/description/
class MyHashSet {
    boolean[][] hashSet;
    int buckets;
    int bucketItems;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        hashSet = new boolean[buckets][];
    }

    private int hashFunction1(int key){
        return key%buckets;
    }

    private int hashFunction2(int key){
        return key/buckets;
    }
    
    public void add(int key) {
        int index = hashFunction1(key);
        int subIndex = hashFunction2(key);
        if(hashSet[index] == null){
            if(index==0){
                hashSet[index]=new boolean[bucketItems+1];
            }else{
                hashSet[index] = new boolean[bucketItems];
            }
        }
        hashSet[index][subIndex]=true;
    }
    
    public void remove(int key) {
        int index = hashFunction1(key);
        int subIndex = hashFunction2(key);
        if(hashSet[index]!=null){
            hashSet[index][subIndex]=false;
        }
    }
    
    public boolean contains(int key) {
        int index = hashFunction1(key);
        int subIndex = hashFunction2(key);
        if(hashSet[index]!=null){
            if(hashSet[index][subIndex]){
                return hashSet[index][subIndex];
            }
        }
        return false;
    }
}

