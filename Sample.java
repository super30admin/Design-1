// Time Complexity : Time complexity for all these operations would be O(n)
// Space Complexity : Space complexity would be O(n) as the space is required for the stack and minstk 
// Did this code successfully run on Leetcode :Yes

// Any problem you faced while coding this :
// I had already solved this on leetcode so I remembered how to solve this
// problem
// ALso had to lookup time complexity of stack and syntax of stack

// Your code here along with comments explaining your approach

//Used one stack to store all the elements and used another stack to keep track of the smallest element. 
//Point of using a stack instead of a integer variable is to keep track of the smallest element in case the current smallest element is removed.
//Element will only be inserted into the minstk if that element is smaller than or equal to the top element. It will also be removed when the original element is removed from the main stack

class MinStack {

    Stack<Integer> stk;
    Stack<Integer> minstk;

    public MinStack() {
        stk = new Stack<>();
        minstk = new Stack<>();
    }

    public void push(int val) {
        stk.push(val);
        if (minstk.empty() || minstk.peek() >= val) {
            minstk.push(val);
        }
    }

    public void pop() {
        int temp = stk.pop();
        if (temp == minstk.peek())
            minstk.pop();

    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return minstk.peek();
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
