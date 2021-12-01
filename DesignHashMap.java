/**
Time Complexity: O(n) where n is size of LinkedList in bucket in our code max it can go is 1000
Space Complexity(n * m) where n is buckets size and m is linkedList size

so here approach is that we have a prev of node and then we add remove around that
the find method is helper.
*/
class MyHashMap {

    class Node {
        int key, val;
        Node next;

        Node(int key, int value) {
            this. key = key;
            this.val = value;
        }
    }

    Node[] nodes;
    int buckets;

    public MyHashMap() {
        buckets = 1000;
        nodes = new Node[buckets];
    }

    private int getIndexOfKey(int key) {
        return key % buckets;
    }

    public Node find(Node node, int key) {
        int index = getIndexOfKey(key);
        Node prev = node;
        Node curr = node.next;

        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }

    public void put(int key, int value) {
        int index = getIndexOfKey(key);

        if (nodes[index] == null) {
            nodes[index] = new Node(-1, -1);
        }

        Node prev = find(nodes[index], key);

        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.val = value;
        }
    }

    public int get(int key) {
        int index = getIndexOfKey(key);

        if (nodes[index] == null) {
            return -1;
        }

        Node prev = find(nodes[index], key);

        if (prev.next == null) {
            return -1;
        } else {
            return prev.next.val;
        }
    }

    public void remove(int key) {
        int index = getIndexOfKey(key);

        if (nodes[index] == null) {
            return;
        }

        Node prev = find(nodes[index], key);

        if (prev.next == null) {
            return;
        } else {
            prev.next = prev.next.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */