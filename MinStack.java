// Time Complexity : O(1)
// Space Complexity : O(n)
// executed successfully on Leetcode :

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min ;
    
    
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack= new Stack<>();
        this.min = Integer.MAX_VALUE; 
        this.minStack.push(min);
        
    }
    
    public void push(int val) {
        //Push elements on both the stack but maintain minimum element in second array
        min = Math.min(min, val);
        stack.push(val);
        minStack.push(min);

    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        //after popping top element from both the stacks, maintain next min element (next element on peek)
        min = minStack.peek();

    }
    
    public int top() {
       return stack.peek();
        
    }
    
    public int getMin() {
        //return top element from min stack i.e min
       return minStack.peek();
    }
}