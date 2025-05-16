// Time Complexity : push(), pop(), top(), getMin()  -> O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class MinStack {
    List<int[]> stackList;

    public MinStack() {
        stackList = new ArrayList<>();
    }
    
    public void push(int val) {
        int currMin = (stackList.isEmpty()) ? val : Math.min(val, getMin());
        stackList.add(new int[]{val, currMin});
    }
    
    public void pop() {
        if (!stackList.isEmpty())
            stackList.remove(stackList.size() - 1);
    }
    
    public int top() {
        if (stackList.isEmpty())
            return -1;

        return stackList.get(stackList.size() - 1)[0];
    }
    
    public int getMin() {
        return (stackList.isEmpty()) ? -1 : stackList.get(stackList.size() - 1)[1];
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