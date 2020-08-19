import java.util.Stack;

/*  Explanation
    Time Complexity for operators : o(1)   
    Extra Space Complexity for operators : o(1) .. The problem is for stack that's why didnt considered staxck space  
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
    The implemntation consists of only one stack, the stack will will push the element twice if the element is lesser
    that on equal to the minimum value.
    At the time of pop. Pop from stack twice if the element is equal to the minimum
*/

public class minStack{

    Stack<Integer> stack;
    int min;



    public static void main(String args[]){
        minStack minstack = new minStack();
        minstack.push(10);
        minstack.push(5);
        minstack.pop();
        System.out.println(minstack.getMin());
    }   
    
    public minStack(){
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        if(x<=min){
            stack.push(x);
            min = x;
        }
        stack.push(x);

    }
    
    public void pop() {
        int popElement = stack.pop();
        if(min == popElement){
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