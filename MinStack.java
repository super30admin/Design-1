// Approach:
// The idea is to store current minumum in a min variable, keep track of previous mininums in a seperate stack for every push that happens on the original stack.
// So whenever a pop happens, we check if the popped element is minumum, if so we set the current minumum with the top of minStack, and pop this top element from minStack
// To prevent managing multiple same minimums, we follow this approach otherwise, we can achieve the same without the min variable, but through the minStack itself. 


// Time Complexity:

// push(), pop()       - O(1)
// top, getMin()       - O(1)

// Space complexity:
// push(), pop()       - O(1)
// top, getMin()       - O(1)

// Code
import java.util.Stack;

class MinStack {
    
    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;

    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.st = new Stack<>();
        this.minSt = new Stack<>();
    }
    
     
    public void push(int value) {
        if(min >= value)
        {
            minSt.push(min);
            min = value;
        }

        st.push(value);
    }
    
    public void pop() {
        if(min == st.pop())
        {
            min = minSt.peek();
            minSt.pop();
        }
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
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */