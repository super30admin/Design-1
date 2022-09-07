//Time Complexity

// Push: O(1)
// pop: O(1)
// getMin: O(1)
// top: O(1)


// Space Complexity: O(n)

// Did this code successfully run on Leetcode : Yes


import java.util.Stack;

public class MinStack {
    private Stack<Integer[]> stack;

    public MinStack(){
        stack = new Stack<>();
    }

    public void push(int val){
        if(stack.isEmpty()){
            stack.add(new Integer[]{val, val});
        }
        else{
            int currentMin = stack.peek()[1];
            stack.add(new Integer[]{val, Math.min(val, currentMin)});
        }
    }

    public void pop(){
        stack.pop();
    }

    public int top(){
        return stack.peek()[0];
    }

    public int getMin(){
        return stack.peek()[1];
    }

    public static void main(String[] args) {
       MinStack minStack = new MinStack();
       minStack.push(-2);
       minStack.push(0);
       minStack.push(-3);
       System.out.println(minStack.getMin());
       minStack.pop();
       System.out.println(minStack.top());
       System.out.println(minStack.getMin());
    }

}
