// Submitting again via CMD
## Problem 1:
Design Hashmap (https://leetcode.com/problems/design-hashmap/)


// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


class MyHashMap {
    int[] hmap = new int[1000000];
        
    /** Initialize your data structure here. */
    public MyHashMap() {
        Arrays.fill(hmap, -1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        hmap[key]=value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        if(hmap[key]<0 || hmap[key]>1000000){
            return -1;
        }
        else{
            return hmap[key];    
        }
        
    //return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        hmap[key]=-1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */




## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class MinStack {
    Stack<Integer> st;
    Stack<Integer> MinSt;
    Integer min;    
    /** initialize your data structure here. */
    public MinStack() {
        st=new Stack<>();
        MinSt = new Stack<>();
        min = Integer.MAX_VALUE;
        MinSt.add(min);
    }
    
    public void push(int x) {
        min = Math.min(min,x);
        st.push(x);
        MinSt.push(min );
    }
    
    public void pop() {
        st.pop();
        MinSt.pop();
        min=MinSt.peek();
    }
    
    public int top() {
        return st.peek();
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
