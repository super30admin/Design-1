// Time Complexity : O(1) for all operations
// Space Complexity : O(N). Where N = size of stack.
// Did this code successfully run on Leetcode : YES
// LC submission link: https://leetcode.com/submissions/detail/526195044/
// Any problem you faced while coding this : None.

import java.util.Stack;

class MinStack {
        Stack<Integer> myStack;
        int minValue;
        /** initialize your data structure here. */
        public MinStack() {
            myStack = new Stack<>();
            minValue = Integer.MAX_VALUE;
        }

        public void push(int val) {
            if(minValue >= val) {
                myStack.push(minValue);
                minValue = val;
            }
            myStack.push(val);
        }

        public void pop() {
            if(minValue == myStack.pop()){
                minValue = myStack.pop();
            }
        }

        public int top() throws Exception {

            //this case will not happen in Leetcode but its always good to mention in interview
            if(myStack.empty()){
                throw new Exception("top method was called on an empty stack");
            }
            return myStack.peek();
        }

        public int getMin() throws Exception {

            //this case will not happen in Leetcode but its always good to mention in interview
            if (minValue == Integer.MAX_VALUE) {
                throw new Exception("getMin method was called on an empty stack");
            }
            return minValue;
        }
    }
