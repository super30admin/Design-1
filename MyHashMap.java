// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach : Creating a LinkedList of 10000 elements and then creating a LinkedList of 100 elements
class MyHashMap {
    // Creating the array of nodes for LinkedList
    Node nodes[];

    /** Initialize your data structure here. */
    public MyHashMap() {
        // Creating nodes of 10000 so that the secondary LinkedList will have 100 nodes and will be faster than 1000*1000 for primary and secondary LinkedList Storage
        nodes = new Node[10000];
    }
    // This function provides the previous Node in the LinkedList so that other operations can be performed using this function
    public Node find(Node head, int key) {
        Node previousNode = null;
        Node currentNode = head;        
        while(currentNode!=null && currentNode.key != key) {
            // Setting new previous as currentNode and new current as next element of old currentNode
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        return previousNode;
    }
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = index(key);
        if(nodes[index]==null) {
            // Add first node to LinkedList as the LinkedList does not exists
            nodes[index]= new Node(-1,-1);
        }
        // Get previous Node
        Node previousNode = find(nodes[index], key);
        if(previousNode.next==null) {
            // If node is at the end of LinkedList add node
            previousNode.next = new Node(key, value);
            return;
        } else {
            // New Value will be updated for currentNode
            previousNode.next.value = value;
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = index(key);
        if(nodes[index]==null)
            return -1;
        Node previousNode = find(nodes[index],key);
        if(previousNode.next == null) {
            return -1;
        }
        return previousNode.next.value;
    }
    public int index(int key) {
        // We are calcualting key so that 14 % 10000 = 4
        return Integer.hashCode(key) % nodes.length;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        // If the value at index is null then return
        int index = index(key);
        if(nodes[index]==null)
            return;
        Node previousNode = find(nodes[index], key);
        // If next element of previousNode is empty then return
        if(previousNode.next==null)
            return;
        // Change previous element's Next to previous element's next's next
        previousNode.next = previousNode.next.next;
        
    }
}
class Node {
    int key;
    int value;
    Node next;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
