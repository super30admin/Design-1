// Time Complexity : O(1) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Your code here along with comments explaining your approach
import java.util.Stack;
class MinStack {
    Stack<Integer> s=new Stack<>();
    int min=Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        s.push(min);
    }
    
    public void push(int x) {
        if(x<=min){
            s.push(min);
            min=x;
        }
        s.push(x);
    }
    
    public void pop() {
        int x;
        x=s.pop();
        if(x==min) min=s.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min;
    }
}
