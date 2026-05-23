class MyHashSet {
    Node[] storage;
    int buckets;

    class Node {
        int key;
        Node next;

        public Node(int key) {
            this.key = key;
        }
    }

    public MyHashSet() {
        this.buckets = 1000;
        this.storage = new Node[buckets];
    }

    private int getHash(int key){
        return key % buckets;
    }

    private Node getPrev(Node head, int key){
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }
    

    public void add(int key) {
        int index = getHash(key);
        if(storage[index] == null){
            storage[index] = new Node(-1);
            storage[index].next = new Node(key);
            return;
        }

        Node prev = getPrev(storage[index], key);
        if(prev.next == null){ 
            prev.next = new Node(key);
        }
    }

    public void remove(int key) {
        int index = getHash(key);
        if(storage[index] == null) return;
        Node prev = getPrev(storage[index], key);
        if(prev.next == null) return;
        Node curr = prev.next;
        prev.next = curr.next;
        curr.next = null;
    }

    public boolean contains(int key) {
        int index = getHash(key);
        if(storage[index] == null) return false;
        Node prev = getPrev(storage[index], key);
        if(prev.next == null) return false;
        return true;
    }
}
