import java.util.Stack;
// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MinStack {

    Stack<Integer> main_stack;
    int min;
        public MinStack() {
            main_stack = new Stack<Integer>() ;
            min = Integer.MAX_VALUE;
        }
        
        public void push(int val) {
            if(min>=val){
                main_stack.push(min);
                min = val;
            }
            main_stack.push(val);
        }
        
        public void pop() {
            if(min ==main_stack.pop()){
                min = main_stack.pop();
            }
            
        }       
        
        public int top() {
            return main_stack.peek();
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