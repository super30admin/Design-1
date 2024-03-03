// Problem 2:
//Design MinStack (https://leetcode.com/problems/min-stack/)

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes

class MinStack {
    Stack<Integer> stack=new Stack<>();
    Stack<Integer> minstack=new Stack<Integer>();
    public MinStack() {   
    } 
    public void push(int val) {
        stack.push(val);
        if(minstack.isEmpty() || minstack.peek()>=val)
        {
            minstack.push(val);
        }   
    }
    public void pop() {
        if(!stack.isEmpty())
        {
            if(stack.pop().equals(minstack.peek()) && !minstack.isEmpty())
            {
                minstack.pop();
            }
        }
    }
    public int top() {
        return stack.peek(); 
    }
    public int getMin() {
        return minstack.peek(); 
    }
}
