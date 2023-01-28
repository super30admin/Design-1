//Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* we are using double hashing to achieve o(1) complexity and avoid collision
 * we create a storage boolean array with only primary array initialization with length as square root of n.
 * secondary array will be initialized when ever it is required, to save storage space. 
 */

class MyHashSet {

	boolean[][] storage;
	int primaryArrayLength;
	int secondaryArrayLength;

	public MyHashSet() {
		this.primaryArrayLength = 1000;
		this.secondaryArrayLength = 1000;
		this.storage = new boolean[primaryArrayLength][];
	}

	private int hash1(int key) {
		return key % primaryArrayLength;
	}

	private int hash2(int key) {
		return key / secondaryArrayLength;
	}

	public void add(int key) {
		int h1 = hash1(key);
		int h2 = hash2(key);

		if (null == storage[h1]) {
			if (h1 == 0) {
				storage[h1] = new boolean[secondaryArrayLength + 1];
			} else {
				storage[h1] = new boolean[secondaryArrayLength];
			}

		}
		storage[h1][h2] = true;
	}

	public void remove(int key) {
		int h1 = hash1(key);
		int h2 = hash2(key);
		if (null == storage[h1])
			return;
		storage[h1][h2] = false;
	}

	public boolean contains(int key) {
		int h1 = hash1(key);
		int h2 = hash2(key);
		if (null == storage[h1])
			return false;
		return storage[h1][h2];
	}
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */
