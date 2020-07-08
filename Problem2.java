// Time Complexity :
// Push - Best/Amotized:O(1) 
// Pop - Best/Amotized:O(1)
// Top - Best/Amotized:O(1)
// GetMin - Best/Amotized:O(1) 

// Space Complexity :
// Worst Case: O(N + N) => O(N), where N is the number of elements and SIZE is size of array
// Best/Average Case : O(N) for Single Stack approach, O(2N) for 2 stacks approach

// Did this code successfully run on Leetcode : YES.
// Any problem you faced while coding this : NO. 


// Your code here along with comments explaining your approach
//Used Single Stack approach
//We could have used 2 stacks or single linkedList {linkedlist approach quite similar to Stack}
//However, using 2 stacks will going to have 2N memory footprints. 


import java.util.Stack;

class MinStack {

    Stack<Integer> stack;
    int min;


    /** initialize your data structure here. */
    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }

    // popup twice incase we encountered minimum on top, 
    // to get the 2nd minimum and set it as new minimum
    // incase non minimum on top just take the top element.
    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }
    }

    //if new value is lesser or equal to current min
    //push current min first and then push new number {new minimum} over it 
    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }


    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */