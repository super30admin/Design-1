package com.javadwarf.hashtable.leetcode;

public class _706_DesignHashMap {
	
	// space complexity O(n)
			// Time complexity 
			//put, remove  and get- Worst case o(n), average case O(1)

	private Node[] buckets;

	class Node{
		int key;
		int value;
		Node next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	public _706_DesignHashMap() {
		buckets = new Node[50000];
	}

	public int hashValue(int key) {
		return key % buckets.length;
	}

	/** value will always be non-negative. */
	public void put(int key, int value) {

		int index = hashValue(key);

		if(buckets[index] == null) {
			buckets[index] = new Node(-1,-1);
		}

		Node pos = findElement(key, buckets[index]);

		if(pos.next == null) {
			pos.next = new Node(key, value);
		}
		else {
			pos.next.value = value;
		}

	}

	/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	public int get(int key) {

		int index = hashValue(key);

		if(buckets[index] == null) {
			return -1;
		}

		Node pos = findElement(key, buckets[index]);

		if(pos.next == null) {
			return -1;
		}
		else {
			return pos.next.value;
		}

	}

	/** Removes the mapping of the specified value key if this map contains a mapping for the key */
	public void remove(int key) {

		int index = hashValue(key);

		if(buckets[index] == null) {
			return;
		}

		Node pos = findElement(key, buckets[index]);

		if(pos.next == null) {
			return;
		}
		else {
			pos.next = pos.next.next;
		}

	}

	public Node findElement(int key, Node head) {

		Node curr = head;
		Node prev = null;

		while(curr != null && curr.key != key) {
			prev = curr;
			curr = curr.next;
		}

		return prev;

	}

}
