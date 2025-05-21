// Time Complexity : 
// add(): O(1)
// remove(): O(1)
// contains(): O(1)

// Space Complexity :
// O(n), where n = 10^6 + 1

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : I took size as 10^6 but realized arrays are zero-indexed


// Your code here along with comments explaining your approach

class MyHashSet {
    
    boolean [] arr;
    int size = (int)Math.pow(10, 6) + 1;
    public MyHashSet() {
        arr = new boolean [size];
    }
    
    public void add(int key) {
        arr[key] = true;
    }
    
    public void remove(int key) {
        arr[key] = false;

    }
    
    public boolean contains(int key) {
        return arr[key];
    }
}



// Time Complexity :
// push(): O(1)
// pop(): O(1)
// top(): O(1)
// getMin(): O(1)

// Space Complexity :
// O(n)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {
    Stack<Integer> st ;
    Stack<Integer> minst;
    public MinStack() {
       st = new Stack<Integer>();
       minst = new Stack<Integer>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minst.isEmpty() || val <= minst.peek()){
            minst.push(val);
        }
    }
    
    public void pop() {
        if(st.peek().equals(minst.peek())){
            minst.pop();
        }
        st.pop();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minst.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */