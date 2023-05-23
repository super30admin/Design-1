// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
/* Any problem you faced while coding this : Was unsure about how much size I should take for the array while initialising it. 
Also faced null pointer exception error which got solved after adding the null checker. Had a doubt about what happens if
I try to store something linearly without using a hash function???? as I already have given huge array size to accomodate all */

// Also found a nice approach -- https://walkccc.me/LeetCode/problems/0705/


// Your code here along with comments explaining your approach

class MyHashSet {
    // As we need to find whether array contains hence searching is involved hence used hashing type Data structure to make O(1) average time complexity
    Integer[] arr;

    public MyHashSet() {
        arr = new Integer[1000001]; //Did this as input range given is between 0 and 10^6
    }
    
    public void add(int key) {
        int storeIndex = hashFunc(key);
        arr[storeIndex] = key;
    }
    
    public void remove(int key) {
        int storeIndex = hashFunc(key);
        if(arr[storeIndex]!=null && arr[storeIndex].equals(key)){ //applied null checker for avoiding null pointer exception
            arr[storeIndex] = null;
        }
    }
    
    public boolean contains(int key) {
        int storeIndex = hashFunc(key);
        if(arr[storeIndex]!=null && arr[storeIndex].equals(key)){
            return true;
        }else{
            return false;
        }
    }
    
    private int hashFunc(int key){
        /* used hash function to ensure that the keys are stored at unique locations and also have time complexity O(1) as instead 
        I would always need to traverse to the empty location if I stored it linearly in ordered manner. */
        return key%(arr.length-1);
    }
    
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */