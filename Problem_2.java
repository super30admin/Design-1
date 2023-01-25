// Time Complexity : O(1) for all operations
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/* We use a minStack in addition to our stack to maintain minimum at each stage of push/pop. We store minimum value along with count of minimum
   element as a pair in minStack. We push the element and if its value is less than current min on top of stack we push it to minStack. 
   Else if its same as earlier min we increase count by 1 in minStack. While popping if value of popped element is same as min we decrease
   the count by 1. When count reaches 0 we pop from minStack. top() and getMin() just return the top of stack and minStack respectively.
 */

 class MinStack {
    Stack<Integer> stack;
    Stack<int[]> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty() || val < minStack.peek()[0])
            minStack.push(new int[] {val, 1});
        else if(val == minStack.peek()[0])
            minStack.peek()[1]++;
    }
    
    public void pop() {
        Integer val = stack.pop();
        if(val.equals(minStack.peek()[0])) {
            minStack.peek()[1]--;
            if(minStack.peek()[1] == 0)
                minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek()[0];
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