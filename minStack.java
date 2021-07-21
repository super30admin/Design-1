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
                throw new Exception("Top was called on an empty stack");
            }
            return myStack.peek();
        }

        public int getMin() throws Exception {

            //this case will not happen in Leetcode but its always good to mention in interview
            if (minValue == Integer.MAX_VALUE) {
                throw new Exception("Min was called on an empty stack");
            }
            return minValue;
        }
    }
