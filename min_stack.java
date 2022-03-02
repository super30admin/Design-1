class MinStack {

    ArrayList<Integer> arr;
    
    public MinStack() {
        
        arr = new ArrayList<>();
    }
    
    public void push(int val) {
        
        arr.add(0,val);
    }
    
    public void pop() {
        
        arr.remove(0);
    }
    
    public int top() {
        
        return arr.get(0);
    }
    
    public int getMin() {
        
        int min = Integer.MAX_VALUE;
        
        for(int i=0;i<arr.size();i++)
        {
            if(min>arr.get(i))
            {
                min = arr.get(i);
            }
        }
        
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