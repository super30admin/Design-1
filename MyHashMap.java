// Time Complexity : Avg - O(1) worse -O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class MyHashMap {

	ListNode[] nodes;
	
	public static void main (String args[]) {
		MyHashMap hashMap = new MyHashMap();
		hashMap.put(1, 2);          
		hashMap.put(2, 3);         
		hashMap.get(1);            // returns 2
		hashMap.get(3);            // returns -1 (not found)
		hashMap.put(2, 4);          // update the existing value
		hashMap.get(2);            // returns 4 
		hashMap.remove(2);          // remove the mapping for 2
		hashMap.get(2);            // returns -1 (not found)
	}
	
    /** Initialize your data structure here. */
    public MyHashMap() {
		nodes = new ListNode[10000];
    }
    
	private int getIndex(int key) {
		return Integer.hashCode(key) % nodes.length;
	}

	private ListNode findElement(int index, int key) {
		if (nodes[index] == null)
			return nodes[index] = new ListNode(-1, -1);

		ListNode prev = nodes[index];

		while (prev.next != null && prev.next.key != key) {
			prev = prev.next;
		}
		return prev;
	}

	private static class ListNode {
		int key, val;
		ListNode next;

		ListNode(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	public int get(int key) {
		int index = getIndex(key);
		ListNode prev = findElement(index, key);
		return prev.next == null ? -1 : prev.next.val;
	}

	public void put(int key, int value) {
		int index = getIndex(key);
		ListNode prev = findElement(index, key);

		if (prev.next == null)
			prev.next = new ListNode(key, value);
		else
			prev.next.val = value;
	}

	public void remove(int key) {
		int index = getIndex(key);
		ListNode prev = findElement(index, key);

		if (prev.next != null)
			prev.next = prev.next.next;
	}

}