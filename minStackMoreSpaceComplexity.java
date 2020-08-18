import java.util.Stack;
public class minStack{

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int min;

    /*  Explanation
    Time Complexity for operators : o(1)   
    Extra Space Complexity for operators : o(n) .. The problem is for stack that's why didnt considered staxck space  
    Did this code successfully run on Leetcode : No, 17/18 test cases passed with this approach. Only one test case failed.
    Any problem you faced while coding this : Need to take care of corner checks like stack empty etc.
    The implemntation consists of only two stack, the first stack will have all the elements whicl second will kepp track
    of minimum elemements.
    */


    public static void main(String args[]){
        minStack minstack = new minStack();
        minstack.push(10);
        minstack.push(5);
        minstack.pop();
        System.out.println(minstack.getMin());
    }   
    
    public minStack(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {

        if(x <= min){
            min = x;
            stack1.push(x);
            stack2.push(x);
        }else
            stack1.push(x); 
    }
    
    public void pop() {
        if(!stack1.isEmpty() && stack1.peek() == min){
            stack1.pop();
            stack2.pop();
            if(!stack2.isEmpty())
              min = stack2.peek();
        }else{
            stack1.pop();
        } 
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int getMin() {
        return min;
    }

}