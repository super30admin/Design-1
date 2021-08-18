// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Created a stack
// Created a variable to keep track of the minimum element in stack
// To optimize my problem I maintained one stack where I pushed the current element and checked whether it is the minumum or not, if minimum then stored it in variable till the next min element. When I tracked my next min element, I pushed previous min element in the stack first and then the current element. While popping the elements, I pop the element & check whether it is the minimum element or not, if minimum then I again pop another element which is the minimum among all the remaining elements.

class MinStack {
    
    Stack<Integer> stack;
    int min;
        
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val <= min) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        if(stack.pop() == min) {
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