// Time Complexity : 0(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class MinStack {
    
    private Stack<Integer> st;
    int min;
    public MinStack() {
        
        this.min= Integer.MAX_VALUE;
        this.st = new Stack<>();
       
    }
    
    public void push(int val) {
       if(val <= min){  //if value is less then min...
        st.push(min);  //then push min
        min=val;  //change the min
      }
      st.push(val);
    }
    
    public void pop() {
        if(st.pop() == min){  // pop an element if it is equal to min then pop one more element
           min = st.pop();
        }
     
    }
    
    public int top() {
        return st.peek();  //return the top element of the stack
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