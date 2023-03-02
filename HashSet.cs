public class MyHashSet
{
    int size = 1000;
    bool[][] storage;
    private int bucket;
    private int bucketItems;

    public MyHashSet()
    {
        this.bucket = size;
        this.bucketItems = size;
        this.storage = new bool[size][];
    }

    public int hashFunction1(int key)
    {
        return key % size;
    }

    public int hashFunction2(int key)
    {
        return key / size;
    }
    public void Add(int key)
    {
        int index1 = hashFunction1(key);
        int index2 = hashFunction2(key);
        if (storage[index1] == null)
        {
            if (index1 == 0)
            {
                storage[index1] = new bool[bucketItems + 1];
            }
            else
            {
                storage[index1] = new bool[bucketItems];
            }
        }
        storage[index1][index2] = true;

    }

    public void Remove(int key)
    {
        int index1 = hashFunction1(key);
        int index2 = hashFunction2(key);
        if (storage[index1] == null) return;
        storage[index1][index2] = false;

    }

    public bool Contains(int key)
    {
        int index1 = hashFunction1(key);
        int index2 = hashFunction2(key);
        if (storage[index1] == null) return false;
        return storage[index1][index2];

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.Add(key);
 * obj.Remove(key);
 * bool param_3 = obj.Contains(key);
 */