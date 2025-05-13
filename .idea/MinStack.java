/*
Intuition : as this is requires min element - using PriorityQueue (min heap)
Time Complexity : push - O(1)
                  pop() - O(1)
                  getMin() - O(1)
                  top() - O(1)
Space Complexity : O(n)
*/

class MinStack {
    class MinStack {

        Stack<Integer> stack;
        Stack<Integer> min;

        public MinStack() {
            stack = new Stack<Integer>();
            min = new Stack<Integer>();
        }

        public void push(int val) {
            stack.push(val);
            if(min.isEmpty() || val <= getMin()){
                min.push(val);
            }
        }

        public void pop() {
            if (getMin() == stack.peek()) {
                min.pop();
            }

            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {

            return min.peek();

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
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */