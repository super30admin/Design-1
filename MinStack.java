// 1st Solution
// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> st;
    Stack<Integer> minst;
    public MinStack() {
        st = new Stack<Integer>();
        minst = new Stack<Integer>();
    }
    
    public void push(int val) {
        st.push(val);
        if (minst.isEmpty() || val <= minst.peek())
        {
            minst.push(val);
        }
        

    }
    
    public void pop() { 
        if (st.peek().equals(minst.peek())){
            minst.pop();
        }
        st.pop();
        
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minst.peek();
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


// 2nd Solution
// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class MinStack {

    /** initialize your data structure here. */
    Node head;
    public MinStack() {
        this.head = null;        
    }
    
    public void push(int val) {
        if(this.head == null){
            this.head = new Node(val, val);
        }
        else{
            Node newNode = new Node(val, Math.min(val, head.min));
            newNode.next = head;
            head = newNode;
        }
        
    }
    
    public void pop() { 
        head = head.next;
        
    }
    
    public int top() {
        return head.data;
        
    }
    
    public int getMin() {
        return head.min;
    }
}

class Node{
    int data;
    Node next;
    int min;
    public Node(int data, int min){
        this.data = data;
        this.next = null;
        this.min = min;
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