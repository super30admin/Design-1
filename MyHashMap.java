class MyHashMap {

    class Node
    {
        int key;
        int val;
        Node next;

        public Node(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }

    private Node[] storage; //primary array contaning pointers to linked list used for linear chaining
    private int buckets; //size of primary storage

    public MyHashMap() {
        buckets = 10000;
        storage = new Node[buckets];
    }

    //calculate hash code based on key, this gives us an index in the storage array
    public int hash(int key)
    {
        return key%buckets;
    }

    //finds the key we want given the head (-1 for all linked list) and key we want
    public Node searchKey(Node head, int key)
    {
        Node prev = null;
        Node curr = head;
        //each LL has a dummy node (val=-1) so that we don't have to handle LL edge cases like 1 node only
        //actual node start after this head node

        while(curr != null && curr.key != key)
        {
            prev = curr;
            curr = curr.next;
        }

        return prev;
        //will be null if node not found
    }

    public void put(int key, int value) {

        int index = hash(key);

        //no LL on this index yet, create the dummy node
        if(storage[index] == null)
            storage[index] = new Node(-1,-1);

        Node prev = searchKey(storage[index], key);

        // no key was found, create the key, value pair
        if(prev.next==null)
            prev.next = new Node(key, value);
        else //key alread there, update value
            prev.next.val = value;
    }

    public int get(int key) {

        int index = hash(key);

        //no LL on this index yet
        if(storage[index] == null)
            return -1;

        Node prev = searchKey(storage[index], key);

        // no key was found
        if(prev.next==null)
            return -1;
        else //key found;
            return prev.next.val;
    }

    public void remove(int key) {

        int index = hash(key);

        //no LL on this index, nothing to remove
        if(storage[index]==null)
            return;

        Node prev = searchKey(storage[index], key);

         // no key was found, nothing to remove
        if(prev.next==null)
            return;
        else //key found, remove this node
            prev.next = prev.next.next;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
