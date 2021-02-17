// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MinStack {
    private Stack<Integer> dataStack;
    private Integer min;
    /** initialize your data structure here. */
    public MinStack() {
        dataStack = new <Integer>Stack();
        min = Integer.MAX_VALUE;
        
    }
    
    public void push(int x) {
        if(x <= min)
        {
            dataStack.push(min);
            min = x;
        
        }
        dataStack.push(x);
        
    }
    
    public void pop() {
        int popped = dataStack.pop();
        if(popped == min)
        {
            min = dataStack.pop();
        }
        
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int getMin() {
        return min;
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
// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes

 class MyHashMap {
    ListNode[] nodes;
    /** Initialize your data structure here. */
    public MyHashMap() {
        nodes = new ListNode[10000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = hashFunction(key);
        if(nodes[index] == null)
        {
            nodes[index] = new ListNode(-1,-1); 
        }
        ListNode prev = find(index,key);
        if(prev.next == null)
        {
            prev.next = new ListNode(key,value);
        }
        else
        {
            prev.next.val =value;
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = hashFunction(key);
        if(nodes[index] == null)
        {
           return -1; 
        }
        else
        {ListNode node = find(index, key);
            if( node.next == null ) 
                return -1;
            else
            {return (node.next.val);
            }
        }
        
    }
    private int hashFunction(int key){
        return (key % nodes.length);
    }
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = hashFunction(key);
        if (nodes[index] == null) return;
            ListNode prev = find(index, key);
            if (prev.next == null) return;
            prev.next = prev.next.next;
        
    }
    private static class ListNode{
        int key,val;
        ListNode next;
        ListNode(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    private ListNode find(int index, int key){
        if(nodes[index] == null)
        {
           return nodes[index] = new ListNode(-1,-1); 
        }
        ListNode prev = nodes[index];
        
        while(prev.next != null && prev.next.key != key)
        {
            prev = prev.next;
        }
        return prev;
    }
    
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */