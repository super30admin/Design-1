class MinStack {
    
    static final int MAX = 1000000; 
    int top; 
    int a[] = new int[MAX];
    int min;

    /** initialize your data structure here. */
    public MinStack() {
       top = -1;
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        
        if (x <= min) {
            top = top + 1;
            a[top] = min;
             min = x;
        }
        top = top + 1;
        a[top] = x;
        
    }
    
    public void pop() {
        
        int poppedEle = a[top];
        top = top - 1;
        
        if (poppedEle == min) {
            min = a[top];
            top = top - 1;
        }
    
        
    }
    
    public int top() {
        
        return a[top];
        
    }
    
    public int getMin() {
        return min;
    }
}