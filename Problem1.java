
// Time Complexity : O(1) for all operations
// Space Complexity : O(n) for the 2D array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// we use double hashing , primary hash function is used to find the row and secondary hash function 
// is used to find the column if the element is present, we set the value to true, 
// if not present we set it to false when we remove an element, we set the value to false 
 
class MyHashSet {
    int primarySize, secondarySize;
    boolean a[][];
    public MyHashSet() {
        this.primarySize=1000;
        this.secondarySize=1001;
       this.a=new boolean[primarySize][];
    }
    public int primaryHashFunc(int k){
        return k%primarySize;
    }
    public int secondaryHashFunc(int k){
        return k%secondarySize;
    }
    public void add(int key) {
        int pk=primaryHashFunc(key);
        if(a[pk]==null){
            a[pk]=new boolean[secondarySize];
        }
        int sk=secondaryHashFunc(key);
        a[pk][sk]=true;
    }
    
    public void remove(int key) {
        int pk=primaryHashFunc(key);
        if(a[pk]==null){
            return;
        }
        int sk=secondaryHashFunc(key);
        a[pk][sk]=false;
    }
    
    public boolean contains(int key) {
        int pk=primaryHashFunc(key);
        if(a[pk]==null){
            return false;
        }
        int sk=secondaryHashFunc(key);
        return a[pk][sk];
    }
}