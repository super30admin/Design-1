package hashmap;

import java.util.LinkedList;
import java.util.List;

public class HashTable {
	// A hash table with each element having a linked list of buckets
	List<KVPair<Integer, Integer>> tableEntry;

	public HashTable() {
		super();
		this.tableEntry = new LinkedList<KVPair<Integer, Integer>>();
	}

	public int get(Integer key) {
		/*
		 * Check if the key is already present in the bucket. If it is, return the value
		 */
		for (KVPair<Integer, Integer> pair : this.tableEntry) {
			if (pair.key.equals(key)) {
				return pair.val;
			}
		}
		return -1;
	}

	public void put(Integer key, Integer val) {
		/*
		 * Check if the key is already present in the bucket. If it is, add one more
		 * value to the bucket. Else, Create a new bucket for the hash table entry
		 */
		for (KVPair<Integer, Integer> pair : this.tableEntry) {
			if (pair.key.equals(key)) {
				pair.val = val;
				return;
			}
		}
		this.tableEntry.add(new KVPair<Integer, Integer>(key, val));
	}

	public void remove(Integer key) {
		/*
		 * Check if the key is already present in the bucket. If it is, remove the value
		 */
		for (KVPair<Integer, Integer> pair : this.tableEntry) {
			if (pair.key.equals(key)) {
				this.tableEntry.remove(pair);
				break;
			}
		}
	}

	@Override
	public String toString() {
		if (this.tableEntry.isEmpty()) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for (KVPair<Integer, Integer> kvp : this.tableEntry) {
			sb.append(kvp.toString() + "\n");
		}
		return sb.toString();
	}

}
