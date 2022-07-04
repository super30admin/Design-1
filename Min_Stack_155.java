import java.util.*;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
 */
public class Min_Stack_155 {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minstack = new Stack<>();

    public Min_Stack_155(){}

    public void push(int x){
        stack.push(x);
        if(minstack.isEmpty() || (x <= minstack.peek())){
            minstack.push(x);
        }
    }

    public void pop(){
        if(stack.peek().equals(minstack.peek())){
            minstack.pop();
        }
        stack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minstack.peek();
    }
public static void main(String[] args) {
    Min_Stack_155 obj = new Min_Stack_155();
    int x = 0;
    obj.push(1);
    obj.push(2);
    obj.push(1);
    obj.push(-1);
    obj.pop();
    int param_3 = obj.top();
    int param_4 = obj.getMin();
    System.out.println("Stack : "+ obj);
    System.out.println("top value : "+ param_3);
    System.out.println("get min value : "+ param_4);
}
}
