# Design-1

## Problem 1:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A -Followed algorithm taught in class.



// Your code here along with comments explaining your approach
class MyHashMap {
   
    class Node
    {
        int key;
        int value;
        Node next;
        public Node(int k, int v)
        {
            this.key=k;
            this.value =v;
            this.next = null;
        }
    }
     Node primary_array[];
   
    
    public MyHashMap() {
        
        //Initialize the primary array
        primary_array = new Node[10000];
    }
    
    private int index(int key)
    {
        return Integer.hashCode(key) % 10000;
    }
    
    private Node find(int key, Node node)
    {
        Node prev= null;
        Node curr= node;
        while(curr != null && curr.key != key)
        {
            prev = curr;
            curr = curr.next;
        }
        // return head/prev to the node being searched
        return prev;
    }
    public void put(int key, int value) {
        
        int pindex = index(key);
        if(primary_array[pindex] == null)
        {
            primary_array[pindex] = new Node(-1, -1);
        }
        
        Node prev = find(key, primary_array[pindex]);
        
        if(prev.next == null)
        {
            prev.next = new Node (key, value);
        }
        else
        {
            prev.next.value = value;
        }
        
    }
    
    public int get(int key) {
        int pindex = index(key);
        if(primary_array[pindex] == null)
            return -1; //not found
        Node prev = find(key, primary_array[pindex]);
        if (prev.next == null ) return -1;
        return prev.next.value;
        
    }
    
    public void remove(int key) {
        int pindex = index(key);
        if(primary_array[pindex] == null)
            return; //not found
        Node prev = find(key, primary_array[pindex]);
        if(prev.next == null) return;
        prev.next = prev.next.next;
    }
}



## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)
// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A -Followed algorithm taught in class.



// Your code here along with comments explaining your approach
//1:1 relationship, for each element, push minimum value in that stack at that point into the minstack  

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private int min;
    public MinStack() {
        //intialize the two stacks
        stack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
        
    }
    
    public void push(int val) {
        min = Math.min(val, min);
        minStack.push(min);
        stack.push(val);
        
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        min = minStack.peek();
        
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        return min;
        
    }
}



