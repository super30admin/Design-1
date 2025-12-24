// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// In push fucntion calculating minVal, I did mistakely poped instared of peek
// It emptied the Stack when single element is present

// Your code here along with comments explaining your approach
class MinStack {
    //we will store two vals in int[]
    //First one current value, second one min element till now
    Stack<int[]> stack;
    public MinStack() {
        stack = new Stack<int[]>();
    }

    public void push(int val) {
        if(stack.isEmpty())
        {
            stack.push(new int[]{val,val});
            return;
        }
        //Calc min value till now
        int minVal = stack.peek()[1];
        //Calc curr min by comparinging minVal and incoming val
        int currMin = Math.min(minVal,val);
        //push the {val,currMin} into stack
        stack.push(new int[]{val,currMin});
    }

    public void pop() {
        //O(1) time
        stack.pop();

    }

    public int top() {
        //O(1) time
        return stack.peek()[0];

    }

    public int getMin() {
        //O(1) time
        return stack.peek()[1];

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
