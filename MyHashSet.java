// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet
{
    boolean hashSet[][];

    public int bucketKey(int key)
    {
        return key%1000;
    }
    public int bucketItemKey(int key)
    {
        return key/1000;
    }
    public MyHashSet()
    {
        hashSet = new boolean[1000][];
    }

    public void add(int key)
    {
        int bucketKey = bucketKey(key);
        if (bucketKey == 0) {
            if (hashSet[bucketKey] == null)
                hashSet[bucketKey] = new boolean[1001];
        }
        else {
            if (hashSet[bucketKey] == null)
                hashSet[bucketKey] = new boolean[1000];
        }

        int bucketItemKey = bucketItemKey(key);
        hashSet[bucketKey][bucketItemKey] = true;
    }

    public void remove(int key)
    {
        int bucketKey = bucketKey(key);
        if (hashSet[bucketKey] == null)
            return;

        int bucketItemKey = bucketItemKey(key);
        hashSet[bucketKey][bucketItemKey] = false;
    }

    public boolean contains(int key) {
        int bucketKey = bucketKey(key);
        if (hashSet[bucketKey] == null)
            return false;

        int bucketItemKey = bucketItemKey(key);
        return hashSet[bucketKey][bucketItemKey];
    }

}
