using System;

/// <summary>
/// Summary description for Class1
/// </summary>
public class MyHashMap
{
    int[][] buckets;
    int _buckets = 1000;
    int _bucketItems = 1000;

    public MyHashMap()
    {
        buckets = new int[_buckets][];
    }

    public int GetBucket(int key)
    {
        return key % _buckets;
    }

    public int GetBucketItem(int key)
    {
        return key % _bucketItems;
    }

    public void Put(int key, int value)
    {
        int bucket = GetBucket(key);
        int bucketItem = GetBucketItem(key);

        if (buckets[bucket] == null)
        {
            if (bucket == 0)
            {
                buckets[bucket] = new int[_bucketItems + 1];
            }
            else
            {
                buckets[bucket] = new int[_bucketItems];

            }
            Array.Fill(buckets[bucket], -1);
        }

        buckets[bucket][bucketItem] = value;

    }

    public int Get(int key)
    {
        int bucket = GetBucket(key);
        int bucketItem = GetBucketItem(key);

        if (buckets[bucket] == null)
        {
            return -1;
        }

        return buckets[bucket][bucketItem];
    }

    public void Remove(int key)
    {
        int bucket = GetBucket(key);
        int bucketItem = GetBucketItem(key);

        if (buckets[bucket] == null)
        {
            return;
        }

        buckets[bucket][bucketItem] = -1;

    }
}
