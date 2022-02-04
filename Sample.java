// Time Complexity :
// push : O(1)
// pop : O(1)
// top : O(1)
// getMin : O(1)
// Space Complexity : O(N) number of elements
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : it took some time to understand push and pop operations


// Your code here along with comments explaining your approach

class MinStack {

    private int min;//taking a min variable
    private Stack<Integer> st;// creating a stack

    public MinStack() {
        min=Integer.MAX_VALUE;//assigning maximum value of integer
        st=new Stack<Integer>();//initializing stack
    }
    
    public void push(int val) {//to push an element to the stack
        if(val<=min){//checking if given value is less than or equal to min
            st.push(min);// pushing min to stack here min and val are may or may not be equal
                         //if val and min are not equal, we are pushing the current min to the stack for future purpose(this may be our min in future)  
            min=val;// assigning value to the min
        }
        st.push(val);// pushing value to the stack
    }
    
    public void pop() {//to pop element from the stack
        int ele=st.pop();//popping element from stack assigning popped element to ele
        if(min==ele){//if minimum element if present in the top then 
            min=st.pop();
        }
    }
    
    public int top() {
        return st.peek();//returning top element 
    }
    
    public int getMin() {
        return min;//returning min element
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
