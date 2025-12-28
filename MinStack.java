//Using two stacks: MainStack and MinStack
//Maintaing min variable.
//For every addition, pushing that value to mainStack. Caluclating minimum. And pushing that min to minStack which means min element for all the elements which present in Stack.
//While removing, removing from both the stacks and peeking the top element to min variable.
//getMin: returing min variable
//top: Peeking top element of mainStack.

//TC: O(1); SC:O(1)

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min=Integer.MAX_VALUE;
    

    public MinStack() {
        this.stack=new Stack<>();
        this.minStack=new Stack<>();
        minStack.push(min);
        
    }
    
    public void push(int val) {
        min=Math.min(min,val);
        stack.push(val);
        minStack.push(min);
        
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        min=minStack.peek();
       
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
      return min;
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
