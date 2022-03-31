import java.util.*;

/*
    Implementation is done using Stack. 
    A variable min is used to keep track of minimum value whenever a number is 
    pushed into the stack.
    Time Complexity of push,pop,top,getMin = O(1)
    
*/
public class MinStack {
    Stack<Integer> stack;
    int min;
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val<=min){
            stack.push(min);
            min=val;
        }
        stack.push(val);
    }
    
    public void pop() {
        if(stack.pop()==min)
        {
            min=stack.pop();
        }
    }
    
    public int top() {
        
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }

    public static void main(String args[])
    {
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println(stack.getMin());
        stack.pop();
    }
}