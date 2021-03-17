// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class MinStack {
    Stack<Integer> stack;
    int minEle;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if(stack.isEmpty()) {
            stack.push(x);
            minEle = x;
        }
        else {
            if(x >= minEle) {
                stack.push(x);
            }
            else {
                stack.push(2*x-minEle);
                minEle = x;
            }
        }
    }

    public void pop() {
        System.out.println("The value of stack.peek() is "+ stack.peek() + " " + minEle);
        if(stack.peek() >= minEle) {
            stack.pop();
        }
        else {
            minEle = 2*minEle - stack.pop();
        }

    }

    public int top() {
        if(stack.peek() >= minEle) {
            return stack.peek();
        }
        else {
            return minEle;
        }

    }

    public int getMin() {
        return minEle;
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
