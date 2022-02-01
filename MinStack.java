import java.util.Stack;
/*
Time Complexity : O(1) for all push, pop, top and getMin operation
Space Complexity : O(N) used one stack
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach

1. To implement minstack, I used data structure stack and Stack of int[] type is chosen to store at index 0 the number
inserted and the second index 1 will get the minimum value of the stack
2. The push method looks if the stack is empty or not, is that is empty for the first push we put the number on both the indexes
3. if stack is not empty we push the element at the index 0 and Minimum of the already existing element and current element
on 1st index
4. Pop, top operations remains same as that of stack
5. getMin method fetches the value from the peek element of the stack array positioned at 1st index.

 */
public class MinStack {
    Stack<int[]> stack;

    public MinStack(){
        stack = new Stack<>();
    }

    public void push (int num){
        if(stack.isEmpty()){
            stack.push(new int[]{num, num});
            return;
        }

        int currMin = stack.peek()[1];
        stack.push(new int[] {num, Math.min(currMin, num)});
    }

    public void pop(){
        stack.pop();
    }
    public int top(){
       return  stack.peek()[0];
    }

    public int getMin(){
        return stack.peek()[1];
    }

    public static void main(String[] args){
        MinStack minstack = new MinStack();
        minstack.push(10);
        minstack.push(20);
        minstack.push(5);
        minstack.push(15);
        minstack.pop();
        minstack.pop();

        System.out.println("Element on the top of the stack: "+minstack.top());
        System.out.println("Element with the minimum value: "+minstack.getMin());
    }
}
