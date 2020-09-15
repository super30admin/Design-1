class MyHashMap {
    Node [] newNode = new Node[10000];
	
	class Node {
		Node next;
		int key;
		int value;

		public Node (int key, int value) {
			this.key = key;
			this.value = value;

		}
}

    private int FindIndex(int key) {
        return Integer.hashCode(key) % newNode.length;
    }

    private Node find (Node head, int key) {
        Node current = head;
        Node previous = null;

        while (current != null && current.key != key) {
            previous = current;
            current = current.next;
        }

        return previous;
    }

    public void remove(int key) {
        int i = FindIndex(key);

        if (newNode[i] == null) return;

        Node prev = find (newNode[i],key);

        if (prev.next == null) {
            return;
        }

        prev.next = prev.next.next;
    }


    public void put(int key, int value) {
        int IndexValue = FindIndex(key);

        if (newNode[IndexValue] == null) {
            newNode[IndexValue] = new Node (-1,-1);
        }

        Node prev = find (newNode[IndexValue], key);

        if (prev.next == null) {
            prev.next = new Node (key,value);
        }

        else {
            prev.next.value = value;
        }
    }


    public int get(int key) {
        int i = FindIndex(key);

        if (newNode[i] == null) return -1;

        Node prev = find (newNode[i], key);

        if (prev.next == null) {
            return -1;
        }

        else {
            return prev.next.value;
        }
    }
	
	public MyHashMap() {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 2);
        hashMap.put(2, 3);
        System.out.println(hashMap.get(1));            // returns 2
        System.out.println(hashMap.get(3));            // returns -1 (not found)
        hashMap.put(2, 4);          // update the existing value
        System.out.println(hashMap.get(2));            // returns 4
        hashMap.remove(2);          // remove the mapping for 2
        System.out.println(hashMap.get(2));            // returns -1 (not found)
    }

}