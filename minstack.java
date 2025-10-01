// Time Complexity : push - O(1), pop - O(1), getmin - O(1), top - O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*Approach
I am using a stack to implement the minstack. We can also use a linked list if we are not allowed to use a stack.
There are two ways of keeping track of the min element: use two stacks, like I have done here, or we can use a single stack to keep track of both the actual elements and the min element.
Basic idea behind using two stack is that second stack will keep track of min number, when you push an element on the main stack it will be check if that number is smaller than the current min it will be push on to the min stack as a new min but if it is not then the min value will be pushed to the stack, similaraly when pop happens we will pop from both stack if in pop in min value is poped we will get the new min value using the top method from the minstack.
*/

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int minValue;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
        this.minValue = Integer.MAX_VALUE;
        this.minStack.push(minValue); // we added this to that even when all the pushed elements have been poped it
                                      // and still have one element so that peek does not fail
    }

    public void push(int val) {
        if (val < minValue) {
            minValue = val;
        }
        stack.push(val);
        minStack.push(minValue);

    }

    public void pop() {
        stack.pop();
        minStack.pop();
        minValue = minStack.peek();

    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return minValue;

    }
}