import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class KeyValue<k, v> {

	public k keys;
	public v values;

	KeyValue(k keys, v values) {
		this.keys = keys;
		this.values = values;

	}
}

class Bucket {
	private List<KeyValue<Integer, Integer>> bucketList;

	Bucket() {
		this.bucketList = (List<KeyValue<Integer, Integer>>) new LinkedList();
	}

	public int get(Integer key) {
		for (KeyValue<Integer, Integer> pair : this.bucketList) {
			if (pair.keys.equals(key)) {
				return pair.values;
			}
		}

		return -1;

	}

	public void update(Integer key, Integer value) {
		boolean found = false;
		for (KeyValue<Integer, Integer> pair : this.bucketList) {
			if (pair.keys.equals(key)) {
				found = true;
				break;
			}
		}
		if (!found)
			this.bucketList.add(new KeyValue<Integer, Integer>(key, value));
	}

	public void remove(Integer key) {
		for (KeyValue<Integer, Integer> pair : this.bucketList) {
			if (pair.keys.equals(key)) {
				this.bucketList.remove(pair);
				break;
			}
		}
	}
}

class MyHashMap {
	private int k;
	private List<Bucket> hashTable; 
	/** Initialize your data structure here. */
	public MyHashMap() {
		this.k = 2003;
		this.hashTable = new ArrayList<Bucket>();
		for(int i = 0; i< this.k;i++) {
			this.hashTable.add(new Bucket());
			
		}

	}

	/** value will always be non-negative. */
	void put(int key, int value) {
		int hashFunc = key % this.k;
		this.hashTable.get(hashFunc).update(key, value);

	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	int get(int key) {
		int hashFunc = key % this.k;
		return this.hashTable.get(hashFunc).get(key);

	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	void remove(int key) {
		int hashFunc = key % this.k;
		this.hashTable.remove(hashFunc).remove(key);
	}
};

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap* obj
 * = new MyHashMap(); obj->put(key,value); int param_2 = obj->get(key);
 * obj->remove(key);
 */
