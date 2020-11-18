// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this :  Getting wrong answer

class MyHashMap {
    // int a[];
    private static class Node {
        int key, value;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
     Node[] nodes;
    /** Initialize your data structure here. */
    public MyHashMap() {
        // a = new int[1000000];
        // for(int i = 0; i < 1000000; i++) {
        //     a[i] = -1;
        // }
        nodes = new Node[1000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        // a[key] = value;
        int index = key % 1000;
        if(nodes[index] == null) {
            nodes[index] = new Node(key, value);
            return;
        }
        if(nodes[index].key == key) {
            nodes[index].value = value;
        }
        Node curr = nodes[index];
        while(curr.next != null) {
            if(curr.next.key == key) {
                curr.next.value = value;
                return;
            }
          curr = curr.next;      
        }
        curr.next = new Node(key, value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        // return a[key];
        int index = key % 1000;
        Node curr = nodes[index];
        while(curr != null) {
            if(curr.key == key)
                return curr.value;
            curr = curr.next;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        // a[key] = -1;
        int index = key % 1000;
        if(nodes[index] == null) {
            return;
        }
        if(nodes[index].key == key) {
            nodes[index] = nodes[index].next;
            return;
        }
        Node prev = nodes[index];
        Node curr = nodes[index].next;
        while(curr != null) {
            if(curr.key == key){
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1,2);
        map.put(2,2);
        map.put(2,1);
        map.remove(2);
        System.out.println(map.get(2));
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
