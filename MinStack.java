// Time Complexity :O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :mapping the the midpoint element to matrix.


// Your code here along with comments explaining your approach

//Below is the approach by using two stacks.In one stack we will insert the values and in the other stack we will map the min 
//value.So that whne we pop out an element an it is the minimum element in that case we also remove the min element from our stack.
class MinStack {
    Stack<Integer> st;
    Stack<Integer> minStack;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        st=new Stack<Integer>();
        minStack=new Stack<Integer>();
        min=Integer.MAX_VALUE;
        minStack.push(min);
    }
    
    public void push(int x) {
        if(x<min){
           min=x;
        }
        minStack.push(min);
        st.push(x);
    }
    
    public void pop() {
        st.pop();
        minStack.pop();
        min=minStack.peek();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
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
 
 
 ///below is also a an approach by creating a linked list.
 class MinStack {
    Node head;
    
    class Node{
        int data;
        Node next;
        Node(int d){
            this.data=d;
            this.next=null;
        }
    }

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        Node newNode=new Node(x);
        if(head==null){
            head=newNode;
        }else{
            newNode.next=head;
            head=newNode;
        }
        
    }
    
    public void pop() {
        Node temp=head;
        head=temp.next;
        temp.next=null;
    }
    
    public int top() {
        Node temp=head;
        return temp.data;
    }
    
    public int getMin() {
        int min=Integer.MAX_VALUE;
        Node temp=head;
        while(temp!=null){
            if(temp.data<min){
                min=temp.data;
                
            }
            temp=temp.next;
        }
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
 //ths single stack solution
 class MinStack {
    Stack<Integer> st;
    Integer min;
    /** initialize your data structure here. */
    public MinStack() {
        st=new Stack<Integer>();
        min=Integer.MAX_VALUE;
        st.push(min);
    }
    
    public void push(int x) {
        if(x<=min){
            st.push(min);
            min=x;
        }
        st.push(x);
    }
    
    public void pop() {
        int temp=st.pop();
        if(temp==min){
            min=st.pop();
        }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
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