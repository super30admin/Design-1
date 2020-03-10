// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
class MinStack {

    Stack<Integer> minStack;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        minStack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(x<=min)
        { 
            minStack.push(min);
            min = x;
           
        }
        minStack.push(x);
    }
    
    public void pop() {
         int el = minStack.pop();
        if(el==min)
            {
                min = minStack.pop();
            }
    }
    
    public int top() {
        return minStack.peek();
        
    }
    
    public int getMin() {
        return min;
    }
}
