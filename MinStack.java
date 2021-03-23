import java.util.Stack;
import java.util.*;
public class MinStack {

        /** initialize your data structure here. */
        Stack <Integer> s;
        Stack<Integer> min;
        
        public MinStack() {
            s  = new Stack();
            min = new Stack();
            min.push(Integer.MAX_VALUE);
        }
        
        public void push(int x) {
            s.push(x);
            min.push(Math.min(min.peek(),x));
        }
        
        public void pop() {
            s.pop();
            min.pop();
            
        }
        
        public int top() {
           return s.peek();
        }
        
        public int getMin() {
            return min.peek();
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
