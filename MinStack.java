/*
 * Time Complexity: 
 * Push(), pop(), top(), getMin() -- O(1)
 * Space Complexity: O(N) for storing elements in stack
 * 
 * Successfully ran this code on leetcode
 * adding extra element into the stack whenever there is change in min and popping extra element when min element is popped and updating the min variable accordingly
 */

import java.util.Stack;
public class MinStack {
    Stack<Integer> stack;
    int min;
    public MinStack() {
        this.stack = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
            if(this.min >= val){
                this.stack.push(this.min);
                this.min = val;
            }
            this.stack.push(val);
    }
    
    public void pop() {
        if(this.min == this.stack.pop() ){
            this.min = this.stack.pop();
        }
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.min;
    }

    public static void main(String[] args){
        MinStack obj = new MinStack();
        obj.push(10);
        obj.push(2);
        obj.push(3);
        obj.push(1);
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
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
