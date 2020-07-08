// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :   yes
// problems : i was getting empty stack exception , was using min_stack.peek()>x in line 12's if condition
import java.util.*;
class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> min_stack = new Stack<Integer>();

    public void push(int x) {
        stack.push(x);
        if(min_stack.isEmpty() || min_stack.peek()>=x) min_stack.push(x);
    }
    
    public void pop() {
        int min_element = getMin();
        int popped_element = stack.pop();
        if(min_element==popped_element) min_stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min_stack.peek();
        
    }
    public static void main(String[] args)
    {
        MinStack obj = new MinStack();
        obj.push(0);
        obj.push(1);
        obj.push(0);
        obj.getMin();
        obj.pop();
        obj.getMin();
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