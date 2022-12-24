// Time Complexity : add(), remove() and contains() will all run in constant time O(1)
// Space Complexity : space complexity is constant O(10^6) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Did not consider edge case of 10^6 in the first attempt


// Your code here along with comments explaining your approach

// Explanation: I am making use of a static array to solve this problem. I've created a function to 
// calculate index of hash based on its remainder when divided by 1000001(size of array). 
// Since we know range of input, we can initialize all values to -1.

class MyHashSet {
    int[] hashSet;

    public int getHashIndex(int key) 
    {
        return key%1000001;
    }

    public MyHashSet() {
        hashSet = new int[1000001];
        Arrays.fill(hashSet, -1);
    }
    
    public void add(int key) {
        int hashIndex = getHashIndex(key);
        hashSet[hashIndex] = key;
    }
    
    public void remove(int key) {
        int hashIndex = getHashIndex(key);
        hashSet[hashIndex]=-1; //revert to intial value, also works if element does not exist 
    }
    
    public boolean contains(int key) {
        int hashIndex = getHashIndex(key);
        if(hashSet[hashIndex]==-1) //no element exists for this index 
            return false;
        return true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
