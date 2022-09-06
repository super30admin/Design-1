class MyHashSet {

    // Insertion: O(1)
    // Deletion : O(1)
    // space complexity: O(1) for which traversal is not required and O(n) for traversal

    private class ListNode {
        private int key;
        private ListNode next;
        private ListNode prev;

        public ListNode (int key) {
            this.key = key;
            this.next = null;
            this.prev = null;
        } 
    }

    private ListNode head = null;
    private ListNode tail = null; 

    private HashMap<Integer, ListNode> map;

    public MyHashSet() {
        this.head = new ListNode(Integer.MIN_VALUE);
        this.tail = new ListNode(Integer.MAX_VALUE);
        this.head.next = tail;
        this.tail.prev = head;
        map = new HashMap<Integer, ListNode>();
    }

    private void addToTail(ListNode node) {
        node.next = tail;
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
    }

    private void removeFromLinkedList(ListNode node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}
    
    public void add(int key) {
        ListNode node = new ListNode(key);
		addToTail(node);
		map.put(key, node);
    }
    
    public void remove(int key) {
        if (map.containsKey(key)) {
			ListNode node = map.get(key);
			removeFromLinkedList(node);
            map.remove(key);
		}
    }
    
    public boolean contains(int key) {
        if(map.containsKey(key))
            return true;
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */