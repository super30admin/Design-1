// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// We maintain two stacks. One for normal stack functionality and other for maintaing lowest element so far.
// if s is empty or current element is less than equal to minS.peek() then we all that element in both stacks
// or else we add current element in s only
// during pop operation if element popped from s is equal to minS.peek() then we pop from minS also, else only from s
// because of this for each pop and push operation we are always pointing to minimum element we have so far through minS stack
// this allows us to perform all normal stack operations as well as finding minimum element in O(1) time

class MinStack {
    Stack<Integer> s;
    Stack<Integer> minS;
    
    public MinStack() {
        s = new Stack<>();
        minS = new Stack<>();
    }
    
    public void push(int val) {
        if(s.empty() || val <= minS.peek()){
            minS.push(val);
        }
        
        s.push(val);
        
    }
    
    public void pop() {
        int value = s.pop();
        if(value == minS.peek()){
            minS.pop();
        }
        
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return minS.peek();
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
