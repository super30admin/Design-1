import java.util.Stack;

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach



class MinStack {
    /** initialize your data structure here. */
    Stack<Integer> s;
    Stack<Integer> minStack;
    Integer min;
    public MinStack() {
        s = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }
    public void push(int x) {
        min = Math.min(min,x);
        s.push(x);
        minStack.push(min);
    }
    public void pop() {
        s.pop();
        minStack.pop();
        min = minStack.peek();
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
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

 class Main { 
     public static void main(String args[])
     {
         MinStack m = new MinStack();
         m.push(30);
         m.push(6);
         m.push(35);
         m.push(3);
         //m.pop();
         m.getMin();
         System.out.println("getmin value is:" + m.getMin());
     }
 }