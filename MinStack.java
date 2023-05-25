import java.util.Stack;
/*
 * Approach here is to maintain two stacks, one stack will store/push all values give by user
 * where as the minStack will only push the value <= current minimum element. With this we can 
 * easily go back to the previous min element if the current min is removed from the main stack.
 *
 * Time Complexity :
 * push(), pop(), min() - O(1)
 * 
 * Space Complexity :
 * Space complexity is O(2N)
 * Did this code successfully run on Leetcode : yes
 * 
 * Any problem you faced while coding this : Tried to implement without extra space by pushing 2*val-min
 * into the stack and updating the minElement. But failed to handle edge cases for large integers (multiplied by 2)
 *
 */
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        this.stack=new Stack<Integer>();
        this.minStack=new Stack<Integer>();
    }
    
    public void push(int val) {
        if(stack.isEmpty())
            {
                stack.push(val);
                minStack.push(val);
                return;
            }

        if(val<=minStack.peek()){
                stack.push(val);
                minStack.add(val);
            }

        else{
                stack.push(val);
        }
    }
    
    public void pop() {
        if(minStack.peek().equals(stack.peek()))
        {
            stack.pop();
            minStack.pop();
        }
        else
            stack.pop();
    }
    
    public int top() {
        return (stack.peek());
    }
    
    public int getMin() {
        return minStack.peek();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack minStack = new MinStack();
		minStack.push(2147483646);
		minStack.push(2147483646);
		minStack.push(2147483647);
		minStack.top(); 
		minStack.pop();
		minStack.getMin(); 
		minStack.pop();
		minStack.getMin(); 
		minStack.pop();
		minStack.push(2147483647);

		minStack.top();    
		minStack.getMin(); 
		minStack.push(-2147483648);

		minStack.top();    
		minStack.getMin(); 
		minStack.pop();
		minStack.getMin(); 
	}
}
