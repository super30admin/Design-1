import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach
//Approach: We created one stack and an integer variable min. 
//Now first we set the mininmum value as infinity. 
//Once a value is pushed, we check if that value is less than or equal to min. 
//If that is true then we first add the current min value to the stack and then we add the new value to the stack. 
//While popping, we use a similar approach where we check if the value being popped is the current minimum value. 
//If it is true then we pop that value as well as assign the next value (the old minimum value) as the current minimum value and pop the second value as well.

class MinStack {
    private Stack<Integer> stack;
    int min;

    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(min >= val)
        {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        if(min == stack.pop())
        {
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(5);
        obj.push(4);
        obj.push(12);
        obj.pop();
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println(param_3);
        System.out.println(param_4);
    }
    
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */