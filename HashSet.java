// Time Complexity :
// * Time complexity is constant for all the functions as we just need to access which also is needed two be done 2 times (maximum)

// Space Complexity :
// * the functions have constant space complexity as no relevant new space is occupied
// * O(n) --> THe space required for the 2d array

// Did this code successfully run on Leetcode : Ran successsfully on Leetcode
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//      We maintain a 2d boolean array and use 2 hash functions.
//      We choose a size of 100 as that saves us space and also
//      doesn't cause a lot of collision.Since the boolean arrays at the position of the primary array are not initialised initially we save that space

class MyHashSet {

    private int mainArrElements;
    private int subArrELements;
    private boolean[][] hashSet;

    public MyHashSet() {
        this.mainArrElements = 1000;
        this.subArrELements = 1000;
        this.hashSet = new boolean[mainArrElements][];
    }

    public void add(int key) {
        int mainArrptr = Hash1(key);
        int subARrptr = Hash2(key);

        if(hashSet[mainArrptr] == null){
            if(mainArrptr == 0){
                hashSet[mainArrptr] = new boolean[subArrELements + 1];
            }else{
                hashSet[mainArrptr] = new boolean[subArrELements];
            }
        }
        hashSet[mainArrptr][subARrptr] = true;
    }

    public void remove(int key) {
        int mainArrptr = Hash1(key);
        if(hashSet[mainArrptr]==null){
            return;
        }

        hashSet[mainArrptr][Hash2(key)] = false;

    }

    public boolean contains(int key) {
        int mainArrptr = Hash1(key);
        if(hashSet[mainArrptr] == null) return false;

        int subARrptr = Hash2(key);
        return hashSet[mainArrptr][subARrptr];
    }

    public int Hash1(int val){
        return val%1000;
    }

    public int Hash2(int val){
        return val/1000;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */


