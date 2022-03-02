
// Time Complexity : O(sqroot(n)) in worst case bacause it would have to fill array during put operation
// Space Complexity : O(n) worst case
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashMap {

        private int parentBucket;
        private int childBucket;
        private int[][] a;
    
    public MyHashMap() {
        a = new int[1000][];

    }
    
    // Add values into parent and child buckets based on hash values
    public void put(int key, int value) {
        parentBucket = key%1000;
        childBucket = key/1000;
        if(a[parentBucket]==null){
            if(parentBucket==0){
                a[parentBucket]= new int[1001]; // case for 10^6
            }else{
                a[parentBucket]= new int[1000];
            }
            for(int i = 0; i < a.length; i++){ // fill with -1 for unchanged values since 0 is in bounds
                a[parentBucket][i]=-1;
            }
        }
        
        
        a[parentBucket][childBucket] = value;

    }
    
    //get values based on key with same hash functions
    public int get(int key) {
        
        parentBucket = key%1000;
        childBucket = key/1000;
        if(a[parentBucket]==null){
            return -1; // return -1 is not exists or parent bucket not created
        }else{
            return a[parentBucket][childBucket];
        }
    }
    
    public void remove(int key) {
        parentBucket = key%1000;
        childBucket = key/1000;
        if(a[parentBucket]==null){
            return; // do nothing if child buckets not created
        }
        a[parentBucket][childBucket] = -1; // set value back to -1 if exists
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
