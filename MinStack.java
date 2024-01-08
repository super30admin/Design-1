// Time Complexity :o(1)
// Space Complexity :o(n)
// Did this code successfully run on Leetcode : Yess
// Any problem you faced while coding this : No

class MinStack {
    Stack<Integer> mainStack=new Stack<>();
    Stack<Integer> minStack=new Stack<>();
    
    public void push(int val) {
        mainStack.push(val);
        if(minStack.isEmpty()||mainStack.peek()<=minStack.peek()){
            minStack.push(val);
        }    
    }
    
    public void pop() {
        
        if(mainStack.peek().equals(minStack.peek())){
            minStack.pop();
        }
        mainStack.pop();
    
    }
    
    public int top() {
        return mainStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}