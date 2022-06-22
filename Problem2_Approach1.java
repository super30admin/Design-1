// Time Complexity : O(1)
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//Using 2 stacks and min variable
class MinStack {
    Stack<Integer> s;
    Stack<Integer> minStack;
    int min;

    public MinStack() {
        s=new Stack<>();
        minStack=new Stack<>();
        min=Integer.MAX_VALUE;
        minStack.push(min);
        
    }
    // on push operation, update min value, push element into the stack and push min value in the minStack
    public void push(int val) {
        min=Math.min(min,val);
        s.push(val);
        minStack.push(min);
        
    }
    
    //on pop operation, pop element from the stack, pop min from minStack and update min value to the top element in minStack
    public void pop() {
        s.pop();
        minStack.pop();
        min = minStack.peek();
    }
    
    //on looking for top element, get the top element of the normal stack
    public int top() {
        return s.peek();
        
    }
    
    //on looking for get min, you can pop the top element of minStack or get the min value from min variable
    public int getMin() {
        return minStack.peek();
        
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