import java.util.Stack;
//time complexity O(1)
//space complexity O(n)
class MinStack {

    /** initialize your data structure here. */

    Stack<Integer> stack;
    Stack<Integer> minstack;
    int min,temp;
    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack<>();
        minstack=new Stack<>();
    }
    
    public void push(int val) {
        if(minstack.isEmpty()||val<=minstack.peek())
        {
            minstack.push(val);
        }
        stack.push(val);
        
    }
    
    public void pop() {
        if(stack.peek().equals(minstack.peek()))
        {
            minstack.pop();

        }
        stack.pop();


    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */