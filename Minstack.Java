Question 2) Min stack
class MinStack {
    int min;
    Stack<Integer> a;

    public MinStack() {
        min=Integer.MAX_VALUE;
        a=new Stack<Integer>();
    }
    
    public void push(int val) {
        if(val<=min){
            a.push(min);
            min=val;
        }
        a.push(val);
        
    }
    
    public void pop() {
        int x=a.pop();
        if(x==min){
            min=a.pop();
           
        }
        
    }
    
    public int top() {
        return a.peek();
        
    }
    
    public int getMin() {
        return min;
        
    }
}
