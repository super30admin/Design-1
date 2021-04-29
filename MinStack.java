
//Time comp- o(1)- all methods
//space comp- o(n)
// Did this code successfully run on Leetcode : yes

//Please tell me if this is correct implementation for interview, 
//let me know if I need to implement using Stack only

//Problems faced- initializing head

class MinStack {
   
    class Node{
    int val;
    int min;
    Node prev;
        Node(int v, int m)
        {
            val = v;
            min = m;
        }
    }
    Node head;
    
    public MinStack() { 
        head= new Node(Integer.MIN_VALUE,Integer.MAX_VALUE);//dummy head
    }
    
    
    public void push(int x) {//o(1)
        Node n;
      if(head.val==Integer.MIN_VALUE){// making new node as head
          n = new Node(x,x);
      }
        else
        {
            int newMin = Math.min(x, getMin());
             n = new Node(x, newMin);//adding new node to minstack, with new val and new min
        }     
        n.prev= head;//setting new head
        head= n;
       
    }
    
    
    public void pop() {//o(1)
       head=head.prev;
    }
    
    
    public int top() {//o(1)
        return head.val;
       
    }
    
    
    public int getMin() {//o(1)
       return head.min;
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