/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap* obj = new MyHashMap();
 * obj->put(key,value);
 * int param_2 = obj->get(key);
 * obj->remove(key);
 */
class MyHashMap {
public:
    /** Initialize your data structure here. */
    	vector < list<pair<int, int>>>new_hash_map;
	    int size = 2069;
public:
	/** Initialize your data structure here. */
	MyHashMap() {
		new_hash_map.resize(size);
	}

	/** value will always be non-negative. */
	void put(int key, int value) {
		list<pair<int, int>>& m = new_hash_map[key % size];
		for (auto it = m.begin(); it != m.end(); it++) {
			if (it->first == key) {
				it->second = value;
				return;
			}
		}
		m.push_back({ key,value });
		
	}

	/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	int get(int key) {
		list<pair<int, int>>& m = new_hash_map[key % size];
		for (auto it = m.begin(); it != m.end(); it++) {
			if (it->first == key)
				return it->second;
		}
		return -1;
	}

	/** Removes the mapping of the specified value key if this map contains a mapping for the key */
	void remove(int key) {
		list<pair<int, int>>& m = new_hash_map[key % size];
		for (auto it = m.begin(); it != m.end(); it++) {
			if (it->first == key) {
				m.erase(it);//to remove
				return;
			}
		}
	}
    
};