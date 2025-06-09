public class MyHashSet {
    //boolean array of arrays for storing value for hashset
    private boolean[][] storage;
    public MyHashSet{
        storage=new boolean[1000][];
    }

    public int getBucket(int key){
        return key%1000;
    }

    public int getBucketValue(int key){
        return key/1000;
    }
    //Time complexity : O(1) , Space complexity: O(1)
    public void add(int key){
        int bucket=getBucket(key);
        if(storage[bucket]==null){
            if(bucket==0){
                storage[bucket]=new boolean[1001];
            }else{
                storage[bucket]=new boolean[1000];
            }
        }
        int bucketValue=getBucketValue(key);
        storage[bucket][bucketValue]=true;
    }
    //Time complexity : O(1) , Space complexity: O(1)
    public void remove(int key){
        int bucket=getBucket(key);
        if(storage[bucket]!=null){
            int bucketValue=getBucketValue(key);
            storage[bucket][bucketValue]=false;
        }
    }
    //Time complexity : O(1) , Space complexity: O(1)
    public boolean contains(int key){
        int bucket=getBucket(key);
        if(storage[bucket]!=null){
            int bucketValue=getBucketValue(key);
            return storage[bucket][bucketValue];
        }
        return fasle;
    }
}