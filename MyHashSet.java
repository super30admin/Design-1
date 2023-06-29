/*Time Complexity :
        add():O(1)
        remove():O(1)
        containsKey():O(1)
        Space Complexity:O(1)
 */
class MyHashSet {

    int buckets=1000;//primary array
    int bucketItems=1000;//nested array
    boolean[][] storage;

    private int hashFunction1(int key)
    {
        return key%1000;
    }
    private int hashFunction2(int key)
    {
        return key/1000;
    }

    public MyHashSet() {

        storage=new boolean[buckets][];

    }

    public void add(int key) {

        //get hash value for key using hash function 1
        int bucket=hashFunction1(key);
        //if no nested array for bucket
        if(storage[bucket]==null)
        {
            //handling edge case
            if(bucket==0)
            {
                storage[bucket]=new boolean[bucketItems+1];
            }
            else
            {
                storage[bucket]=new boolean[bucketItems];
            }
        }
        //get hash value for key using hash function 2
        int bucketItem=hashFunction2(key);
        //extreme case
        storage[bucket][bucketItem]=true;
    }

    public void remove(int key) {
        int bucket=hashFunction1(key);
        if(storage[bucket]!=null)
        {
            int bucketItem=hashFunction2(key);
            //when you remove key,set the value to false
            storage[bucket][bucketItem]=false;
        }

    }

    public boolean contains(int key) {
        int bucket=hashFunction1(key);
        //if no nested array,then key is not present
        if(storage[bucket]==null)
        {
            return false;
        }
        else
        {
            int bucketItem=hashFunction2(key);
            return storage[bucket][bucketItem];

        }
    }

}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */