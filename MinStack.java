// Time Complexity : O(n)
// Space Complexity : O(log n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

class MinStack {
    int top;
    int stack[] = new int[1000];
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        top = -1;
        min = 0;
    }
    
    public void push(int val) {
        stack[++top] = val;
        if(min > val)
            min = val;
        
    }
    
    public void pop() {
        
            int copyCounter = 0;
            int copyArray[] = new int[stack.length - 1];
            
            for(int i = 0; i < stack.length; i++){               
                if(stack[i] != stack[top]){
                    copyArray[copyCounter++] = stack[i];
                }
            }
            stack = copyArray;
            min = copyArray[0];
            for(int j = 0; j< copyArray.length-1; j++){
                if(min > copyArray[j]){
                    min = copyArray[j];
                }
            }
    }
    
    public int top() {
        int x = stack[top];
        return x;
    }
    
    public int getMin() {
        return min;
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