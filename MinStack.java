// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes. 
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach
class MinStack {
    
    /* Root Node = Top Node of stack*/ 
    StackNode root;
    
    /* Each node in stack will store data, minimum value in stack at each node/stage and pointer to next node */ 
    static class StackNode{
        int data,minData;
        StackNode next;
        
        StackNode(int data){
            this.data = data;
            this.minData = data;
        }
    }
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int val) {
    	/* Create new node for push */
        StackNode newNode = new StackNode(val);
        
        /* First ever node to be inserted in Stack */
        if(root == null){
            root = newNode;
        }
        else{
        	/* Check  if new node is coming in with a smaller value */
            if(root.minData <= newNode.data){
                newNode.minData = root.minData;
            }
            /* Adding new node to stack */
            StackNode temp = root;
            root = newNode;
            root.next = temp;
        }
    }
    
    public void pop() {
    	/* Pop top  most node from stack by realigning root pointer*/
        root = root.next;
    }
    
    public int top() {
    	/* Return data of root/top node of stack */
        return root.data;
    }
    
    public int getMin() {
    	/* return minData value of root/top node of stack*/
        return root.minData;
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