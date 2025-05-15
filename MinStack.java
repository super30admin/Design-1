/*
Time Complexity - O(1) for all operations
Space Complexity - Each pushed value stores a 2-element array: [val, minSoFar]. So for n elements pushed, the total space used is:  O(n) * 2  ~~ O(n)
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No

Approach :
1. Using Stack of integer array which consiste of key value pair indexes
2. For push operation, if stack is empty, push new int array of key and value to stack and return
3. if stack is not empty, compute the minimum so far and store it with the value.
4. POP -Simply removes the top entry. Since each entry contains both value and min, there's no need to recompute anything.
5. Top - peek()[0] gives you the latest pushed value.
6. getMin - return stack.peek()[1]; // for getMin
*/

class MinStack {
    Stack<int[]> stack;
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {

        if(stack.isEmpty()){

            stack.push(new int[]{val,val });
            return;
        }
        int min = stack.peek()[1];
        stack.push(new int[]{val,Math.min(min, val)});
    }

    public void pop() {
        stack.pop();

    }

    public int top() {
        return stack.peek()[0];

    }

    public int getMin() {
        return  stack.peek()[1];

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
