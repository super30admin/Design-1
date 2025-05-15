import java.util.Stack;
class MinStack {
    public Stack<Integer> stack;
    public Stack<Integer> min;
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(min.isEmpty() || val <= min.peek()){
            min.push(val);
        }
    }
    
    public void pop() {
        if(stack.peek().equals(min.peek())){
            min.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min.peek();
    }

  public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(5);
        System.out.println("Push 5, Min: " + minStack.getMin());

        minStack.push(3);
        System.out.println("Push 3, Min: " + minStack.getMin());

        minStack.push(7);
        System.out.println("Push 7, Min: " + minStack.getMin());

        minStack.push(2);
        System.out.println("Push 2, Min: " + minStack.getMin());

        System.out.println("Top element: " + minStack.top());

        minStack.pop();
        System.out.println("Popped, Min: " + minStack.getMin());

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