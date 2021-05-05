import java.util.Stack;

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Sample {
    static class MinStack {

        /** initialize your data structure here. */
        private Stack<int[]> stack;
        private int min;
        public MinStack() {
            stack = new Stack<int[]>();
            min = Integer.MAX_VALUE;
        }
        
        public void push(int val) {
            if (val < min){
                min = val;
            }
            stack.push(new int[] {val, min});
        }
        
        public int pop() {
            int poppedElement = -1;
            if (stack.size() > 0){
                poppedElement = stack.pop()[0];
                if (stack.size() == 0)
                    min = Integer.MAX_VALUE;
                else
                    min = stack.peek()[1];
            }
            return poppedElement;
        }
        
        public int top() {
            if (stack.size() > 0){
                return stack.peek()[0];
            } else {
                return -1;
            }
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

    
    // Time Complexity : O(n)
    // Space Complexity : O(1)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this :

    static class MyQueue {

        /** Initialize your data structure here. */
        private Stack<Integer> in;
        private Stack<Integer> out;

        public MyQueue() {
            in = new Stack<Integer>();
            out = new Stack<Integer>();
        }
        
        /** Push element x to the back of queue. */
        public void push(int x) {
            in.push(x);
        }
        
        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            peek();
            return out.pop();
        }
        
        /** Get the front element. */
        public int peek() {
            if(out.isEmpty()) {
                while(!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
            return out.peek();
        }
        
        /** Returns whether the queue is empty. */
        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }
    }

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
    
    public static void main(String args[]) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println(q.peek());
        System.out.println(q.pop());
        System.out.println(q.peek());
        System.out.println("========");
        MinStack s = new MinStack();
        s.push(2);
        s.push(3);
        s.push(1);
        System.out.println(s.getMin());
        System.out.println(s.pop());
        System.out.println(s.top());
        System.out.println(s.getMin());
    }
}