//Implementing Hashmap with linear chaining

// Time Complexity :  O(100) because primary array is of size 10000 and we have constraint of 10^6 . So we have amortized complexity.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// CODE:

class MyHashMap {
    class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node[] nodes; // creating primary array storage
    private int buckets; // size of nodes[] array

    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];

    }

    private int hash(int key) {
        // return Integer.hashCode(key)%buckets; ->inbuilt way for hash function
        return key % buckets; // making hash function
    }

    public Node find(Node head, int key) {
        Node prev = null; // taking a dummy node
        Node curr = head;
        while (curr != null && curr.key != key) { // traversing through all the nodes to find the key
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    public void put(int key, int value) {
        int index = hash(key); // finding index of the key and checking if that element is there in hashmap
        if (nodes[index] == null) { /// if at that index there is no value ,then we will make a dummy node with key
                                    /// and value -1
            nodes[index] = new Node(-1, -1);
        }
        Node prev = find(nodes[index], key);
        if (prev.next == null) { // if prev is at the end of linkedlist , then we will create a new node an add
                                 // key, value in that node
            prev.next = new Node(key, value);
        } else {
            prev.next.val = value; // else if prev is not at the of linkedlist , then we will update the value of
                                   // that key in the node
        }
    }

    public int get(int key) {
        int index = hash(key);
        if (nodes[index] == null) { // checking if that element exists or not and if does not exists then return -1
            return -1;
        }
        Node prev = find(nodes[index], key);
        if (prev.next == null) // if prev reaches at end of the linkedlist then the element is not present
            return -1;
        else
            return prev.next.val; // else if prev is somewhere in between the linkedlist then retrun the value of
                                  // prev.next node i.e returning the value of curr node
    }

    public void remove(int key) {
        int index = hash(key);
        if (nodes[index] == null) { // checking whether that element exisits or not
            return;
        }
        Node prev = find(nodes[index], key);
        if (prev.next == null) // if prev reaches at end of the linkedlist then the element is not present so
                               // there is nothing to be removed
            return;
        else
            prev.next = prev.next.next; // else if prev is somewhere in between the linkedlist then linking prev.next
                                        // with its next node
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */