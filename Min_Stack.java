/*Time Complexity :O(1)
push() : takes O(1) time
pop() :  O(1) time.
top() : amortized O(1) time.
getMin() : O(1).
Space Complexity :  O(n) as stack is used to store.
 */
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
class MinStack {
    Stack<Integer> min_stack;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        min_stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(val <= min){
            min_stack.push(min);
            min = val;
        }
        min_stack.push(val);
    }

    public void pop() {
        int pop_item = min_stack.pop();
        if(pop_item == min){
            min = min_stack.pop();
        }
    }

    public int top() {
        return min_stack.peek();
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