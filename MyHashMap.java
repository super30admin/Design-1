//Ran successfully
class MyHashMap {
    //HashMap implemenatation using separate chaining method
    /*
        TC:
            put, get, remove - O(n) where n is the size of the linked list at a node which would be equal to O(max input range/array of nodes size)
        SC: O(array of nodes size + input element size)
    */
    //Array of nodes as primary, linked list of nodes as secondary
    /** Initialize your data structure here. */
    class node //node structure creation
    {
        int key,value;
        node next;
        public node(int key,int val)
        {
            this.key = key;
            this.value= val;
        }
    }
    node[] nodes; // array of node objects
    int size;
    public MyHashMap() {
        size=1000;
        nodes = new node[size];
    }
    //hashing function
    private int getHashCode(int key) 
    {
        return Integer.hashCode(key) % size;
    }
    private node find(node head,int key) // to find the previous node
    {
        node prev = null;
        node cur = head;
        while(cur!=null && cur.key != key)
        {
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }
    /** value will always be non-negative. */
    //find hash value using the hashing function. check if there is a node in the index, if not, create a dummy node and add the given node by finding the previous node. if the node already exists, find the previous node and update the value of next node from previous node.
    public void put(int key, int value) {
        int index = getHashCode(key);
        if(nodes[index]==null)
        {
            nodes[index] = new node(-1,-1);
        }
        node prev = find(nodes[index],key);
        if(prev.next==null)
        {
            prev.next = new node(key,value);
        }
        else
        {
                prev.next.value=value;
        }
    }
    /*
    Find the hash value and check if any node is present at the index. return -1 if null. if not, find the previous node and check the next node of previous node. if it is null, return -1, else the value.
    
    */
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getHashCode(key);
        if(nodes[index]==null)
        {
            return -1;
        }
        else
        {
            node prev = find(nodes[index],key);
            if(prev.next==null)
            {
                return -1;
            }
            else
            {
                return prev.next.value;
            }
        }   
    }
    /*
    Find the hash value and check if any node is present at the index. return if null. if not, find the previous node and check the next node of previous node. if it is null, return, else link the previous node with the next next node.
    
    */
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getHashCode(key);
        if(nodes[index]==null)
        {
            return;
        }
        else
        {
            node prev = find(nodes[index],key);
            if(prev.next==null)
            {
                return;
            }
            else
            {
                prev.next = prev.next.next;
            }
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