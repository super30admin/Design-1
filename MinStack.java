import java.util.Stack;

class MinStack {

    /** initialize your data structure here. */
    Stack<MinStackNode> minStack;

    public MinStack() {
        minStack = new Stack<MinStackNode>();    
    }
    
    public void push(int x) {
        
        int minValue = Math.min(x, getMin());
        MinStackNode tempNode = new MinStackNode(x, minValue);
        minStack.push(tempNode);
    }
    
    public void pop() {
        minStack.pop();
    }
    
    public int top() {
        return minStack.peek().value;
    }
    
    public int getMin() {
        if(minStack.isEmpty()){
            return Integer.MAX_VALUE;
        }else{
            return minStack.peek().min;
        }
    }
}


class MinStackNode{
    
    public int value;
    public int min;
    
    MinStackNode(int value, int min){
        this.value = value;
        this.min = min;
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