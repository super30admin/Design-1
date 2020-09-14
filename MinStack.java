class MinStack {

    
    /// Two arrays takeen here min and stack array to implement Min Stack.
    // Stack array is kept for push and pop operation with help of top index 
    // min array is kept to get min with help of minpointer . every push operation will check if the top index is not out of    bound and 
    // the value x which is pushed is checked with min array whosever is minimum will be replaced and minpointer is incread.
    // Time Complexity : O(1) Space Complexity :O(n)
    
    int[] min;
    int[] stack;
    int top = -1;
    int minptr = -1;
       
    public MinStack() {
        min = new int[10000];
        stack = new int[10000];
    }
    
    public void push(int x) {
     
        if(top >= 10000){
         return ;
         }
        stack[++top] = x;
        
        if(minptr >=0){
            if(min[minptr] >x){
                min[++minptr] = x;
            }
            else{
                min[minptr+1] =min[minptr];
                minptr++;;
                
            }
        }else
            min[++minptr] = x;
        
    }
    
    public void pop() {
        if(top < 0){
            return;
        }
        top -= 1;
        minptr -= 1;
        
    }
    
    public int top() {
        return stack[top];
    }
    
    public int getMin() {
        return min[minptr];
    }
}