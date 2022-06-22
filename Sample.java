//Problem 1

// Time Complexity : O(n), Amortized complexity  : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none

// Your code here along with comments explaining your approach

class MyHashMap {

    Node[] nodes;

    private class Node {
        int key, value;
        Node next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new Node[10000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIdx(key);
        Node prev = findPrev(index, key);
        if (prev.next == null) // if we dont find the key
            prev.next = new Node(key, value);
        else // if we find the key
            prev.next.value = value;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(int key) {
        int index = getIdx(key);
        Node prev = findPrev(index, key);
        if (prev.next == null)
            return -1;
        return prev.next.value;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping
     * for the key
     */
    public void remove(int key) {
        int index = getIdx(key);
        Node prev = findPrev(index, key);
        if (prev.next != null) {
            prev.next = prev.next.next; // connnects the previous and next node of the node to be removed
        }
    }

    private int getIdx(int key) {
        return Integer.hashCode(key) % 10000; // returns index less than 10000
    }

    private Node findPrev(int index, int key) {
        Node node = nodes[index];
        if (node == null) {
            nodes[index] = new Node(-1, -1); // if there is no linked list present on given index
            return nodes[index]; // returns dummy node
        }
        while (node.next != null && node.next.key != key)
            node = node.next;
        return node;
    }
}

// Problem 2

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : brute force solution is not accepted in Leetcode.

// Your code here along with comments explaining your approach

// My Brute force solution
class MinStack {
    
    private class Node{
        int val, min;  //stores the value and minmum at every stage
        Node next;
        Node(int val, int min){
            this.val = val;
            this.min = min;
        }
    }
    
    Node root; //points to top of stack
    
    /** initialize your data structure here. */
    public MinStack() {
        root = null;
    }
    
    public void push(int x) {
        if(root==null){
            root = new Node(x,x);
            root.next = null;
        }
        int min = Math.min(x,root.min);
        Node node = new Node(x, min);
        node.next = root;
        root = node;
    }
    
    public void pop() {
        root = root.next;
    }
    
    public int top() {
        return root.val;
    }
    
    public int getMin() {
        return root.min;
    }
}


//One Stack Solution

class MinStack {

    Stack<Integer> st;
    int min;
    
    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(x<=min){ if a new min is found store the current min into stack
            st.push(min);
            min = x;
        }
        st.push(x);
    }
    
    public void pop() {
        if(st.peek() == min){ // if top element equals current min then we have to change the min
            st.pop();
            min = st.peek();
        }
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}