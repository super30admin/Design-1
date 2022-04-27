// Time Complexity :O(1) for all operations
// Space Complexity : O(n) where all operations may end up push in min_stack
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : 
class MinStack {
    
    /*since we want to get the min element and top eleement in constant time the straight forward way we can do that is
    storing the top and min element index value after every push ,but incase we pop the min element then we have to again find the min element by sorting so instead we can have another stack called minstack that stores the min elements when pushing.
    */
    int[] stack;
    int[] min_stack;
    int top;
    int min_top;

    public MinStack() {
        top =-1;
        min_top = -1;
        stack = new int[1000001];
        min_stack = new int[1000001];
        
    }
    
    public void push(int val) {
        if(top==-1 || min_stack[min_top] >= val  ){
            min_stack[++min_top] = val;
        }
        stack[++top] = val;
        
    }
    
    public void pop() {
        if(stack[top] ==  min_stack[min_top]){
             min_top--;                
        }
        top--;
    }
    
    public int top() {
        return stack[top];
        
    }
    
    public int getMin() {
        return min_stack[min_top];
        
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