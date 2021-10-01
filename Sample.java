// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MyHashMap {

    /** Initialize your data structure here. */
    class Node{
        int key;
        int value;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Node[] nodes;

    public MyHashMap() {


        nodes = new Node[10000];

    }
    public int getIndex(int key){
        return key % 1000;
    }
    public Node findNode(Node head, int key){
        Node prev = head;
        Node current = head.next;
        while(current != null && current.key != key)
        {
            prev = current;
            current = current.next;
        }
        return prev;
    }
    public void put(int key, int value) {
        int index = getIndex(key);
        if(nodes[index] == null){
            nodes[index] = new Node(-1,-1);
        }
        Node prev = findNode(nodes[index],key);
        if(prev.next == null){
            prev.next = new Node(key,value);
        }
        else{
            prev.next.value = value;
        }
    }


    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        if(nodes[index] == null) return -1;
        Node prev = findNode(nodes[index],key);
        if(prev.next == null) return -1;
        return prev.next.value;

    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        if(nodes[index] == null) return;
        Node prev = findNode(nodes[index],key);
        if(prev.next == null) return;
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


// Your code here along with comments explaining your approach
