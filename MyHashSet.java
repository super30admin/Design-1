// Time Complexity : for add, remove, and contains O(1)
// Space Complexity : O(1000000)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I have considered Arrays to implement HashSet functionality because Arrays are continuous memory allocation.
And accessing any element or removing element is arrays can be implemented in O(1) because of continuous
memory. Instead of having 10 power 6 continuous slots, I have split the 10 power 6 single array to a 2D array
of rows 1000 and columns 1000.
*/

class MyHashSet {

    private boolean[][] hashset;

    public MyHashSet() {
        hashset = new boolean[1000][];
    }

    public int hash1(int key){
        return key%1000;
    }

    public int hash2(int key){
        return key/1000;
    }

    public void add(int key) {
        int hash1Key = this.hash1(key);
        int hash2Key = this.hash2(key);
        if(hashset[hash1Key]==null){
            if(hash1Key == 0){
                hashset[hash1Key] = new boolean[1001];
            }
            else{
                hashset[hash1Key] = new boolean[1000];
            }
        }
        hashset[hash1Key][hash2Key] = true;
    }

    public void remove(int key) {
        int hash1Key = this.hash1(key);
        if(hashset[hash1Key]==null) return;

        int hash2Key = this.hash2(key);
        hashset[hash1Key][hash2Key] = false;
    }

    public boolean contains(int key) {
        int hash1Key = this.hash1(key);
        if(hashset[hash1Key]==null){
            return false;
        }

        int hash2Key = this.hash2(key);
        if(hashset[hash1Key][hash2Key]==false){
            return false;
        }
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
