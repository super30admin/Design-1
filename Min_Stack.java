import java.util.Stack;
/*
Maintain  Two Stack: 
one for pushing the element
one for pushing the current minimum 

Time Complexity:  O(1)
Space Complexity : O(N)
CODE Worked on leetcode : YES

*/

class MinStack {
    Stack<Integer> in;
    Stack<Integer> out;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        in = new Stack();
        out =  new Stack();
        min = Integer.MAX_VALUE;
        out.push(min);
    }
    
    public void push(int x) {
        min = Math.min(x,min);
        in.push(x);
        out.push(min);
    }
    
    public void pop() {
        in.pop();
        out.pop();
        min  = out.peek();
    }
    
    public int top() {
        return in.peek();
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