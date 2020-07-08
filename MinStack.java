/**Space Complexity: Stack space is a maximum of O(n) if you insert n elements into the stack.
 *Time Complexity:For all the operations - It is O(1).
 *Approach: I have designed the minstack based on the linked list approach.Whenever a new node is added, the head is changed to that node.I have updated the min then and there for O(1) retrival.
 *Runs on Leet code.
 Runs on leet code
 */
class MinStack {
     private Node head;
    /** initialize your data structure here. */
    public MinStack() {
       }
    public void push(int x) {
         if(head==null){
            head= new Node(x,x);
        }
        else{
            Node temp=head;
            head=new Node(x,Math.min(x,head.min),temp);
        }
        
    }
    
    public void pop() {
        head=head.next;
    }
    
    public int top() {
     return head.value;
    }
    
    public int getMin() {
        return head.min;
    }


class Node{
    int value;
    int min;
    Node next;
    private Node(int value,int min){
        this.value=value;
        this.min=min;
        this.next=null;
    }
    
    private Node(int value,int min,Node next){
        this.value=value;
        this.min=min;
        this.next=next;
        
    }
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
/**Space Complexity: Stack space is a maximum of O(2n)-> O(n) if you insert n elements which are in descending order O
 *Time Complexity:For all the operations - It is O(1).
 *Approach: I have designed the minstack based on the stack approach. The min is stored n a variable. Each time the min is changed, the orevious min is pushed first and then the current min to maintain the min when 'pop' is called.
 Runs on leet code
 */


class MinStack {
    Stack<Integer> st;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        st=new Stack<>();
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
        if(min==st.pop()){
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