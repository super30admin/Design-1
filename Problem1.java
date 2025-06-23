// Time Complexity : 
// add -> O(1)
// remove -> O(1)
// contain -> O(1)
// Space Complexity : 
// add -> O(1)
// remove -> O(1)
// contain -> O(1)
class MyHashSet {
    int Bucket;
    int BucketItem;
    boolean[][] Storage;
    public MyHashSet() {
        this.Bucket= 1000;
        this.BucketItem=1000;
        this.Storage = new boolean [Bucket][];

    }
    public int getbucket(int key){
        return key % Bucket;
    }
    public int getbucketItem(int key){
        return key / BucketItem;
    }
    public void add(int key) {
       int Bucket = getbucket(key);
        if(Storage[Bucket] == null){
            if(Bucket == 0){
                Storage[Bucket] = new boolean[BucketItem+1];
            }else{
                Storage[Bucket] = new boolean[BucketItem];
            }
        }
        int BucketItem = getbucketItem(key);
        Storage[Bucket][BucketItem] = true;
    }
    
    public void remove(int key) {
        int Bucket =getbucket(key);
        int BucketItem =getbucketItem(key);

        if(Storage[Bucket]== null)
        {
            return ;
        }
        Storage[Bucket][BucketItem]=false;
    }
    
    public boolean contains(int key) {
        int Bucket =getbucket(key);
        int BucketItem =getbucketItem(key);

        if(Storage[Bucket]== null)
        {
            return false;
        }
        return Storage[Bucket][BucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */