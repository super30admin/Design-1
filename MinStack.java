// Time Complexity : push O(1); pop O(1); top O(1); min O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinStack {

    //alway maintain min as a separate item
    int min;
    Stack<Integer> stack;
    
    public MinStack() {
        this.min = Integer.MAX_VALUE; // initialize min to integer MAX
        this.stack = new Stack<Integer>(); // initialize integer Stack
    }
    
    public void push(int val) {
        //push min value into stack if new val less than min
        if (val <= min) { //check if val is the new minimum
            stack.push(min); // then push the old min into stack
            min = val; // val will become new min
        }
        stack.push(val); // else val is not the new min, then push val into stack
    }

    public void pop() {
        int peek = stack.pop(); //pop element
        if (peek == min){ // in case min value was popped, the next top will be the new min
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
