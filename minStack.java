//Time Complexity : O(1)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : no
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> s1 = new Stack<>();
    int min;
    public MinStack() {
        
    }
    
    public void push(int val) {
        
        if(!s1.isEmpty() && val <= min){
            
            s1.push(min);
            s1.push(val);
            min = s1.peek();
        }
        
        else if(s1.isEmpty()){
            
            s1.push(val);
            min = s1.peek();
        }
        
        else s1.push(val);
        
        //System.out.println(s1);
    }
    
    public void pop() {
        
        int temp = s1.pop();
        
        if(temp == min && !s1.isEmpty()){
            
            min = s1.pop();
            
        }
        
    }
    
    public int top() {
        
        return s1.peek();
        
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