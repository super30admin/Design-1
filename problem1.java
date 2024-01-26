// Time Complexity :o(1)
// Space Complexity :o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Sometimes i will be knowing the approach but find difficulty in writing the code.


// Your code here along with comments explaining your approach
// as discussed in class took two stacks primary for the operations and the secondary to store min values.
class MinStack {
    Stack<Integer> primary;
     Stack<Integer> secondary;
     int min;

    public MinStack() {
        this.min=Integer.MAX_VALUE;
        this.primary=new Stack<>();
        this.secondary=new Stack<>();
        this.secondary.push(this.min);

        
    }
    
    public void push(int val) {
        min=Math.min(min,val);
         this.primary.push(val);
          this.secondary.push(min);
    }
    
    public void pop() {
        this.primary.pop();
        this.secondary.pop();
        min=secondary.peek();
        
    }
    
    public int top() {
      return  this.primary.peek();

        
    }
    
    public int getMin() {
        return  this.secondary.peek();

        
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