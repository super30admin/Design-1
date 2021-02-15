/*
Time Complexity : For each of the 3 operations the time complexity is O(N/size)
Space Complexity : O(N)
Did this code successfully run on Leetcode :Yes

Logic: 
Here we are making use of Chaining for handling the collisions. The map has 10,000 buckets and the keys are
matched into one of the bucket by using (key%10000).The put,get and delete operation is then done on this bucket as we are sure
that the element would belong to this bucket.

Any problem you faced while coding this :
Initially I was using this vector<pair<int, int>> row = map[index] to find the row/bucket and then
iterate over it without the use of pointers. But then row is just a pointer to the first element of the bucket and it does not store all the elements
in that row. So either you could use pointers to iterate or you can get rid of assigning this variable and use
map[index] where ever it is required.
*/







class MyHashMap {
	vector<vector<pair<int, int>>> map;
	const int size = 10000;
public:
	/** Initialize your data structure here. */
	MyHashMap() {
		map.resize(size);
	}

	/** value will always be non-negative. */
	void put(int key, int value) {
		int index = key % size;
        // vector<pair<int, int>> row = map[index];
        for(int i = 0; i < map[index].size();i++)
        {
            if(map[index][i].first == key)
            {
                map[index][i].second = value;
                return;
            }
        }
		map[index].push_back(make_pair(key, value));
	}

	/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	int get(int key) {
		int index = key % size;
        // vector<pair<int, int>> row = map[index];
		for (int i = 0; i < map[index].size();i++)
		{
			if (map[index][i].first == key)
			{
				return map[index][i].second;
			}
		}
		return -1;
	}

	/** Removes the mapping of the specified value key if this map contains a mapping for the key */
	void remove(int key) {
		int index = key % size;
        // vector<pair<int, int>> row = map[index];
		for (int i = 0; i < map[index].size();i++)
		{
			if (map[index][i].first == key)
			{
				map[index].erase(map[index].begin() + i);
                return;
			}
		}
	}
};

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */