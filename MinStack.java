// TC - O(1) for all methods push, pop, top, getMin
// SC - O(n) since we use extra space in the form of minSt and st each taking O(n) - that gives O(2n) i.e. O(n)
// Ran on Leetcode - yes
// Mistake made - No

class MinStack {
    // Solved using 2 stacks - stack 1 for value, stack 2 for min at that point
    Stack<Integer> st; // to store value
    Stack<Integer> minSt; // to store min at that point
    public MinStack() {
        this.st = new Stack<>();
        this.minSt = new Stack<>();
    }
    
    // push the value on st, and also push the corresponding min element at that time on the minSt
    public void push(int value) {
       st.push(value);
       // if no value, then minSt is empty, so the first element is the min element
       if(minSt.isEmpty()){
        minSt.push(value);
       }
       else{
        minSt.push(Math.min(value, minSt.peek()));
       }
    }
    
    // pop both stacks to keep them in sync
    public void pop() {
        st.pop();
        minSt.pop();
    }
    
    // check just the top value of the actual stack st
    public int top() {
        return st.peek();
    }
    // top value of minSt gives us the min value at that point of time in the stack
    public int getMin() {
        return minSt.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
