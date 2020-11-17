import java.util.Stack;

class MinStack {

    //Initializing two stacks
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int x) {
        //push to min stack when minstack is empty or if the top element in the stack is greater than x
        if(minStack.isEmpty() || x<=minStack.peek()){
            minStack.push(x);
        }
        stack.push(x);
    }
    
    public void pop() {
        //if the top elements of both the stack are equal remove both or else just remove from the original stack
        if(stack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        //top element of the original stack
        return stack.peek();
    }
    
    public int getMin() {
        //top element of the min stack
        return minStack.peek();
    }
}
