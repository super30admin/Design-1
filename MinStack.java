import java.util.Stack;

class MinStack {
    
    Stack<Integer> elements;
    Stack<Integer> minstack;
        
    /** initialize your data structure here. */
    public MinStack() {
        
        elements = new Stack<Integer>();
        minstack = new Stack<Integer>();
        minstack.push(Integer.MAX_VALUE);
        
    }
    
    public void push(int x) {
        elements.push(x);
        int min = Math.min(x,minstack.peek());
        minstack.push(min);
        
    }
    
    public void pop() {
        elements.pop();
        minstack.pop();
    }
    
    public int top() {
        return elements.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }



 public static void main(String[] args) {

    MinStack min = new MinStack();
    min.push(3);
    min.push(5);
    min.push(6);
    min.pop();
    min.getMin();

    
} 
    
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */