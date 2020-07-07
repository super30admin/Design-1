/**
 * Time Complexity : O(1)
 * Space Complexity : O(n) where n = number of elements to be pushed on stack
 * Approach used : 2 stacks (with min Stack) method and keep track of minimum element every time
 */

import java.util.Stack;

class MinStack {

    Stack<Integer> stack,minStack;
    int min;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }
    
    public void push(int x) {
        if(x < minStack.peek() )
            min = x;
        stack.push(x);
        minStack.push(min);
    }
    
    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            minStack.pop();
            min = minStack.peek();
        }       
    }
    
    public int top() {
        if(!stack.isEmpty())
            return stack.peek();
        else {
            System.out.println("Empty stack, top does not exist. Returning -1");
        }
        return -1;
    }
    
    
    public int getMin() {
        return min;   
    }

    public static void main(String args[]){
        MinStack obj = new MinStack();
        int x = 10; 
        int y = 5;
        obj.push(x);
        obj.pop();
        obj.push(y);
        
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println("top : "+param_3);
        System.out.println("Min : "+param_4);
        
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