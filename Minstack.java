// Time Complexity : O(1) for push, pop, top and getMin
// Space Complexity : O(n) where n is the number of elements in the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * This is a min stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * We use two stacks to achieve this. The first stack is used to store the elements of the stack and the second stack is used to store the minimum elements of the stack.
 */
class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {


    }
    }
    
    public void push(int val) {
       stack.push(val);
       if(!(minStack.isEmpty())){
        minStack.push(Math.min(val,minStack.peek()));

       }else{
        minStack.push(val);
       }
        
    }
    
    public void pop() {
         stack.pop();
         minStack.pop();
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return  minStack.peek();



        
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