
// Design-1
// Problem 1:(https://leetcode.com/problems/design-hashset/)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class DesignHashSet {
    int bucket;
    int bucketItems;
    boolean arr[][];

    public DesignHashSet() {
        bucket = 1000;
        bucketItems = 1000;
        arr = new boolean[bucket][];
    }

    public int hashFunction1(int key){
        return key%1000;
    }

    public int hashFunction2(int key){
        return key/1000;
    }

    /*
    Approach :
    We first find index in the main array
    if there is a pointer present at the index then we apply the second hash function and mark arr[index1][index2] as true
    else if the pointer is not present we create a new array store the reference in main array and then  mark arr[index1][index2] as true

    TC : O(1)
    SC : O(1)
    */
    public void add(int key) {
        int index1 =  hashFunction1(key);
        if(arr[index1] == null){
            if(index1 == 0){
                //Edge case
                //consider you have 0<=key<=5 as the constraint
                //so at the 0 index there will always be one more  than the rest of the array as 0 and 5 both will map to 0
                arr[index1] = new boolean[bucketItems+1];
            }
            else{
                arr[index1] = new boolean[bucketItems];
            }
        }
        int index2 = hashFunction2(key);
        arr[index1][index2] = true;
    }

    /*
    Approach :
    First find the first index using hash function if there is no nested array present then we don't need to do anything
    else we need to find the index using second hash function and then unset the value at that position.
    TC : O(1)
    SC : O(1)
    */
    public void remove(int key) {
        int index1 =  hashFunction1(key);
        if(arr[index1]==null){
            return;
        }
        int index2 = hashFunction2(key);
        arr[index1][index2] = false;
    }

    /*
    Approach :
    find the index using hashfunction1 for main arr , if nested arr not present return false
    else find the index of the nested arr using hashFunction 2 and then return the value at the index;

    TC : O(1)
    SC : O(1)
    */
    public boolean contains(int key) {
        int index1 = hashFunction1(key);
        if(arr[index1]==null){
            return false;
        }
        int index2 = hashFunction2(key);
        return  arr[index1][index2];
    }
}

