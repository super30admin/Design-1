// Time Complexity : add,remove, contains all run in constant time O(1)
// Space Complexity : worst case O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// We solve this with double hashing. We use two arrays - primary and secondary - and insert using different hash functions
// We only create the secondary array if there exists an element for that index in the primary array
// Primary array contains pointers to secondary arrays which are boolean arrays


class MyHashSet {
    private boolean[][] hashSet;
    private int primLength;
    private int secLength;

    private int primHash(int key){ //primary hash fn
        return key%1000; //1000 is calculated as sqrt(10^6). 10^6 is the range given in question
    }

    private int secHash(int key){ //secondary hash fn
        return key/1000;
    }

    public MyHashSet() {
        this.primLength = 1000;
        this.secLength = 1000;
        hashSet = new boolean[this.primLength][]; //only initialize primary array
    }
    
    public void add(int key) {
        int primIdx = primHash(key);
        int secIdx = secHash(key);
        if(hashSet[primIdx]==null){ //initialize secondary array
            if(primIdx==0)
                hashSet[primIdx]= new boolean[primLength+1]; //to handle edge case where input is 10^6
            else
                hashSet[primIdx]= new boolean[primLength];
        }
        hashSet[primIdx][secIdx]=true;
    }
    
    public void remove(int key) {
        int primIdx = primHash(key);
        int secIdx = secHash(key);
        if(hashSet[primIdx]==null) //no element exists for that key 
            return;
        hashSet[primIdx][secIdx] = false; //mark index value as false
    }
    
    public boolean contains(int key) {
        int primIdx = primHash(key);
        int secIdx = secHash(key);
        if(hashSet[primIdx]==null) //no element exists for that key 
            return false;
        return hashSet[primIdx][secIdx]; //return value at that index
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */