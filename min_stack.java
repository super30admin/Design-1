// We use two stacks to implement minStack. 1 stack is normal stack.
// the other stack only stores min values when new incoming value is less than top() value.
// for pop, we pop from first stack and check if the value is the same as top element of min stack and pop it if it is
// Time complexity: O(1)
// Space complexity : O(n) (linear - but we store min elements seperately so it might be O(2n) in worst case which is also linear - O(n)

class MinStack {
    Stack<Integer> minStack;
    Stack<Integer> stack;
    public MinStack() {
        minStack = new Stack();
        stack = new Stack();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.size() == 0){
            minStack.push(val);
        }
        else if(val<=minStack.peek()){
            minStack.push(val);
        }
    }
    
    public void pop() {
        int val = stack.pop();
        if (val==minStack.peek()){
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
