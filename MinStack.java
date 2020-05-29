// Time Complexity : O(1) for push, pop, getMin and remove
// Space Complexity :O(n) where n is number of operations
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinStack {

    /** initialize your data structure here. */
    List<Integer> stack;
    int min = Integer.MAX_VALUE;
    int size = 0;
    public MinStack() {
        stack = new ArrayList<>();
    }
    
    public void push(int newNum) {
            if(newNum<=min)
            {
                stack.add(min);
                stack.add(newNum);
                min = newNum;
            }
            else
            {
                stack.add(newNum);
            }
            
            
    }
    
    public void pop() {
        
        if(stack.size()==1) return;
        else
        {
            if(stack.get(stack.size()-1)==min)
            {
                stack.remove(stack.size()-1);
                min = stack.remove(stack.size()-1);
            }
            else
            {
                stack.remove(stack.size()-1);
            }
        }

    }
    
    public int top() {
        return stack.get(stack.size()-1);
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