// Time Complexity : O (N/K), N - Total elements, K - Total buckets
// Space Complexity : O (N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class MyHashMap {
    
    //Initialize a List Node
    
    private static class Node {
        int key, value;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
        
    }
    
    Node[] head = new Node[1000];

    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        
        int index = key % head.length;
        
        if(head[index] == null) {
            head[index] = new Node(key, value);
            return;
        }
        else
        {
            Node curr = head[index];
            if (curr.key == key) {
                curr.value = value;
                return;
            }
            while (curr.next != null) {
                if (curr.next.key == key) {
                    curr.next.value = value;
                    return;
                }
                curr = curr.next;
            }
            curr.next = new Node (key, value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        
        int index = key % head.length;
        
        if(head[index] == null) {
            return -1;
        }
        else
        {
            Node curr = head[index];
            while (curr != null) {
                if (curr.key == key) {
                    return curr.value;
                }
                curr = curr.next;
            }
        }
        return -1;
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        
        int index = key % head.length;
        
        if(head[index] == null) {
            return;
        }
        
        if(head[index].key == key) {
            head[index] = head[index].next;
        }
        Node curr = head[index], prev = head[index];
        
        while (curr != null) {
            if (curr.key == key) {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
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