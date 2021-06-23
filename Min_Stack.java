class MinStack {
    
    int min; //stores the minimum value in the stack
    Stack<Integer> minval;//stores the minimum value for element added or popped
    Stack<Integer> myS;// stores the elements in the stack

    /** initialize your data structure here. */
    public MinStack() {
        minval= new Stack<Integer>();
        myS = new Stack<Integer>();
    }
    
    public void push(int val) {
        //checking if the stack is empty
        if(myS.isEmpty()==true)
        {
            min = val;
        }
        else{
            if(val<min)
            {
                min = val;
            }
        }
        myS.push(val);
        minval.push(min);
        
    }
    
    public void pop() {
        if(myS.isEmpty()!=true)
        {
            myS.pop();
            minval.pop();
            if(minval.isEmpty()!=true)
            {
                min = minval.peek();
            }
        }
        
    }
    
    public int top() {
        return myS.peek();        
    }
    
    public int getMin() {
        return minval.peek();
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


 //The time complexity for all the operations is O(1) as required
 // For the space complexity I am creating 2 stacks to store n elements so O(n) + O(n) = O(n)
