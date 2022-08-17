/*Time Complexity O(1) push pop top getmin
Space Complecity O(n) for all operation
approach map each entries with minimum in the other stack
*/
import java.util.Stack;

class MinStack {
Stack<Integer> a;
Stack<Integer> b=new Stack<Integer>();
int min;
    public MinStack() {
        a = new Stack<Integer>();
        b= new Stack<Integer>();
        min=Integer.MAX_VALUE;
    }
    
    public void push(int val) {
   
    if(a.isEmpty()){
        a.push(val);
        b.push(val);
        min=val;
    }
    else{
        if(b.peek()>=val){
            min=val;
            a.push(val);
            b.push(val);
        }
        else{
            a.push(val);
            b.push(min);
        }
    }
    }
    
    public void pop() {
        a.pop();
        b.pop();
        if(b.isEmpty()){
            min=Integer.MAX_VALUE;
            return;
        }
        min=b.peek();
    }
    
    public int top() {
        return a.peek();
    }
    
    public int getMin() {
        return b.peek();
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