// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


class MyHashSet {
    private boolean storage[][];
    int buckets;
    int bucketNested;
    public MyHashSet(){
        this.buckets=1000;
        this.bucketNested=1000;
        this.storage=new boolean[this.buckets][];
    }
    int hashPrimary(int key){
        return key%buckets;
    }
    int hashSecondary(int key){
        return key/buckets;
    }
    public void add(int key) {
        int hashPrimary=hashPrimary(key);
        int hashSecondary=hashSecondary(key);
        if(storage[hashPrimary]==null){
            if(hashPrimary==0){
                storage[hashPrimary]=new boolean[this.bucketNested+1];
            }else{
                storage[hashPrimary]=new boolean[this.bucketNested];
            }
        }
        storage[hashPrimary][hashSecondary]=true;
    }
    
    public void remove(int key) {
        int hashPrimary=hashPrimary(key);
        int hashSecondary=hashSecondary(key);
        if(storage[hashPrimary]==null) return;
        storage[hashPrimary][hashSecondary]=false;
    }
    
    public boolean contains(int key) {
        int hashPrimary=hashPrimary(key);
        int hashSecondary=hashSecondary(key);
        if(storage[hashPrimary]==null) return false;
        return storage[hashPrimary][hashSecondary];
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */