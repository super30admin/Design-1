class MyHashMap
{
public:
    int MAX = 1e6;
    int map[1001][1001];
    MyHashMap()
    {
        memset(map, -1, sizeof(map));
    }

    void put(int key, int value)
    {
        int fKey = getHashKey(key);
        int fIndex = getHashIndex(key);
        map[fKey][fIndex] = value;
    }

    int get(int key)
    {
        int fKey = getHashKey(key);
        int fIndex = getHashIndex(key);
        return map[fKey][fIndex];
    }

    void remove(int key)
    {
        int fKey = getHashKey(key);
        int fIndex = getHashIndex(key);
        map[fKey][fIndex] = -1;
    }
    int getHashKey(int key)
    {
        return key % 1000;
    }
    int getHashIndex(int key)
    {
        return key / 1000;
    }
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */