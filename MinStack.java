//time complexity for each function is o(1) and space complexity is o(n) because we are using another stack
class MinStack {
    int[] stack;
    int[] minstack;
    int top1;
    int top2;
    int max=3000;

    public MinStack() {
       stack = new int[max];
       minstack = new int[max]; 
       top1=-1;
       top2=-1;
    }
    
    public void push(int val) {
    if (top1 == max - 1) {
        return;
    }
    top1++;
    stack[top1] = val;
    if (top2 == -1 || val <= minstack[top2]) {
        top2++;
        minstack[top2] = val;
    }
}
    
    public void pop() {
        if(top1==-1) return;
        int val = stack[top1];
        top1--;
        if(top2==-1) return;
        if(val == minstack[top2])
        {
            top2--;
        }
        
    }
    
    public int top() {
        return stack[top1];
        
    }
    
    public int getMin() {
        int min1 = top();
        int min2=Integer.MAX_VALUE;
        if(top2 >-1)
        {
            min2 = minstack[top2];
        }
        

        if(min1 < min2)
        {
            int min = stack[top1];
            top1--;
            return min;
        }
        else{
            int min = minstack[top2];
            
            return min;
        }
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