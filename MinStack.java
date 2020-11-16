// Time Complexity :  O(1)
// Space Complexity : O(N)  N-> Number of elements
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
 
import java.util.Stack;

public class MinStack{
	
	/*declare two stacks stack and minstack*/

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public MinStack() {        
    }
    
    public void push(int x) {
    	//pushing all the elements into stack
    	//pushing into minstack only if the new element is smaller than the previous element or if it's empty
        stack.push(x);
        if(minStack.isEmpty() || x<=minStack.peek()){
            minStack.push(x);
        }
    }
    
    public int pop() {
    	//if the top of the minstack equals the 
        if(stack.peek() == minStack.peek()){
           return minStack.pop();
        }

       return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }

	public static void main(String[] args) {
    MinStack obj = new MinStack();
    obj.push(-2);
    obj.push(0);
    obj.push(-3);
    obj.pop();
    int param_3 = obj.getMin();	
    System.out.println("Minimum : "+param_3);    
    obj.pop();
    int param_5 = obj.getMin();	
    int param_4 = obj.top();
    System.out.println("Top: "+param_4);
    System.out.println("Minimum after popping -3: "+param_5);
    
	}
}