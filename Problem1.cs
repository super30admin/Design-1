// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Since the total number of keys can be up to 10^6, I am using an array of arrays of boolean type with the primary array being of size 1000
// and the secondary array being of size 1000. I am following the double hashing based approach so that we can perform Add, Contains and Remove
// in O(1) time complexity.

public class MyHashSet
{

    private bool[][] buckets;
    private int bucketSize;
    private int bucketCount;

    public MyHashSet()
    {
        bucketSize = 1000;
        bucketCount = 1000;
        buckets = new bool[bucketCount][];
    }

    private int HashFunction1(int key)
    {
        return key % bucketCount;
    }

    private int HashFunction2(int key)
    {
        return key / bucketSize;
    }

    public void Add(int key)
    {
        int hash1 = HashFunction1(key);

        if (buckets[hash1] == null)
        {
            if (hash1 == 0)
            {
                buckets[hash1] = new bool[bucketSize + 1];
            }

            else
            {
                buckets[hash1] = new bool[bucketSize];
            }
        }

        int hash2 = HashFunction2(key);

        buckets[hash1][hash2] = true;
    }

    public void Remove(int key)
    {
        int hash1 = HashFunction1(key);

        if (buckets[hash1] != null)
        {
            int hash2 = HashFunction2(key);

            buckets[hash1][hash2] = false;
        }
    }

    public bool Contains(int key)
    {
        int hash1 = HashFunction1(key);
        int hash2 = HashFunction2(key);

        return buckets[hash1] != null && buckets[hash1][hash2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.Add(key);
 * obj.Remove(key);
 * bool param_3 = obj.Contains(key);
 */