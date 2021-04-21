// Time Complexity :-
//      Get - O(1)
//      Put - O(1)
//      Remove - O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We make use of Double Hashing to store the elements in a unique position in the matrix
*/

class MyHashMap {
    
    int[][] matrix;

    public MyHashMap() {
		matrix = new int[1000][];            
    }
    
    public int getHashKey(int key){
        return key % 1000;                      // Since the range is from 0-10^6, we intend on using a 1000*1001 matrix at the worst case
    }
    
    public int getHashKey2(int key){
        return key / 1001;                      // To accomodate the last value 10^6 and to avoid overflow, we use 1001, instead of 1000
    }
    
    public void put(int key, int value) {
        int hashKey = getHashKey(key);
        int hashKey2 = getHashKey2(key);
        if (matrix[hashKey] == null){
            matrix[hashKey] = new int[1001];     // The Nested Array is Dynamically Initialized
            Arrays.fill(matrix[hashKey], -1);    // And all values are by default -1;
        }
        matrix[hashKey][hashKey2] = value;
    }
    
    public int get(int key) {
        int hashKey = getHashKey(key);
        int hashKey2 = getHashKey2(key);
        if (matrix[hashKey] == null) return -1;  // In case the Nested Array is not present, we return the default value -1
        return matrix[hashKey][hashKey2];
    }
    
    public void remove(int key) {
        int hashKey = getHashKey(key);
        int hashKey2 = getHashKey2(key);
        if (matrix[hashKey] == null) return;    // In case the Nested Array is not present, no operation is performed
        matrix[hashKey][hashKey2] = -1;         // While removing the value, we set the default value -1
    }
}
