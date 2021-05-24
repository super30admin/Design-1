// Time Complexity : O(1) for push,pop,top,getMin method
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes



class MinStack {

    /** initialize your data structure here. */

    /** declare stack as an array of integers*/

    Stack<int[]> minStack = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {


        /** if stack is empty initialize it with the current value being pushed*/
        if(minStack.isEmpty()) {
            /** Keeping pushed element in the 0th index and tracking current minimum value by pushing it to 1st index*/
            minStack.push(new int[]{val,val});
            return;
        }

        /** store the current min value in the 1st index position of the array of integers */
        int currentMinValue = minStack.peek()[1];

        /** Push the value to the stack with the value being pushed as well as also compare minimum value with the current minimum and pushed the minimum value in the stack */
        minStack.push(new int[]{val,Math.min(val,currentMinValue)});


    }

    public void pop() {
        /** Pop operation */
        minStack.pop();

    }

    public int top() {
        /** Peek method of stack gives the topmost element of the 0th index where we stored top element of the stack */
        return minStack.peek()[0];

    }

    /** Peek method gives the topmost element of the 1st index where we stored current minimum value*/
    public int getMin() {
        return minStack.peek()[1];
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