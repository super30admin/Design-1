TC:O(n)
SC:O(n)

Runtime: 4 ms, faster than 99.93% of Java online submissions for Min Stack.
Memory Usage: 40.1 MB, less than 31.16% of Java online submissions for Min Stack.

Approach: 
There will be a global variable min which tracks the minimum value in the stack
When a new number comes,if it is lesser than the minimum, then we will push the previous minimum to stack, update the minimum variable and
push the new element.If the new element is greater than min, just push to stack.When a pop operation, if the popped element is equal to min
pop twice, and update the min variable with the second popped element.



class MinStack {
Stack<Integer> st = new Stack();
// Stack<Integer> minSt = new Stack();

int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        st.push(min);
    }
    
    public void push(int x) {
        if(x<=min){
            st.push(min);
            min = x;
        }
        // minSt.push(min);
        
        st.push(x);
    }
    
    public void pop() {
       
        if(st.pop() == min){
            min = st.pop();
        }
        // minSt.pop();
        // new global minimum
        // min = minSt.peek();
        // st.pop();
        
        
    }
    
    public int top() {
        // Throwing an exception for empty stack
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
