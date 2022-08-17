
// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used some resources

import java.util.Stack;

class MinStack {

    //creating a stack to store the values
    private Stack<Integer> st1;

    //creating a stack to store the min
    private Stack<Integer> st2;

    //variable to hold the minimum value
    int min;

    //constructor
    public MinStack() {

        this.st1 = new Stack<>();
        this.st2 = new Stack<>();
        //initializing the min with max value
        this.min = Integer.MAX_VALUE;
        st2.push(min);

    }

    //Time Complexity: O(1)
    public void push(int val) {

        min = Math.min(min, val);
        st1.push(val);
        st2.push(min);

    }

    //Time Complexity: O(1)
    public void pop() {
        st1.pop();
        st2.pop();
        //updating the min
        min = st2.peek();
    }

    //Time Complexity: O(1)
    public int top() {
        return st1.peek();
    }

    //Time Complexity: O(1)
    public int getMin() {

        //will return the min value
        return min;
    }




        public static void main(String args[]) {


            MinStack minStack = new MinStack();
            minStack.push(-2);
            minStack.push(0);
            minStack.push(-3);
            minStack.getMin(); // return -3
            minStack.pop();
            minStack.top();    // return 0
            minStack.getMin(); // return -2
            System.out.println(minStack.getMin());
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