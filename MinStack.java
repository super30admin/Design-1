// Design MinStack using single stack
// Time Complexity: O(1)
// Space Complexity: O(N)
// Idea: We can use a single stack to store the values. We can also store the minimum value in the stack. If the value to be pushed is less than the minimum value, we can push the minimum value first and then push the value. While popping, if the value to be popped is the minimum value, we can pop the value and then pop the minimum value. This way we can perform all the operations in O(1) time.
// Did it run on Leetcode: Yes

class MinStack {

    Stack<Integer> st;
    int min; // using single stack

    public MinStack() {
        this.st = new Stack<>(); // original stack
        this.min = Integer.MAX_VALUE; // -infinity 
    }
    
    public void push(int val) {
        if(min >= val) {
            st.push(min);
            min = val;
        }
        st.push(val);

    }
    
    public void pop() {
        if(st.pop() == min) {
            min = st.pop();
        }
        
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}