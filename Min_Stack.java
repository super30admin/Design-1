// Time Complexity : push O(1) pop O(1) top O(1) getMin O(1) 

// Space Complexity : Worst case O(2n) Similar to twostack, which is eventually O(n)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach
class MinStack {

    /** initialize your data structure here. */
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();

    public MinStack() {

    }

    public void push(int x) {
        // first we check if the min should be updated,if yes store the previous max
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        // store the current element
        stack.push(x);
    }

    public void pop() {
        // if the popped element is equal to the minimum value then update
        // the minimum value
        if (stack.pop() == min) {
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

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */