
//Time complexity = O(1)
//Space = O(n)    
class MinStack {
    
    private Stack<Integer> s = new Stack<>();
    private Stack<Integer> minS = new Stack<>();

    public MinStack() {  
    }
    
    public void push(int val) {
        
        s.push(val);
        if(minS.isEmpty() || minS.peek()>=val)
        {
            minS.push(val);
        }
        
    }
    
    public void pop() {
        
        if(minS.peek().equals(s.peek()))
        {
            minS.pop();
            
        }
        
        s.pop();
       
        
    }
    
    public int getMin() {
        return minS.peek();
    }
    
    public int top() {
        
       return s.peek();
        
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