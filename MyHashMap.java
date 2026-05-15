//Design a Hash Map
//Time Complexity : Amortized O(1)
//Space Complexity : O(n)

class MyHashMap {

    Node[] map;
    int buckets;

    private static class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public MyHashMap() {
        this.buckets = 1000;
        map = new Node[buckets];
    }

    private Node getPrevious(Node head, int key) {
        Node prev = null;
        Node curr = head;

        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        Node curr = new Node(key, value);
        int index = key % buckets;
        if(map[index] == null) {
            map[index] = new Node(-1,-1);
            map[index].next = curr;
        }
        else {
            Node prev = getPrevious(map[index], key);
            if(prev.next == null) {
                prev.next = curr;
            } else {
                prev.next.val = value;
            }
        }
    }

    public int get(int key) {
        int index = key % buckets;
        if(map[index] == null)
            return -1;
        Node prev = getPrevious(map[index], key);
        if(prev.next == null)
            return -1;
        return prev.next.val;
    }

    public void remove(int key) {
        int index = key % buckets;
        if(map[index] == null)
            return;
        Node prev = getPrevious(map[index], key);
        if(prev.next == null) return;
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
    }
}
