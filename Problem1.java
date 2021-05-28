// Time Complexity : 
//        put : O(n)
//        get : O(n)
//        remove : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * We are using Linear chaining method for collision resolving
 * we create a array named map of 1000 length and at if our hash function resolves a key for an index,
 * We create a LinkedList chain dynamically if there was no chain or else we append at the end of the chain
 * 
 * For get and Remove, we follow the same methodology. 
 */

class Node {
    int key;
    int val;
    Node next;
    
    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class MyHashMap {

    /** Initialize your data structure here. */
    private Node[] map;
    private int size;
    public MyHashMap() {
        this.map = new Node[1000];
        this.size = map.length;
    }
    
    public int hashCode(int key) {
        return key % size;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        
        int index = hashCode(key);
        
        if(map[index] == null) {
            map[index] = new Node(key, value);
        } else {
            Node node = map[index];
            if(node.key == key) {
                node.val = value;
                return;
            }
            while(node.next != null) {
                node = node.next;
                if(node.key == key) {
                    node.val = value;
                    return;
                }
            }
            node.next = new Node(key, value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hashCode(key);
        
        if(map[index] != null) {
            Node node = map[index];
            while(node != null) {
                if(node.key == key) return node.val;
                node = node.next;
            }
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = hashCode(key);
        
        if(map[index] != null) {
            Node node = map[index];
            
            /* if the head itself is the key we are looking for */
            if(node.key == key) {
                map[index] = map[index].next;
            } else {
                while(node != null && node.next != null) {
                    if(node.next.key == key) {
                        node.next = node.next.next;
                    } else {
                        node = node.next;
                    }
                }
            }
        }
    }
}