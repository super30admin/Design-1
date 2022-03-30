// Time Complexity :asymtomatic O(1) for push, pop, top and getMin
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class MinStack {

    Stack<Integer> s;
    Stack<Integer> minStack;
    
    public MinStack() { //Initialize minStack and s stacks
        s= new Stack();
        minStack = new Stack();
        minStack.push(Integer.MAX_VALUE); //storing max value of integer to compare minimum
    }
    
    public void push(int val) {
        s.push(val);
        minStack.push(Math.min(minStack.peek(),val)); //push minimum of val and current minimum
    }
    
    public void pop() {
        s.pop();
        minStack.pop(); //pop from both stacks
    }
    
    public int top() {
        return s.peek(); //get the topmost element of s
    }
    
    public int getMin() {
        return minStack.peek(); // fetch the current minimum from minStack
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