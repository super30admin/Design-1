//Time Complexity => for all operations push(), pop(), top(), getMin() = O(1)
//Space Complexity = O(n) where n is size of the stack

//MinStack is being implemented at granular level without using any in built stack functions


class MinStack {
    
    //Top of the stack or last entered element in the stack(LIFO)
    StackNode top;

    //basic structure of element in the stack
    class StackNode { 
        
        //holds value of the data pushed to stack
        int val;
        //holds minimum value of data pushed till that particular entry in the stack
        int min;
        //holds link to the previous element pushed to the stack
        StackNode prev;
        StackNode(int val) 
        { 
          this.val = val;
          this.prev = null;
        } 
    }
    
    public MinStack() {        
        //Initializing stack to empty top
        top = null;     
    }
    
    public void push(int val) {
        
        //create a new StackNode
        StackNode temp = new StackNode(val);
        
        //if no value is pushed till now, value which is going to be pushed will be the minimum else update the minimum upto this  entry by check top.min and temp.min
        if(top != null){
           if(top.min > val) temp.min = val;
            else temp.min = top.min;
        } else temp.min = val;
        
        //link newly pushed entry to previous element 
        temp.prev = top; 
        //move top to latest entry
        top = temp;
       
    }
    
    public void pop() {
        
        //move top top previous entry
        top = top.prev;
        
    }
    
    public int top() {
       //return value at the top 
       return top.val; 
    }
    
    public int getMin() {
        //return min value if stack is not empty else return max value of integer 
        return (top == null ?  Integer.MAX_VALUE : top.min);
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
