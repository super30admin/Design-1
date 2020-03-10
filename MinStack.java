Time Complexity: O(1)
Space Complexity: O(n)


class MinStack {

    Stack<Integer> stack1,stack2;
    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
        
        if(stack2.isEmpty())
            stack2.push(x);
        else
            stack2.push(Math.min(stack2.peek(),x));
    }
    
    public void pop() {
        stack1.pop();
        stack2.pop();
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int getMin() {
        return stack2.peek();
    }
}
