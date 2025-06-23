// Time Complexity 
// push(val)	O(1)
// pop()	    O(1)
// top()	    O(1)
// getMin()	    O(1)
// Space Complexity 
// push(val)	O(n)
// pop()	    O(n)
// top()	    O(n)
// getMin()	    O(n)

class MinStack {
    Stack <Integer> s;
    Stack <Integer > minstack ;
    int min;
    public MinStack() {
        s= new Stack<>();
        minstack = new Stack<>();
        min = Integer.MAX_VALUE;
        minstack.push(min);
    }
    
    public void push(int val) {
        min = Math.min(val,min);
        s.push(val);
        minstack.push(min);
    }
    
    public void pop() {
        s.pop();
        minstack.pop();
        min = minstack.peek();
    }
    
    public int top() {
        return s.peek();
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