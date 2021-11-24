// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// min stack approach 1:
class MinStack {
    Stack<Integer> s; //taking 2 stacks and updating side by side
    Stack<Integer> minStack;
    int min;

    public MinStack() {
        s = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }
   
    public void push(int val) {
        min = Math.min(min, val);
        s.push(val);
        minStack.push(min);
    }
   
    public void pop() {
        s.pop();
        minStack.pop();
    }
   
    public int top() {
        return s.peek();
    }
   
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



//min stack approach 2:
class MinStack {
    int min;
    Stack<Integer> s;// taking one stack only
    public MinStack() {
        s = new Stack<>();
        min = Integer.MAX_VALUE;
    }
   
    public void push(int val) {
        if(val <= min){//pushing 2 values i.e. min and val if val<=min
            s.push(min);
            min = val;
        }
        s.push(val);
    }
   
    public void pop() {//popping 2 values when we pop the min
        if(min == s.peek()){
            s.pop();
            min = s.peek();
        }
        s.pop();
    }
   
    public int top() {
        return s.peek();
    }
   
    public int getMin() {
        return min;
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


Regards,
CommWebmaster
College of Communications
657-278-7466 | CP B021