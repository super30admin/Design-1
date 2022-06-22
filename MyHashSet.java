/*
Time complexity - O(1) as determining hashkey and storing is a constant operation
Space complexity - O(n) asymptotically as the keyrange changes depending on the input
Has it passed all testcases on leetcode? - Yes
*/

/*
 As the input range is 0 <= key <= 10^6, having a keyrange of 10^6 will cause a lot of memory wastage as all the numbers
 might not be inserted. So picking a keyrange of size 10^3 to reduce it. we are using a boolean 2d array  and a double hashing method
 for collision. Both tha hashing methods should be different otherwise it will have collision again. if the primary bucketarray is null,
 then create a new boolean array under it and use double hashing key and toggle the array value to true. Similary when deleting the 
 key, toggle the array value to false. These true and false values at the hashing index indicate if the element is contained in the hashset.
 */
class MyHashSet {
    int hashKeyRange;
    boolean[][] bucketArray;

    public MyHashSet() {
        this.hashKeyRange = 1000;
        this.bucketArray = new boolean[hashKeyRange][];
    }

    protected int _hash(int key){
        return key % this.hashKeyRange;
    }
    
    protected int _doubleHash(int key){
        return key / this.hashKeyRange;
    }

    public void add(int key) {
        int hashKey = _hash(key);
        int doubleHashKey = _doubleHash(key);
        if(bucketArray[hashKey] == null){
            if(hashKey == 0){
                bucketArray[hashKey] = new boolean[this.hashKeyRange + 1];
            }
            else{
                bucketArray[hashKey] = new boolean[this.hashKeyRange];
            }
        }
        bucketArray[hashKey][doubleHashKey] = true;
    }
    
    public void remove(int key) {
        int hashKey = _hash(key);
        int doubleHashKey = _doubleHash(key);
        if(bucketArray[hashKey] == null)
            return;
        bucketArray[hashKey][doubleHashKey] = false;
    }
    
    public boolean contains(int key) {
        if(bucketArray[_hash(key)] == null)
            return false;
        return bucketArray[_hash(key)][_doubleHash(key)];
    }
}
