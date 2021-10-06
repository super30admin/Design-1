
class MinStack {
    
    
    Stack<int[]> s = new Stack();
    int min_val = (int)Math.pow(2,31);
    
    
    public void push(int val) {
        
        // if(val < min_val){
        //     min_val = val;
        // }
        int[] array = new int[2];
        if (s.isEmpty()){
            array[0] = val;
            array[1] = val;
            
        }else{
            array[0] = val;
            array[1] = Math.min(s.peek()[1], val);
        }
       
        s.push(array);
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek()[0];
    }
    
    public int getMin() {
        return s.peek()[1];
        
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


//  space complexity is O(n)
// Time complexity for push, pop, top and getmin is o(1)