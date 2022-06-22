// Time Complexity : O(1)
// Space Complexity : on an average less than approach 1
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// One stack approach with min variable to save some space
class MinStack {
    Stack<Integer> s;
    int min;

    public MinStack() {
        s=new Stack<>();
        min=Integer.MAX_VALUE;
        
    }
    
    public void push(int val) {
        //if current ele is less or equal than min, push old min, update the min and push ele
        if(val<=min){
            s.push(min);
            min=val;
        }
        //else just push that element
        s.push(val);
    }
    
    public void pop() {
        // if pop equals min element, then pop ele, set min to next ele, and pop that ele too or else just pop that ele
        if(min==s.pop()){
            min=s.pop();
        }
    }
    
    //similar to last approach get top element of the stack
    public int top() {
        return s.peek();
        
    }
    
    // for min value return value of the min variable
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