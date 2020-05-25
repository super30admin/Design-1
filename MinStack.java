import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Did not get the logic to solve isFull() 

// Your code here along with comments explaining your approach
public class MinStack{

    public Stack<Integer> stack1;
    public Stack<Integer> stack2;
    // initialize stack in the min stack constructor
    public MinStack(){
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    // Push method
    // Here we maintain stack 2's top element as the minimum element
    public void push(int x) {
        if(stack1.empty()){
            stack1.push(x);
            // As Stack 1 is empty there is no minimun element yet
            stack2.push(x);
        }
        else{
            stack1.push(x);
            stack2.push(Math.min(stack2.peek(), x));
        }
    }

    //Checking if the stack is empty if yes will return -1, if not will pop an element from stack1
    public void pop(){
        if(stack1.empty()){
            System.out.println("Stack Underflow");
            
        }
        else if(stack1.peek() == stack2.peek()){
            stack2.pop();
            stack1.pop();
        }
        else{
            stack1.pop();
        }
    }

    //Checking if the stack is empty if yes will return true else false
    public boolean isEmpty(){
        if(stack1.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    //returning the top element from stack 1
    public int top() {
        return stack1.peek();
    }

    // Checking if the stack is empty if yes will return -1 else will peek the top minimum element from stack2 as maintained in push() method
    public int getMin(){
        if(stack1.isEmpty()){
            System.out.println("Stack underflow / Stack is empty");
            return -1;
        }
        else{
            return stack2.peek();
        }
    }

    // driver
    /**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}