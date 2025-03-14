import java.util.Stack;
// Time Complexity : O(1) for all operations
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
I have used a single stack for the problem and taken a min variable which will hold the current
minimum at any given point of time.
Whenever we push an element, we check if its less thant or equal to the current minimum. if yes then
thats the new minimum, hence we push the old minimum onto the stack and assign the new value as global minimum
after the above we push the actual value on stack.

In pop, we pop the element. if that element is same as global minimum, that means, now the minimum may
be different, hence we pop one more element and that will be new global minimum.

By using above, min variable will always have minimum value at any point in time.
* */
class MinStack {
    Stack<Integer> stack;
    int min;
    public MinStack() {
        min=Integer.MAX_VALUE;
        stack=new Stack<Integer>();
    }

    public void push(int val) {
        if(val <= min)
        {
            stack.push(min);
            min=val;
        }
        stack.push(val);
    }

    public void pop() {

        int popped=stack.pop();
        if(popped==min)
        {
            min=stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
