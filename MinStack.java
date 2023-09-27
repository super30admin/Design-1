// Time Complexity :
// * push(),pop(),top() and peek() have a time complexity of O(1) due to only access or direct modification and no traversal
// * Initialization of the stack and the data members is also a O(1) time complexity task

// Space Complexity :
// * O(2n) = O(n) --> THe space required for the 2 stacks
// * No relevant extra space is created in other functions so their space complexity is 0(1)

// Did this code successfully run on Leetcode : Ran successsfully on Leetcode
// Any problem you faced while coding this : --


// Your code here along with comments explaining your approach
//The approach is to maintain two seperate stacks one which acts as the normal stack
// and the other one which stores the minimum element corresponding to every insertion in the main normal stack

// Another approach could be to store a key,value kind of pair where key is the element being inserted/pushed
// and the value is the minimum element in the stack after pushing the new element i.e key

class MinStack {

    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;
    int min;

    public MinStack() {

        this.mainStack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
        this.min = Integer.MAX_VALUE;
        this.minStack.push(min);

    }

    public void push(int val) {
        min = Math.min(val, min);
        minStack.push(min);
        // minStack.push(minStack.peek());
        mainStack.push(val);
    }

    public void pop() {
        mainStack.pop();
        minStack.pop();
        this.min = minStack.peek();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return min;
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