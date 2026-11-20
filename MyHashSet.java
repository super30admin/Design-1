/* Time Complexity
add() - O(1)
remove() - O(1)
Contains() or search() - O(1)


Space Complexity
space O(1); because we are using the same space.

*/


class MyHashSet{
    private final int buckets;
    private final int bucketItems;
    private final boolean[][] storage;

    public MyHashSet(){
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }

    private int hash1(int key){
        return key % 1000;
    }

    private int hash2(int key){
        return key / 1000;
    }

    public void add(int key){
        int bucket = hash1(key);

        int bucketItem = hash2(key);
        if(storage[bucket] == null){

            if(bucket == 0){
                storage[bucket] = new boolean [bucketItems + 1];
            }else{
                storage[bucket] = new boolean [bucketItems];
            }
            
        }

        storage[bucket][bucketItem] = true;
    }

    public void remove(int key){
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null) return;

        storage[bucket][bucketItem] = false;
    }

    public boolean contains(int key){
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if(storage[bucket] == null) return false;

        return storage[bucket][bucketItem];
        
    }
}