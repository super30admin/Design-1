// Time Complexity : 
// Space Complexity :
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class MyHashSet {
    int buckets;
        int bucketItems;
        boolean[][] Arr;
    public MyHashSet() {
    buckets=1000;
    bucketItems=1000;
    Arr= new boolean[buckets][];
    }
    private int hash1(int key){
        return key%buckets;
    }
    private int hash2(int key){
        return key/bucketItems;
    }
    public void add(int key) {
        if(Arr[hash1(key)] == null){
            if(hash1(key)==0){
                Arr[hash1(key)]= new boolean[bucketItems+1];
            }
            else Arr[hash1(key)]= new boolean[bucketItems];
        } Arr[hash1(key)][hash2(key)]=true;
    }
    
    public void remove(int key) {
        if(Arr[hash1(key)]!=null){
            Arr[hash1(key)][hash2(key)]=false;
        }
        else return;
        
    }
    
    public boolean contains(int key) {
 if(Arr[hash1(key)]!=null){
            return Arr[hash1(key)][hash2(key)];
        }
        else return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */