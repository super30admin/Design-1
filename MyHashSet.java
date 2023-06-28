// Time Complexity : Time complexity for all these operations would be O(1)
// Space Complexity : Space complexity would be O(1) for all these functions 
// Did this code successfully run on Leetcode :Yes

// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// I am using 2d boolean array to implement double hashing. The first hash function is %1000 and the second one is /1000.
// I got the number 1000 by taking the square root of the maximum size of input. I am using this double hashing to find the position of the element in my 2d array and after I find the position, I just make that element in the boolean array to be true.
// The pointer array is initialized in the beginning but the boolean array is only initialized after first element which needs to be inserted in that bucket arrives.

class MyHashSet {

    boolean[][] hash;

    private int hash1(int h) {
        return h % 1000;
    }

    private int hash2(int h) {
        return h / 1000;
    }

    public MyHashSet() {
        this.hash = new boolean[1000][];
    }

    public void add(int key) {
        int h1 = hash1(key);
        int h2 = hash2(key);
        if (this.hash[h1] == null && h1 == 0) {
            this.hash[h1] = new boolean[1001];
        } else if (this.hash[h1] == null) {
            this.hash[h1] = new boolean[1000];
        }

        this.hash[h1][h2] = true;
    }

    public void remove(int key) {
        int h1 = hash1(key);

        if (this.hash[h1] == null)
            return;
        int h2 = hash2(key);
        this.hash[h1][h2] = false;
    }

    public boolean contains(int key) {
        int h1 = hash1(key);

        if (this.hash[h1] == null)
            return false;
        int h2 = hash2(key);
        return this.hash[h1][h2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
