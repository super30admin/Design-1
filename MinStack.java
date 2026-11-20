/* Time Complexity
push - O(1)
pop - O(1)
getMin - O(1)
top - O(1)


Space Complexity
O(2n)

*/

//Stack works in LIFO manner last in first out 
//I am implementing the MinStack class with 2 stacks one is stack where the values will be pushed and other will be minstack where our previous min + current value is stored and pop will happen from both of it and return whatever min value we are left with.

import java.util.Stack;

class MinStack {
    Stack<Integer> st;
    Stack<Integer> minSt;
    int min;

    public MinStack() {
        this.st = new Stack<>();
        this.minSt = new Stack<>();
        this.min = Integer.MAX_VALUE;
        this.minSt.push(min);

    }
    
    public void push(int value) {
        min = Math.min(min, value);
        st.push(value);
        this.minSt.push(min);
        
    }
    
    public void pop() {
        st.pop();
        minSt.pop();
        min = minSt.peek();
        
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