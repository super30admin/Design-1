// Time Complexity : O(1) for all operations
// Space Complexity : O(n) for one stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : One edge case that was discussed in class


// Your code here along with comments explaining your approach
/**
 Thought process:
 - a ds to maintain the min element
 */

class MinStack {

    /** initialize your data structure here. */
    Deque<Integer> minstack;
    int min;
    public MinStack() {
        minstack = new ArrayDeque();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        minstack.push(x);
        if(min>x) min = x;
        minstack.push(min); //to avoid the nullpointer/Integer
    }

    /**
     *  if the top element is min, get the next min and set it to min
     *  iterate through the stack and then choose a min
     *  OR find a way to record min while popping, so record min on each push, top will always be the min
     */
    public void pop() {
        minstack.pop();
        minstack.pop();
        if(!minstack.isEmpty()) min = minstack.peek();
    }

    public int top() {
        minstack.pop();
        int peek = minstack.peek();
        minstack.push(min);
        return peek;
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */