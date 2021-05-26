// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes, Did not handled remove method case to make bucket empty if all elements removed. Fixed it later


// Your code here along with comments explaining your approach
/**
 * 1. Define a Node to maintain a linked list in each bucket .
 * 2. Define bucketsize as a prime number to reduce the hash collision. We may need to increase or decrease basedo nperformance.
 * 3. Put:Check bucket first element in bucket. if it is null add new node to bucket. Otherwise find and update if exist, if not exist add it as last node in the linked list.
 * 4. get:Check bucket first element in bucket. if it is null return -1.Otherwise find and return value if exist, if not exist return -1.
 * 5. remove:Check bucket first element in bucket. if it is null return.Otherwise find and link last node next as removed element next if exist, if not exist return.   
 *
 */
class MyHashMap {

	private final int bucketSize = 1999;
	private Node[] dataArr;

	class Node {
		private int key;
		private int value;

		private Node nextNode;

		private Node(int key, int value) {
			this.key = key;
			this.value = value;
			this.nextNode = null;
		}
	}

	/** Initialize your data structure here. */
	public MyHashMap() {
		dataArr = new Node[bucketSize];
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		Node firstNode = dataArr[key % bucketSize];

		// if bucket is empty create new node in the bucket
		if (firstNode == null) {
			dataArr[key % bucketSize] = new Node(key, value);
		} else {
			// traverse all the nodes in bucket. If key found replace value
			Node previousNode = null;
			while (firstNode != null) {
				if (firstNode.key == key) {
					firstNode.value = value;
					return;
				}
				previousNode = firstNode;
				firstNode = firstNode.nextNode;
			}

			// if key not found create a new node and add it to bucket last node
			Node newNode = new Node(key, value);
			previousNode.nextNode = newNode;

		}
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		Node firstNode = dataArr[key % bucketSize];
		if (firstNode != null) {
			while (firstNode != null) {
				if (firstNode.key == key) {
					return firstNode.value;
				}
				firstNode = firstNode.nextNode;
			}
		}
		return -1;
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {
		Node firstNode = dataArr[key % bucketSize];
		if (firstNode != null) {

			if (firstNode.key == key) {
				dataArr[key % bucketSize] = firstNode.nextNode;
				return;
			}

			Node previousNode = null;
			while (firstNode != null) {
				if (firstNode.key == key) {
					previousNode.nextNode = firstNode.nextNode;
					return;
				}
				previousNode = firstNode;
				firstNode = firstNode.nextNode;
			}
		}

	}
}

public class MyHashMapMain {
	public static void main(String[] args) {
		MyHashMap hashMap = new MyHashMap();

		hashMap.put(1, 2);

		hashMap.put(2, 3);

		System.out.println(hashMap.get(1)); // returns 2

		System.out.println(hashMap.get(3)); // returns -1 (not found)

		hashMap.put(2, 4); // update the existing value

		System.out.println(hashMap.get(2)); // returns 4

		hashMap.remove(2); // remove the mapping for 2

		System.out.println(hashMap.get(2)); // returns -1 (not found)

	}
}
/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */