// time complexity = O(1)
// space complexity = O(n)
class MinStack {
    Stack<Integer> currStack;
    Stack<Integer> minStack;
    int min;

    public MinStack() {
        currStack = new Stack<>();
         minStack = new Stack<>();
         min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val<min){
            min=val;
        }
        currStack.push(val);
        minStack.push(min);
    }
    
    public void pop() {
        currStack.pop();
        minStack.pop();
        if(minStack.isEmpty()==false) min=minStack.peek();
    }
    
    public int top() {
        return currStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
