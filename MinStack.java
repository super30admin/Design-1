// Time Complexity : All the operations are done in O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* APPROACH:
All the operations could be done in O(1) except the getMin. For that we maintaine a separate stack in which only values that are less than it's peak value get added.
Now to maintain what value gets invalid when popped from the stack, we maintain a size parameter.
If while popping value from stack, the size of the original stack gets less than the MinStack's peek value, then only we pop from MinStack.
 */

import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {

    class MinVal{
        int value;
        int size;

        public MinVal(int value, int size){
            this.value = value;
            this.size = size;
        }
    }

    Deque<Integer> stack;
    Deque<MinVal> minStack;

    public MinStack() {
        stack = new ArrayDeque<Integer>();
        minStack = new ArrayDeque<MinVal>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val < minStack.peek().value){
            minStack.push(new MinVal(val, stack.size()));
        }
    }

    public void pop() {
        stack.pop();
        if(!minStack.isEmpty() && minStack.peek().size > stack.size()){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if(!minStack.isEmpty()){
            return minStack.peek().value;
        } else {
            return 0;
        }
    }

    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
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