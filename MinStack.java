//Time Cost :
// push - O(1) on average, O(n) when overflow occurs
// pop, top, getMin - O(1)

//Space Cost :
//Worst case - O(n) when items are pushed like 5,4,3,2,1,.. due to support stack

class MinStack {
    int[] stack;
    int[] supportStack;
    int stackTop, supportStackTop;
    int DEFAULT_CAPACITY;
    
    /** initialize your data structure here. */
    public MinStack() {
        DEFAULT_CAPACITY = 16;
        stack = new int[DEFAULT_CAPACITY];
        supportStack = new int[DEFAULT_CAPACITY];
        stackTop = -1;
        supportStackTop = -1;                
    }
    
    public int[] resize(int[] stack) {
        int[] resizedStack = new int[stack.length * 2];
        System.arraycopy(stack, 0, resizedStack, 0, stack.length);
        return resizedStack;
    }
    
    public void push(int x) {
        if(stackTop == stack.length - 1 || supportStackTop == supportStack.length - 1)
        {
           //handle overflow here
            stack = resize(stack);
            supportStack = resize(supportStack);
            
        }
        if(supportStackTop == -1 || x <= supportStack[supportStackTop])
        {
            supportStack[++supportStackTop] = x;
        }
        stack[++stackTop] = x;  
    }
    
    public void pop() {
        //handle underflow exception if either top is -1 when pop() is called
        //soft delete
        if(top() == getMin())
        {
            supportStackTop--;
        }
        stackTop--; 
    }
    
    public int top() {
        return stack[stackTop];
    }
    
    public int getMin() {
        return supportStack[supportStackTop];
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
