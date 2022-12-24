// Time Complexity : 0(1)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Approach: We can have 2 stacks, 1 stack for the actual data and another stack to maintain the minimum required (minStack)
// When we push one element to the main Stack, we check if that element is the minimum, if it is, we push that element to minStack also
// When we pop the element from the main Stack, we also pop the top element from the min Stack and set the new minimum to the new top element
// in the minstack which we got after pop.

class MinStack_Approach1 {
    
    private Stack<Integer> st;
    private Stack<Integer> minSt;
    private int min;
    
    public MinStack() {
        this.min=Integer.MAX_VALUE; //infinty
        this.st=new Stack<>();
        this.minSt= new Stack<>();
        minSt.push(min); //push infinity at bottom of stack
    }
    
    public void push(int val) {
        st.push(val);
        min = Math.min(min,val); //find minimum
        minSt.push(min);
    }
    
    public void pop() {
        st.pop();
        minSt.pop();
        min=minSt.peek(); //return top of minstack after popping
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }
}