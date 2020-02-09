// Time Complexity :
//Put O(n)
//Remove O(n)
//Get O(n)

//// Space Complexity :
//O(1) Not sure, please let me know if its correct
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Forgot to initialize the bucketItem array which caused an issue, resolution took 5 min.
class MyHashMap {
    Node[] nodes;
    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new Node[10000];
    }
    class Node{
        int key,value;
        Node next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        Node cursor = getElement(key);
        if (cursor.next == null){
            Node new_node = new Node(key,value);
            cursor.next = new_node;
            return;
        }
        cursor.next.value = value;
    }
    private int getIndex(int key){
        return key%10000;
    }
    private Node getElement(int key){
        int index = getIndex(key);

        if (nodes[index]==null){
            Node dummy =  new Node(-1,-1);
            nodes[index]=dummy;
            return dummy;
        }
        Node cursor = nodes[index];
        while(cursor.next!=null && cursor.next.key!=key){
            cursor=cursor.next;
        }
        return cursor;


    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        Node cursor = getElement(key);
        if (cursor.next == null){
            return -1;
        }
        return cursor.next.value;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        Node cursor = getElement(key);
        if (cursor.next!=null){
            cursor.next = cursor.next.next;

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
