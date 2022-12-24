// Time Complexity : push, pop, top, getMin all run in constant time O(1)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : null pointer assignment errors


// Your code here along with comments explaining your approach

// I am using a data structure similar to a linkedlist to solve this problem. 
// Each node in the stack will contain - data, min value until that point & pointer to prev node.
// Additional node is used to keep track of top of stack.

class MinStack {
    class StackNode{ 
        int data;
        int min; //keep track of min value until this node
        StackNode prev; //pointer to prev node
        StackNode(){
            data=Integer.MAX_VALUE;
            min=Integer.MAX_VALUE;
            prev=null;
        }
        StackNode(int data){
            this.data = data;
        }
    }
    StackNode top; //pointer to top of stack
    int size;

    public MinStack() {
        top = new StackNode();
        size =0;
    }
    
    public void push(int val) {
        StackNode newNode = new StackNode(val);
        if(size==0) //if stack is empty min value will be the new node's value
        {
            newNode.min = val;
            newNode.prev = null;
        }
        else{ //else compare the new node's value with min value computed till now
            newNode.min = top.min < val ? top.min : val; 
            newNode.prev = top;
        }
        top = newNode;
        size++;
    }
    
    public void pop() {
        StackNode temp = top;
        top = temp.prev;
        temp = null;    
        size--;  
    }
    
    public int top() {
        return top.data;
    }
    
    public int getMin() {
        return top.min;
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