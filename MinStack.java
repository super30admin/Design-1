// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class MinStack {
    Stack<Integer> minstack = new Stack<>();
    Stack<Integer> stack = new Stack();
    int top;
    
    public MinStack() {
        top=-1;    
    }
    
    public void push(int x) {
        stack.push(x);
        if(minstack.isEmpty() || x<=minstack.peek()){
            minstack.push(x);
        }
    }
    
    public void pop() {
        if(minstack.peek().equals(stack.peek()))
            minstack.pop();
        stack.pop();
    }
    
   public boolean isEmpty(){
        if(top==-1)
              return true;
        return false;
  }
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}
