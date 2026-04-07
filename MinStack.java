// Time Complexity : O(1) for push, pop, top, and getMin
// Space Complexity : O(n) as we store all elements in the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Faced minor difficulty in translating tuple-based approach to Java, I had done in c# before.
// Your code here along with comments explaining your approach
// As a pair we can store the value and the minimum value at that point in the stack. 
// So when we push a new value, we can compare it with the current minimum and store the new minimum if necessary. 
// This way, we can retrieve the minimum value in O(1) time by looking at the top of the stack.
import java.util.Stack;
class MinStack {
 
    class Pair {
        long val;
        long min;

        Pair(long val, long min) {
            this.val = val;
            this.min = min;
        }
    }

    Stack<Pair> st;

    public MinStack() {
        st = new Stack<>();
    }
    public void push(int val) {
        if(st.isEmpty())
        {
            st.push(new Pair(val,val));
        }
        else
        {
            long currMin=Math.min(val,st.peek().min);
            st.push(new Pair(val,currMin));
        }
    }
    
    public void pop() {
        if (!st.isEmpty()) {
            st.pop();
        }
    }
    
    public int top() {
        if (!st.isEmpty()) {
            return (int) st.peek().val;
        }
        throw new RuntimeException("Stack is empty.");
    }
    
    public int getMin() {
         if (!st.isEmpty()) {
            return (int) st.peek().min;
        }
        throw new RuntimeException("Stack is empty.");
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

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
class Main { 
    public static void main(String args[]) 
    { 
            MinStack obj = new MinStack();
            obj.push(-2);
            obj.push(0);
            obj.push(-3);
            System.out.println(obj.getMin()); // return -3
            obj.pop();
            System.out.println(obj.top());    // return 0
            System.out.println(obj.getMin()); // return -2
            MyHashSet obj1 = new MyHashSet();
            obj1.add(1);
            obj1.add(2);
            System.out.println(obj1.contains(1)); // returns true
            System.out.println(obj1.contains(3)); // returns false (not found)
            obj1.add(2);
            System.out.println(obj1.contains(2)); // returns true
            obj1.remove(2);
            System.out.println(obj1.contains(2)); // returns false (already removed)
    } 
}