// Time Complexity : O(1) for all operations
// Space Complexity : O(n) + O(n) which is O(n) since we used stacks to store n elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Have two stacks, Stack st to store any incoming element and Stack minSt to store the min of the incoming element and the prev saved min
// Update the min value when we pop an element to reflect the current minimum value in var min


class MinStack {
    Stack <Integer> st;
    Stack <Integer> minSt;
    int min;
    public MinStack() {
        this.st = new Stack<>();
        this.minSt = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        min = Math.min(val, min);
        st.push(val);
        minSt.push(min);
    }
    public void pop() {
        st.pop();
        minSt.pop();
        min = minSt.isEmpty()? Integer.MAX_VALUE : minSt.peek();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}
