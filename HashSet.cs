
namespace Algorithms
{
    /// Time Complexity : O(1)
    // Space Complexity :O(1)
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  Based on the discussion in class
    public class MyHashSet
    {
        bool[][] storage;
        int buckets;
        int bucketItems;

        public MyHashSet()
        {
            this.buckets = 1000;
            this.bucketItems = 1000;
            this.storage = new bool[buckets][];
            for (int i = 0; i < buckets; i++)
            {
                storage[i] = null;
            }
        }

        int getBucketIndex(int key)
        {
            return (key % buckets);
        }

        int getBucketItemIndex(int key)
        {
            return (key / bucketItems);
        }

        public void Add(int key)
        {
            int bucketIndex = getBucketIndex(key);
            int bucketItemIndex = getBucketItemIndex(key);
            if(storage[bucketIndex] == null)
            {
                if(bucketIndex == 0)
                {
                    this.storage[bucketIndex] = new bool[bucketItems + 1];
                }
                else
                {
                    this.storage[bucketIndex] = new bool[bucketItems];
                }
            }
            this.storage[bucketIndex][bucketItemIndex] = true;
        }

        public void Remove(int key)
        {
            int bucketIndex = getBucketIndex(key);
            int bucketItemIndex = getBucketItemIndex(key);

            if (this.storage[bucketIndex] == null) return;
            this.storage[bucketIndex][bucketItemIndex] = false;
        }

        public bool Contains(int key)
        {
            int bucketIndex = getBucketIndex(key);
            int bucketItemIndex = getBucketItemIndex(key);
            if (this.storage[bucketIndex] == null) return false;
            return this.storage[bucketIndex][bucketItemIndex];
        }

        
    }
}
