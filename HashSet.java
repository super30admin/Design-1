/***
 *  Time Complexity - O(1)
 *  Space Complexity - O(1)
*/
class MyHashSet {
    boolean[][] storage;
    int bucketSize;
    int bucketItems;

    public MyHashSet() {
        bucketSize = 1000;
        bucketItems = 1000;
        storage = new boolean[bucketSize][];
    }
    
    public int getBucketIndex(int key){
        return key % bucketSize;
    }
    
    public int getBucketItemsIndex(int key){
        return key / bucketSize;
    }
    
    public void add(int key) {
        int bucketIndex = getBucketIndex(key);
        int bucketItemIndex = getBucketItemsIndex(key);
        
        if(storage[bucketIndex] == null){
            if(bucketIndex == 0){
                storage[0] = new boolean[bucketItems+1];
            }else{
                storage[bucketIndex] = new boolean[bucketItems];
            }
        }
        
        storage[bucketIndex][bucketItemIndex] = true;
       
    }
    
    public void remove(int key) {
        int bucketIndex = getBucketIndex(key);
        int bucketItemIndex = getBucketItemsIndex(key);
        
        if(storage[bucketIndex] == null){
            return;
        }
        storage[bucketIndex][bucketItemIndex] =false;
    }
    
    public boolean contains(int key) {
        int bucketIndex = getBucketIndex(key);
        int bucketItemIndex = getBucketItemsIndex(key);
        
        if(storage[bucketIndex] == null){
            return false;
        }
        return storage[bucketIndex][bucketItemIndex];
    }


    public static void main(String[] args) {
        MyHashSet hash = new MyHashSet();

        hash.add(2);
        hash.add(3);
        hash.remove(3);
        System.out.println(hash.contains(3));
        System.out.println(hash.contains(2));

    }
}
