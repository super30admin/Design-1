// Here I have implemented LinkedList based chaining approach to handle the collisions

public class HashMap2 {

    private class Node {
        private int key, val;
        private Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node[] nodes;

    public HashMap2() {
        nodes = new Node[1000];
    }

    public void put(int key, int value) {
        int index = key % nodes.length;
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
        int index = key % nodes.length;
        if (nodes[index] == null) {
            return -1;
        }
        Node prev = find(nodes[index], key);
        return prev.next == null ? -1 : prev.next.val;
    }

    public void remove(int key) {
        int index = key % nodes.length;
        if (nodes[index] == null) {
            return;
        }
        Node prev = find(nodes[index], key);
        if (prev.next == null) {
            return;
        }
        prev.next = prev.next.next;
    }

    private Node find(Node bucket, int key) {
        Node node = bucket, prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }

    public static void main(String[] args) {
        HashMap2 hm = new HashMap2();
        hm.put(12, 144);
        hm.put(2, 4);
        hm.put(10, 100);

        System.out.println(hm.get(3));
        System.out.println(hm.get(12));

        hm.remove(2);
        System.out.println(hm.get(2));
    }
}
