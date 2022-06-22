// Time Complexity : O(1) for add remove contains
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
class MyHashSet {
    
    boolean[][] h;
    int bucket;
    int bucketItems;
    public MyHashSet() {
    	bucket = 1000; // 10^6/2
    	bucketItems = 1000;
        h = new boolean[bucket][];
        
    }
    
    private int getPrimaryIndex(int key){
        return key%bucket;  //hash function to get index in primary array
    }
    private int getSecondaryIndex(int key){
        return key/bucket; //hash function to get index in secondary array
    } 
    
    public void add(int key) {
        int index = getPrimaryIndex(key);
        int sindex = getSecondaryIndex(key);
        if(h[index]==null){
            if(index==0){
                h[index]= new boolean[bucketItems+1]; //edge case if value is 10^6
            }
            else{
                h[index]=new boolean[bucketItems];
            }
        }
        h[index][sindex] = true;
    }
    
    public void remove(int key) {
        int index = getPrimaryIndex(key);
        int sindex = getSecondaryIndex(key);
        if(h[index]!=null) 
            h[index][sindex] = false;     //if element is present make it false
        
    }
    
    public boolean contains(int key) {
        int index = getPrimaryIndex(key);
        int sindex = getSecondaryIndex(key);
        if(h[index]==null)
            return false;
        return h[index][sindex];    // return the element if present
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */