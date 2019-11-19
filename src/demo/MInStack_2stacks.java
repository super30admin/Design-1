package demo;

import java.util.Stack;



//Time complexity : O(1)
//Space Complexity: O(n)
//LeetCode : yes

public class MInStack_2stacks {

}


class MinStack {
//ONE TO ONE RELATIONSHIP BETWEEN 2 STACKS
    Stack<Integer> st = new Stack<>() ;
    Stack <Integer> minStack = new Stack<>();
    Integer min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        minStack.push(min);
    }
    
    public void push(int x) {
        st.push(x);
        if(x <= min ){
            min = x;
        }
        minStack.push(min);
    }
    
    public void pop() {
        st.pop();
        minStack.pop();
        min = minStack.peek();
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