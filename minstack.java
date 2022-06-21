// Time Complexity :O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : None


class MinStack {
    
    private Stack<Integer> s; //initialisng main stack
    private Stack<Integer> aux; //auxilliary stack to store min
    
    public MinStack() {
        s = new Stack<>();
        aux = new Stack<>();
        
    }
    //inserts given element to top of stack
    public void push(int val) {
        //push element to main stack
        s.push(val);
        //if aux stack is empty, push the given element
        if(aux.isEmpty())
        {
            aux.push(val);
        }
        else
        {   //push the given element if it is less than or equal to current min
            if(aux.peek()>=val)
            {
                aux.push(val);
            }
        }
            
    }
    // remove the top element from the stack
    public void pop() {
        if(s.isEmpty())
        {
            System.out.println("Stack Underflow!");
            System.exit(-1);
        }
        // remove top element from main stack
        int top = s.pop();
        // remove top element from aux stack only if it is min
        if(top==aux.peek())
        {
            aux.pop();
        }
    }
    // return the top element of the stack
    public int top() {
         return s.peek();
    }
    // returns the minimum element from the stack 
    public int getMin() {
        if(aux.isEmpty())
        {
            System.out.println("STack Underflow!");
            System.exit(-1);
            
        }
        
        return aux.peek();
    }
}
