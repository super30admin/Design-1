class MyHashMap {
    class Node{
        int key, value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    Node[] nodes;
    int buckets;

    private int getHash(int key) {
        return Integer.hashCode(key) % buckets;
    }
    private Node find(Node node, int key) {
        Node previous = node;
        Node current = node.next;
        while(current != null && previous.next.key != key) {
            previous = current;
            current = current.next;
        }
        return previous;
    }

    public MyHashMap() {
        buckets = 1000;
        nodes = new Node[buckets];
    }

    public void put(int key, int value) {
        int index = getHash(key);
        if(nodes[index] == null){
            nodes[index] = new Node(-1,-1);
        }
        Node previous = find(nodes[index],key);
        if(previous.next == null){
            previous.next = new Node(key, value);
        }
        else{
            previous.next.value = value;
        }
    }

    public int get(int key) {
        int index = getHash(key);
        if(nodes[index] == null){
            return -1;
        }
        Node previous = find(nodes[index], key);
        if(previous.next == null){
            return -1;
        }
        else{
            return previous.next.value;
        }
    }

    public void remove(int key) {
        int index = getHash(key);
        if(nodes[index] == null){
            return;
        }
        Node previous = find(nodes[index], key);
        if(previous.next == null){
            return;
        }
        else{
            previous.next = previous.next.next;
        }
    }
}
