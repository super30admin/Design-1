// Time Complexity : O(1) for all operations
// Space Complexity : O(n) for the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class MinStack {
    Stack<Integer> stk;   //single stack 
    int min;
    public MinStack() {
        stk=new Stack<>();
        min=Integer.MAX_VALUE;
    }
    
    public void push(int val) {    //push both the ele and previous min
        if(min>=val){               //only updated min is stored in minstk
            stk.push(min);
            min=val; 
        }
        stk.push(val);
    }
    
    public void pop() {
        int temp=stk.pop();
        if(temp==min){          //if popped element is min, then pop the previous min and update min
            min=stk.pop();
        }
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return min;
    }
}
