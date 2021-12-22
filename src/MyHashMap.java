// Time Complexity :
//      push = O(1)
//      pop = O(1)
//      top = O(1)
//      getMin = O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes

class MyHashMap {
    class Pair{
        int key;
        int value;
        Pair(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }
    int buckets;
    int bucketItems;
    int storage[][];
    public MyHashMap() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new int[1000][];
    }

    private int bucket(int key)
    {
        return key%buckets;
    }
    private int bucketItem(int key)
    {
        return key/bucketItems;
    }
    public void put(int key, int value) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null)
        {
            if(bucket == 0)
            {
                storage[bucket] = new int[bucketItems+1];
            }
            else{
                storage[bucket] = new int[bucketItems];
            }
        }
        if(value == 0)
        {
            value = -2;
        }
        storage[bucket][bucketItem] = value;
    }

    public void remove(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null)
        {
            return ;
        }
        storage[bucket][bucketItem] = -1;

    }

    public int get(int key) {
        int bucket = bucket(key);
        int bucketItem = bucketItem(key);
        if(storage[bucket] == null )
        {
            return -1;
        }
        else if (storage[bucket][bucketItem] ==-2)
        {
            return 0;
        }
        else if (storage[bucket][bucketItem] == 0 )
        {
            return -1;
        }
        return storage[bucket][bucketItem] ;
    }



}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */