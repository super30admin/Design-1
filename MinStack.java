// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : N/A


// Your code here along with comments explaining your approach

class MinStack {
    Stack<Integer> stack; // declaring stack
    int min; //declaring min

    public MinStack() {
        stack = new Stack<>(); //initialziing the stack
        min = Integer.MAX_VALUE; // setting the min val as infinite because every number will le less than this
    }

    public void push(int val) {
        if(val <= min){ // if value is less than min then push the min value in stack and set the min as the new value
            stack.push(min);
            min = val;
        }
        stack.push(val); // push the new value in the stack
    }

    public void pop() {
        if(min == stack.pop()){ // popping the top value + checking if it is equal to minimum value
            min = stack.pop();// if condtion is matched, then set the min as next top value because we added it before for refereece to next min value
        }
    }

    public int top() {
        return stack.peek(); // return top value of stack
    }

    public int getMin() {
        return min; //returning the minimum value in O(1) time.
    }
}
