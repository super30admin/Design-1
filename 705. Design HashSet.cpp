// Time Complexity :O(N) in worst case and O(1) in average
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class MyHashSet {
    vector<vector<bool>> storage;
    int buckets;
    int bucketItems;
    //Hash Function to get primary srray
    int getbucket(int key){
        return key%buckets;
    }
    //Hash Function to get secondary array
    int getbucketItem(int key){
        return key/bucketItems;
    }
public:
    /** Initialize your data structure here. */
    MyHashSet() {
        //0 <= key <= 10^6 so,intializing buckets size as root of 10^6 
        buckets=1000;//primary array size
        bucketItems=1000;//secondary array size
        storage.resize(buckets);
        //vector<vector<int>> storage(buckets);
        //storage=new bool[buckets];
    }
    void add(int key) {
        int bucket=getbucket(key);
        int bucketitem=getbucketItem(key);
        if(storage[bucket].empty()){
            if(bucket==0)
                //consider key=1000000
                //bucket=1000000%1000=0;
                //bucketitem=1000000/1000=1000,since the maximum size of bucketitem is 1000,
                //the index 1000 cannont be initialized.
                //to initialize this we increment the secondary array of 0th index to size 10001.
                //this allows the key 1000000 to be stored.
            {  
            storage[bucket]=vector<bool> (bucketItems+1);
            }
            storage[bucket]=vector<bool> (bucketItems);//if empty create secondary array
        }
        storage[bucket][bucketitem]= true;
    }
    void remove(int key) {
        int bucket=getbucket(key);
        int bucketitem=getbucketItem(key);
        if(storage[bucket].empty()) return;
        storage[bucket][bucketitem]=false;
    }
    /** Returns true if this set contains the specified element */
    bool contains(int key) {
        int bucket=getbucket(key);
        int bucketitem=getbucketItem(key);
        if(storage[bucket].empty()) return false;
        return storage[bucket][bucketitem];
    }
};
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */