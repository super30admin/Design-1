//time o(n)
//space o(1)
class MyHashMap {

    class Node{
         Node next;
        int key;
        int value;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    /** Initialize your data structure here. */
    Node[] nodes;
    public MyHashMap() {
        nodes = new Node[10000];
    }
    
    private int findIdx(int key) {
        return Integer.hashCode(key) % 10000;
    }
    
    private Node find(Node head, int key) {
        Node cur = head;
        Node prev = null;
        while(cur != null && cur.key != key) {
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = findIdx(key);
        if(nodes[idx] == null) {
            nodes[idx] = new Node(-1,-1);
        }
        Node prev = find(nodes[idx], key);
        if(prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = findIdx(key);
        if(nodes[idx] == null) {
            return -1;
        }
        Node prev = find(nodes[idx], key);
        if(prev.next == null) {
            return -1;
        }
        return prev.next.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = findIdx(key);
        if(nodes[idx] == null) {
            return;
        }
        Node prev = find(nodes[idx], key);
        if(prev.next != null) {
            prev.next = prev.next.next;
        }
    }
    public static void main(String[] args)
    {
        MyHashMap HM = new MyHashMap();
        HM.put(1,5);HM.put(2,10);HM.put(3,15);HM.put(4,20);
        System.out.println("For key 2  "+HM.get(2));
        HM.put(2,300);
        System.out.println("For key 2  "+HM.get(2));
        HM.remove(2);
        System.out.println("For key 2  "+HM.get(2));
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */