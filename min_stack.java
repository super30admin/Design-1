// Time Complexity : O(2n)
// Space Complexity : O(2n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {
    //method1
    //     private Stack<Integer> stack;
    //     private Stack<Integer> minStack;
    //     private int min;
    //     public MinStack() {
    //         this.min = Integer.MAX_VALUE;
    //         this.stack = new Stack<>();
    //         this.minStack = new Stack<>();
    //         minStack.push(min);
    //     }
        
    //     public void push(int val) {
    //         min = Math.min(min, val);
    //         stack.push(val);
    //         minStack.push(min);
    //     }
        
    //     public void pop() {
    //         //all are valid operations so on check for exception
    //         stack.pop();
    //         minStack.pop();
    //         min = minStack.peek();
    //     }
        
    //     public int top() {
    //         return stack.peek();
    //     }
        
    //     public int getMin() {
    //         return min;
    //     }
     //method2
        private Stack<Integer> stack;
        //private Stack<Integer> minStack;
        private int min;
        public MinStack() {
            this.min = Integer.MAX_VALUE;
            this.stack = new Stack<>();
            //this.minStack = new Stack<>();
            //minStack.push(min);
        }
        
        public void push(int val) {
            // min = Math.min(min, val);
            // stack.push(val);
            // minStack.push(min);
            if(min>=val){
                stack.push(min);
                min = val;
            }
            stack.push(val);
        }
        
        public void pop() {
            //all are valid operations so on check for exception
            // stack.pop();
            // minStack.pop();
            // min = minStack.peek();
            
            //2 pops
            if(min ==stack.pop()){
                min = stack.pop();
            }
        }
        
        public int top() {
            return stack.peek();
        }
        
        public int getMin() {
            return min;
        }
    
    

     //Your MinStack object will be instantiated and called as such:
     public static void main(String args[]) 
    { 
     MinStack obj = new MinStack();
     obj.push(5);
     obj.pop();
     int param_3 = obj.top();
     int param_4 = obj.getMin();
     System.out.println("top:"+param_3);
     System.out.println("min:"+param_4);

    }
}