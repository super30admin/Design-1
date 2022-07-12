// Time Complexity :1
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :
//this is new commeng-------------------

class MinStack {
    //creating two stacks
    Stack<Integer> st=new Stack<>();
    Stack<Integer> minStack=new Stack<>();
    //creating an integer which is initialised with the largest value or we can say infinity
    int min=Integer.MAX_VALUE;
    
    /** initialize your data structure here. */
    public MinStack() {
        //min is pushed in minstack initially
        minStack.push(min);
        
    }
    
    public void push(int x) {
        //push x in st
        st.push(x);
        //if x is smaller,set min to x
        if(x<min){
        min=x;
        }
        //push min in the minStack
        minStack.push(min);
    }
    
    public void pop() {
        //we pop an element from st
        st.pop();
        //everytime we pop an element from st, we pop one element from minStack as well
        minStack.pop();
        //min is set to peek of minStack as it contains min corresponding to the elements in st(one to one relationship)
        min=minStack.peek();
        
    }
    
    public int top() {
        //we simply return the peek element
        return st.peek();
        
    }
    
    public int getMin() {
        //we return the min variable
        return min;
        
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