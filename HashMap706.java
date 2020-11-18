package nov162020;

public class HashMap706 {

	public static void main(String[] args) {

	}

	/** Initialize your data structure here. */
	private static class node {
		int key, value;
		node next;

		node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	node head[] = new node[10000];

	public HashMap706() {

	}

	/** value will always be non-negative. */
	public void put(int key, int value) {
		int index = key % head.length;
		if (head[index] == null) {
			head[index] = new node(key, value);
			return;
		} else {
			node curr = head[index];
			if (curr.key == key) {
				curr.value = value;
				return;
			}
			while (curr.next != null) {
				if (curr.next.key == key) {
					curr.next.value = value;
					return;
				}
				curr = curr.next;
			}
			curr.next = new node(key, value);
		}
	}

	/**
	 * Returns the value to which the specified key is mapped, or -1 if this map
	 * contains no mapping for the key
	 */
	public int get(int key) {
		int index = key % head.length;
		if (head[index] == null)
			return -1;
		else {
			node curr = head[index];
			while (curr != null) {
				if (curr.key == key)
					return curr.value;
				curr = curr.next;
			}

		}
		return -1;
	}

	/**
	 * Removes the mapping of the specified value key if this map contains a mapping
	 * for the key
	 */
	public void remove(int key) {
		int index = key % head.length;
		if (head[index] == null)
			return;
		if (head[index].key == key) {
			head[index] = head[index].next;
		}
		node curr = head[index], prev = head[index];
		while (curr != null) {
			if (curr.key == key) {
				prev.next = curr.next;
				return;
			}
			prev = curr;
			curr = curr.next;
		}
	}

}
