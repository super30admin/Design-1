// Problem 1
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashMap {
    Integer[] hashMap;

    /** Initialize your data structure here. */
    public MyHashMap() {
        hashMap = new Integer[1000001];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        hashMap[key] = value; //updating array's key index = value
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if (hashMap[key] != null) {
            return hashMap[key]; //returning value
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        hashMap[key] = null; //updating array's key index = null to remove
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */

// Problem 2
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Implement MinStack using LinkedList
class MinStack {
    Node head;
    
    /** initialize your data structure here. */
    public MinStack() {
        this.head = null;
    }
    
    public void push(int x) {
        if (head == null) { 
            head = new Node(x);
            head.min = x;
        } else {
            Node temp = new Node(x);
            temp.min = Math.min(x, head.min);
            temp.next = head;
            head = temp;
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.data;
    }
    
    public int getMin() {
        return head.min;
    }
    
    // Implementing LinkedList Node
    class Node {
        int data;
        int min;
        Node next;
        
        Node(int data) {
            this.data = data;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */