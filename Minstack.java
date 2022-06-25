//Time complexity=O(1) for pushing,popping and returning the minimum value.
//Space complexity=O(2N) for creating stacks
class MinStack {
    //intializing two stacks
private Stack<Integer> s;
    private Stack<Integer> minstack;
    int mini;
    public MinStack() {
        mini=Integer.MAX_VALUE;
        //creating a  two new stacks for pushing elements
        s=new Stack();
        minstack=new Stack();
        //to prevent the edge case of popping all the elements in minstack
        minstack.push(mini);
        
    }
    
    public void push(int val) {
       mini=Math.min(mini,val); 
        //Pushing the elements into the stack
           s.push(val);
           minstack.push(mini);
    }
    
    public void pop() {
        //Popping the elements from both the stacks.
        s.pop();
            minstack.pop();
        mini=minstack.peek();
    }
    
    public int top() {
        //Returns the top element
        return s.peek();
    }
    
    public int getMin() {
        //Gets the minimum element
        return mini;
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