Problem MinStack
// Time Complexity : O(n)
// Space Complexity : O(1) if we dont consider input arrar
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no (i coded after attending the class)


// Your code here along with comments explaining your approach
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack1;
    int min;
    public MinStack() {
        stack1 = new Stack<Integer>();
        min =Integer.MAX_VALUE;
        stack1.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        if(x<=min){
            stack1.push(min);
            stack1.push(x);
            min = x;
        }else{
            stack1.push(x);
        }

    }

    public void pop() {
        if(stack1.peek() == min){
            stack1.pop();
            min = stack1.pop();
        }else{
            stack1.pop();
        }

    }

    public int top() {
        return stack1.peek();

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


// Time Complexity : O(n)
// Space Complexity : O(1) if we dont consider input arrar
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no (i coded after attending the class)


// Your code here along with comments explaining your approach