class MyHashMap {

    final Node[] nodes = new Node[10000];

    class Node {
        int key;
        int value;
        Node next;


        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }


    public MyHashMap() {}

    public void put(int key, int value) {

        int index = key % nodes.length;

        Node entry = new Node(key, value);

        if (nodes[index] == null) {
            nodes[index] = new Node(-1, -1);
            nodes[index].next = new Node(key, value);
        } else {
            Node prev = find(index, key);
            if ( prev.next != null) {
                prev.next.value = value;
            } else {
                prev.next = new Node(key, value);
            }
        }

        System.out.print(nodes[index].next.value);

    }


    public Node find(int bucket, int key) {

        Node node = nodes[bucket];
        Node prev = null;

        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }

        return prev;
    }


    public int get(int key) {
        int index = key % nodes.length;

        if(nodes[index] == null) {
            return -1;
        }


        Node prev = find(index, key);

        if ( prev.next == null) {
            return -1 ;
        }

        return prev.next.value;
    }

    public void remove(int key) {

        int index = key % nodes.length;

        Node prev = find(index , key);

        if (prev == null || prev.next == null) {
            return;
        }

        prev.next = prev.next.next;
    }
}


// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no



/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
