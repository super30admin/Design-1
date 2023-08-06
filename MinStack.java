// Time Complexity : push: O(1) pop: O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// push(): If current value to be insterted is going to be current min, then push the prev min along with the current min
// initially insert infinity value into the stack along with the first value which is current min
//pop(): if the pop element is current mininum, do another pop which would be the current min
import java.util.Stack;

class MinStack {
    Stack<Integer> st;
    int min;
    public MinStack() {
        this.st = new Stack<>();
        this.min = Integer.MAX_VALUE;
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