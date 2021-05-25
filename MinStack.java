  
// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Confused if I should use two stacks or one stack

class MinStack {

    /** initialize your data structure here. */
    Stack<Node> st;
    public MinStack() {
        st = new Stack<Node>();
    }
    
    public void push(int val) {
        if(st.size() == 0){
            st.push(new Node(val,val));
            return;
        }
        
       Node node = st.peek();
        if(node.min > val){
            st.push(new Node(val,val));
        }else{
            st.push(new Node(val,node.min));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().val;
    }
    
    public int getMin() {
        return st.peek().min;
    }
    
        
    class Node {
            int min, val;
            Node(int val, int min) {
                this.min = min;
                this.val = val;
            }
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
