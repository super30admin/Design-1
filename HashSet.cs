// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, debugged, found the issue and resolved it


// Your code here along with comments explaining your approach
// https://leetcode.com/problems/design-hashset/

public class MyHashSet
{

    bool[][] storage;
    int buckets;
    int bucketItems;

    public MyHashSet()
    {
        buckets = 1000;
        bucketItems = 1000;
        //creates 2d array
        storage = new bool[buckets][];
    }

    //1st hashing function to get bucket postion for horizontal array
    private int getBucket(int bucket)
    {
        return bucket % 1000;
    }

    //2nd hashing fnction to get position inside particular bucket (bucket Item) for vertical array
    private int getBucketItem(int bucketItem)
    {
        return bucketItem / 1000;
    }

    //O(1)
    //get positon for key to add and add at specific location inside bucket
    public void Add(int key)
    {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket] == null)
        {
            //this below condition is needed for special case 10^6, because 10^6%1000 = 0 and 10^6/1000 = 10000
            //in this case, it will save in first array 0 and second array of 10^3, which will cause overflow exception.
            if (bucket == 0)
                storage[bucket] = new bool[bucketItems + 1];
            else
                storage[bucket] = new bool[bucketItems];
        }
        storage[bucket][bucketItem] = true;
    }

    //O(1)
    //get bucket positon to remove key
    public void Remove(int key)
    {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket] == null)
            return;

        storage[bucket][bucketItem] = false;
    }

    //O(1)
    //get bucket item to check if it contains key
    public bool Contains(int key)
    {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket] == null)
            return false;

        return storage[bucket][bucketItem];
    }
}