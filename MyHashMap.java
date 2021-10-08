// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : lots of null pointer exceptions


// Your code here along with comments explaining your approach

class MyHashMap {
    
    final int size = 10000;  // declaring size as 10000 for hashing 
    Node[] hashMap;
    
    class Node {
        int key;
        int value;

        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        this.hashMap = new Node[size];
    }
    
    public void put(int key, int value) {
        Node node = find(key);
        if(node.next == null) {
            node.next = new Node(key, value);
        } else {
            node.next.value = value;
        }
    }
    
    public int get(int key) {
        Node node = find(key);
        if(node.next == null) {
            return -1;
        } else {
            return node.next.value;
        }
    }
    
    public void remove(int key) {
        Node node = find(key);
        if(node.next != null) {
            node.next = node.next.next;
        }
    }
    
        public int hashCode(int key) { // generate hashcode and % size to keep it within size limit
        return Integer.hashCode(key) % size;
    }

    public Node find(int key) { //find will return the previous node to facilitate put, get and delete
        int hashKey = hashCode(key);

        if(hashMap[hashKey] == null)
            return hashMap[hashKey] = new Node(-1, -1);
        else {
            Node prev = hashMap[hashKey];
            while(prev.next!= null && prev.next.key != key) {
                prev = prev.next;
            }
            return prev;
        }
    }
}