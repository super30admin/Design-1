// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 * Init a 2d array of size [1000*1000] in order to map all elements to unique indices
 * Compute outer and inner hashcodes while inserting, deletion & contains
 */
class MyHashSet {

    boolean[][] arr;

    public MyHashSet() {
        arr = new boolean[1000][1001]; // the inner hash code can result in the max index = 1000
    }

    public void add(int key) {
        int outerHashCode = getOuterHashCode(key);
        if(arr[outerHashCode] == null) {
            arr[outerHashCode] = new boolean[1000];
        }
        int innerHashCode = getInnerHashCode(key);
        arr[outerHashCode][innerHashCode] = true;
    }

    public void remove(int key) {
        int outerHashCode = getOuterHashCode(key);
        if(arr[outerHashCode] == null) return;
        int innerHashCode = getInnerHashCode(key);
        arr[outerHashCode][innerHashCode] = false;
    }

    public boolean contains(int key) {
        int outerHashCode = getOuterHashCode(key);
        if(arr[outerHashCode] == null) return false;
        int innerHashCode = getInnerHashCode(key);
        return arr[outerHashCode][innerHashCode];
    }

    private int getOuterHashCode(int key){
        return key % 1000;
    }

    private int getInnerHashCode(int key){
        return key / 1000;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */