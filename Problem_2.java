// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// We uses the stack to represent minstack problem, along with that we maintain a min variable that contains the min value push into the stack
// the key feature is that if the min value get changed to new min, we store the old min to the stack and retrive on pop.

// Your code here along with comments explaining your approach
class MinStack {

    Stack <Integer> myStack;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        myStack  = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if( min >= val){          // comparing old min with the value added
            myStack.push(min);    // setting up the old min to the stack for later use
            min = val;            // updateing the min with new value
        }
        myStack.push(val);        // pusing the actual value to the stack
    }

    public void pop() {
        if( min == myStack.pop()){  // checking if the min is same as the top element, if yes then we need
            min = myStack.pop();    // to get the old min and set it up again to the min variable
        }
    }

    public int top() {
        return myStack.peek();      //gives the topmost element
    }

    public int getMin() {
        return min;                 //gives the min value
    }
}
