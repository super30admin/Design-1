// Time Complexity :O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

// Your code here along with comments explaining your approach
/*
In this two arrays are used one to store values and one to track the minimum at each position.
When I push a value, I also store the smallest value seen so far
This will let me get the minimum element in constant time.
time  - O(1)
space - O(n)
*/

class MinStack {
    int[] stack;
    int[] minStack;
    int top;

    public MinStack() {
        stack = new int[10000];
        minStack = new int[10000];
        top = -1;
    }

    public void push(int val) {
        top++;
        stack[top] = val;
        // if first element, it is the minimum by default
        if (top == 0) {
            minStack[top] = val;
        } //else, store the smaller value between the current element and the previous minimum so far
        else {
            minStack[top] = Math.min(val, minStack[top - 1]);
        }
    }

    public void pop() {
        top--;
    }

    public int top() {
        return stack[top];
    }

    public int getMin() {
        return minStack[top];
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