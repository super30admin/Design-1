// Time complexity - push O(1), pop O(1)
// Space complexity- O(n)

// Using single stack to maintain stack elements and min as well.

class MinStack {

    Stack<Integer> minStack;
    int min;

    public MinStack() {
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }
    
    // Push operation maintains currents min and previous minimum
    public void push(int val) {
        if(val <= min){
            minStack.push(min);
            min = val;
        }
        minStack.push(val);
    }

    // pop operation     
    public void pop() {
        int popped = minStack.pop();
        if(popped == min){            
            min = minStack.pop();            
        }
    }
    
    public int top() {
        return minStack.peek();
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