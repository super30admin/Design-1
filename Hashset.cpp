//Time complexity: O(n)
//Space complexity: O(n)
class MyHashSet {
public:
int bucket;
vector<list<int>> storage;

    MyHashSet() {
        bucket=1000;
        storage.resize(bucket);
    }
    int getBucket(int key) {
		return key % bucket;
	}
    list<int>::iterator search(int key) {
		int bucket = getBucket(key);
		return find(storage[bucket].begin(), storage[bucket].end(), key);
	}

    void add(int key) {
        int bucket = getBucket(key);
		if (!contains(key))
			storage[bucket].push_back(key);
    }
    
    void remove(int key) {
        int bucket = getBucket(key);
		auto it = search(key);
		if (it != storage[bucket].end())
			storage[bucket].erase(it);
    }
    
    bool contains(int key) {
        int bucket = getBucket(key);
		return search(key) != storage[bucket].end();
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */