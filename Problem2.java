/* This code is submitted in Leetcode successfully and time complexity is O(N) => O(InputSize) and Space Complexity is again O(2N) ~ O(N) */ 

class MinStack {
    //Global Minimum which actually refers to current status of minimum
    int global_minimum = Integer.MAX_VALUE;
    
    /** initialize your data structure here. */
    Stack<Integer> s = new Stack<>();
    public MinStack() {
        //This is optional as I handled in push scenario
        //s.push(global_minimum);
    }
    
    public void push(int x) {
        if(x <= global_minimum){
            //change global minimum
            s.push(global_minimum);
            s.push(x);
            global_minimum = x;
        }else{
            //no change in global minimum
            s.push(x);
        }
    }
    
    public void pop() {
        if(!s.isEmpty()){
            //Pop first element of the stack
            int check_value = s.pop();
            //compare with the global minimum to see if it needs to be updated
            if(check_value <= global_minimum){
                //change global minimum
                global_minimum = s.pop();
            }
                
        }
    }
    
    public int top() {
        if(!s.isEmpty()){
            return s.peek();
        }
        return -1;
        
    }
    
    public int getMin() {
        return global_minimum;
        
    }
}


