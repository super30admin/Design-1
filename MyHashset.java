//Time Complexity:O(1)
//Space Complexity:O(n)

public class MyHashset {
    boolean storage[][];
    int bucket;
    int bucketItem;
    public MyHashset() {
        bucket=1000;
        bucketItem=1000;
        storage=new boolean[bucket][];
        
    }
    public int buckets(int key){
        return key%bucket;
    }
    
    public int bucketItems(int key){
        return key/bucketItem;
    }
    
    public void add(int key) {
        int buckets=buckets(key);
        int bucketItems=bucketItems(key);
        if(storage[buckets]==null){
            if(buckets==0){
                storage[buckets]=new boolean[bucketItem+1];
            }else{
                storage[buckets]=new boolean[bucketItem];
            }
        }
        storage[buckets][bucketItems]=true;
    }
    
    public void remove(int key) {
        int buckets=buckets(key);
        int bucketItems=bucketItems(key);
        if(storage[buckets]==null){
            return;
        }
        storage[buckets][bucketItems]=false;
    }
    
    public boolean contains(int key) {
        int buckets=buckets(key);
        int bucketItems=bucketItems(key);
        if(storage[buckets]==null){
            return false;
        }
        return storage[buckets][bucketItems];
    }
}
