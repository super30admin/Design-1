// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class MinStack {
    
    Stack<int[]> stack = null;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if(stack.isEmpty()){
            stack.push(new int[]{x, x});
            return;
        }
        
        int topMin = stack.peek()[1];
        if(topMin < x){
            stack.push(new int[]{x, topMin} );
        }
        else{
            stack.push(new int[]{x,x});
        } 
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}
