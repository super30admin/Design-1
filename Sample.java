// Time Complexity :0(1)
// Space Complexity :
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :I am pretty new to DS so i have copied from the class.
//I have to revisit stack linklist once again 


// Your code here along with comments explaining your approach
class MinStack {
    

    Stack<Integer> s = new Stack<>();
    Stack<Integer> min = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if(min.isEmpty() || x<=min.peek()){
            min.push(x);
        }
        s.push(x);
    }
    
    public void pop() {
        if(s.peek().equals(min.peek())){
            min.pop();
        }
        s.pop();
        
    }
    
    public int top() {
        return s.peek();
        
    }
    
    public int getMin() {
        return min.peek();
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