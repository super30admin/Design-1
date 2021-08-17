// Time Complexity : o(1)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes (confused in space complexity according to my understanding
// I am using a stack to store n values given by the user hence the space complexity is o(n) 
// is my understanding correct? 
import java.util.Stack;

public class MinStack {

   
   Stack<Integer> minstack= new Stack<Integer>();;
   private static int min = Integer.MAX_VALUE;
    public MinStack() {
    }
    // push value in stack
    public void push(int val) {
       if(val<=min){
           minstack.push(min);
           min = val;
       }      
       minstack.push(val);
    }
    // removes topmost element
    public void pop() {
        if(minstack.pop()== min){
            min=minstack.pop();
        }
        
    }
    // return topmost element but doesnt remove it
    public int top() {
        return minstack.peek();
    }
    //returns the minimum value in stack
    public int getMin() {
        return min;
    }

    public static void main(String[] args){
        MinStack stack = new MinStack();
        stack.push(-1);
        System.out.println(stack.top());
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());

    }
}