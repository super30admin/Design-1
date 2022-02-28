import java.util.Stack;

// Time Complexity : Push, Pop, getMin() : O(1)
// Space Complexity : O(1)


// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
/*
When min from Stack will be at top and if we pop an element then it caused the wrong reuslt for getMin().
Then I pushed the min element if the new element to insert is less than current min element. So, whenever Min is at top and if we pop that element we don't get the wrong output

*/


// Your code here along with comments explaining your approach

/*
Created stack using java.util inbuilt stack and one min variable to get min from stack in O(1) in future.

For push() : As I said in my problem which is fixed now, I pushed the min element if the new element to insert is less than current min element. 
If the new value is not less than current min then simply pushed into stack

For pop() : Simply popped the element from stack. If this element is min then again pop element and set that as min element.

For top() : Element stored at top returned using peek() of Stack.

For getMin() : Returning the value of min variable.
*/



class SplStack {
    Stack<Integer> stack;
    int min;
    public SplStack() {
        stack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        
        if(val <= min){
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }
    
    public void pop() {
        int element = stack.pop();
        if(element == min){
            min = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
}


public class Design1_Problem2{
    public static void main(String args[]){
        SplStack stack = new SplStack();
        stack.push(-2); stack.push(0); stack.push(-3);

        System.out.println("GetMin() : " + stack.getMin());

        stack.pop();
        System.out.println("Top() : " + stack.top());
        System.out.println("GetMin() : " + stack.getMin());

    }
}
