// Time Complexity :o(1)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class MinStack {
    static final int MAX = 1000; 
    int top; 
    int minptr;
    int a[] = new int[MAX]; // Maximum size of Stack
    int min[]=new int[MAX];

    public MinStack() {
        top=-1;
        minptr=-1;
    }
    
    public void push(int val) {
         if(top==MAX-1){
        System.out.println("Stack is full");
        } else
        a[++top]=val;  
        if(minptr>=0){
            if(min[minptr]>val)
                min[++minptr]=val;
            else
            {
                min[minptr+1]=min[minptr];
                minptr+=1;
            }
            
        }
        
        else
            min[++minptr]=val;
    }
    
    public void pop() {
        minptr -= 1;
        top -= 1;
        
    }
    
    public int top() {
         return a[top];
    }
    
    public int getMin() {
        return min[minptr];
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
