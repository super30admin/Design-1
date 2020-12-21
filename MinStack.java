// Time Complexity : O(1), push, pop, top and getMin are all constant time operations
// Space Complexity : O(n1) + O(n2) , as we are using 2 stacks to  save the elements
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


import java.util.Stack;

public class MinStack {
    //will make use of 2 stacks
    //Stack1, to retrieve or push elements(normal stack operations)
    //stack2 to maintain the minimum element inserted into the stack till now

    Stack<Integer> stack;
    Stack<Integer> minStack;


    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);

        //to insert this element in minStack
        //first check if the current elements is < top of the minstack, if yes only then insert
        if (minStack.isEmpty() || minStack.peek() >= x){
            minStack.push(x);
        }
    }

    public void pop(){
        //if the top element of both the stacks is same, then pop both, else pop from only stack
        if (minStack.peek(). equals(stack.peek())){
            minStack.pop();
            stack.pop();
        }else{
            stack.pop();
        }

    }

    public int top(){
        return stack.peek(); //returns the top element of stack
    }
    public int getMin(){
        return minStack.peek(); //return the top element of minstack, as it contains the minimum element
    }

    public static void main(String[] args) {
        MinStack minstack = new MinStack();
        minstack.push(10);
        minstack.push(20);
        minstack.push(30);
        minstack.push(4);
        minstack.pop();

        System.out.println("Minimum element is : " + minstack.getMin());

    }
}

