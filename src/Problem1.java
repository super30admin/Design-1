// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MyHashMap {
    Node[] list;

    /** Initialize your data structure here. */
    public MyHashMap() {
        list = new Node[1000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        Node res = getNode(key);
        if (res.next == null){
            res.next = new Node(key, value);
            return;
        }
        res.next.val = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        Node res = getNode(key);
        if (res.next == null){
            return -1;
        }
        return res.next.val;
    }

    public int getBucket(int key){
        return key %1000;
    }

    public Node getNode(int key){
        int bucket = getBucket(key);
        Node node = list[bucket];
        if(node == null){
            Node newNode = new Node(-1,-1);
            list[bucket] = newNode;
            return newNode;
        }
        while(node != null && node.next !=null && node.next.key != key ){
            node = node.next;
        }
        return node;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        Node res = getNode(key);
        if (res.next == null){
            return;
        }
        res.next = res.next.next;
    }
}
class Node{
    int key;
    int val;
    Node next = null;
    Node(int key, int val){
        this.key = key;
        this.val = val;
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
