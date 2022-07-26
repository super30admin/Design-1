import java.util.Stack;

// Time Complexity :
//1. For push, O(1)
// 2. For pop, O(1)
// 3. For getMin(), O(1)

// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class MinStack {

    private Stack<Integer> cache;
    private Stack<Integer> minStack;
    private int min;
    
    public MinStack() {
        this.cache = new Stack<>();
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
        minStack.push(min);
    }
    
    public void push(int val) {
        min = Math.min(min, val);
        cache.push(val);
        minStack.push(min);
    }
    
    public void pop() {
    	cache.pop();
        minStack.pop();
        min = minStack.peek();
    }
    
    public int top() {
        return cache.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

// Your code here along with comments explaining your approach
