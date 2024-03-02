// Time Complexity : Push, Pop, Peek, Min: O(1)
// Space Complexity : O(1) since we are using single stack to store the values as wel as mininmum
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/min-stack/
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//In this approach, we have used a single stack and we have done our mapping in such a way that we push the element to the stack and below it we push the minimum.


class MinStack {

     Stack<Integer> st;
     int min;
    public MinStack() {
        this.min = Integer.MAX_VALUE;
        this.st = new Stack<>();
    }
    
    public void push(int val) {
       if(val<=min){
           st.push(min);
           min = val;
       }
        this.st.push(val);
    }
    
    public void pop() {
       if(st.pop()==min){
           min = st.pop();
       }
       
    }
    
    public int top() {
        return this.st.peek();
    }
    
    public int getMin() {
        return this.min;
    }
}
