// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack {
    int max=1000000;
    int value[]=new int[max];
    int min[]=new int[max];
    int top=-1;
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int val) {
    int min2 =  (top<0 || val<min[top] ) ? val : min[top]  ;
    top++;
    value[top] = val;
    min[top] = min2;
    }
    
    public void pop() {
        if(top>=0){
            top--;
        }
    }
    
    public int top() {
        return value[top];
    }
    
    public int getMin() {
        return min[top];
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