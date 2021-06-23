//Problem 1: Design Hash Map
//Time Complexity : O(length of linked list). The length of linked list will always be constant as it is bounded by the size of the bucket list or parent array.
//space complexity : O(n) as extra space is used where n is the elemnts stored in linked list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Design hashmap
class MyHashMap {

    class Node{
        int key,value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    Node[] node;// array to hold indivisual buckets

    int find_index(int key){
        return Integer.hashCode(key) % node.length; // generates random index bounded by the nodes array length
    }
    //helper function to find the prev node
    Node find(Node head, int key){
        Node prev = head;
        Node cur = head;
        while(cur!=null && cur.key!=key){
            prev = cur;
            cur = cur.next;
        }
        return prev;
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
        node = new Node[10000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = find_index(key); // determine the index
        if(node[index]==null){       // if the index is null then add a dummy pointer to create the chain of nodes
            node[index] = new Node(-1,-1);
        }
        Node prev = find(node[index],key); // else determine where to add the value
        if(prev.next == null){    //if nothing exists then create a new node and add it
            Node new_node = new Node(key,value);
            prev.next = new_node;
        }
        else{
            prev.next.value = value; // else update the value of the existing key
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = find_index(key);// determine the index
        if(node[index]==null){       // if the index is null then no element exists
            return -1;
        }
        Node prev = find(node[index],key);// otherwise find its position
        if(prev.next == null){ // if end of the list is reached return -1
            return -1;
        }
        return prev.next.value; // return the value
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = find_index(key);// determine the index
        if(node[index]==null){       // if the index is null do nothing and just return
            return;
        }
        Node prev = find(node[index],key);// otherwise find its position
        if(prev.next == null){ // if end of the list is reached just return
            return;
        }
        prev.next = prev.next.next;// connect to its next element
    }
}