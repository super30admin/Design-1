package Design_One_155_Leetcode_MinStack;

import java.util.Stack;

public class MinStackusingTwoStacks {
    /** initialize your data structure here. */
    Stack<Integer> data_stack, min_stack;
    public MinStackusingTwoStacks()
    {
        data_stack = new Stack<Integer>();
        min_stack  = new Stack<Integer>();
        min_stack.push( Integer.MAX_VALUE);
    }

    public void push(int val)
    {
        if(val <= min_stack.peek())
        {
            min_stack.push(val);
        }
        else
            min_stack.push(min_stack.peek());

        data_stack.push(val);
    }

    public void pop()
    {
        data_stack.pop();
        min_stack.pop();
    }

    public int top()
    {
        return data_stack.peek();
    }

    public int getMin()
    {
        return min_stack.peek();
    }

}

class Main
{
    public static void main(String[] args)
    {
        MinStackusingTwoStacks obj = new MinStackusingTwoStacks();
        obj.push(6);
        obj.push(7);
        obj.push(2);
        obj.push(8);
        obj.pop();
        System.out.println("minimum is: "+obj.getMin());
        obj.pop();
        System.out.println("minimum is: "+obj.getMin());

        System.out.println("Top of the data stack : "+obj.top());
        System.out.println("Minimum of the stack: "+obj.getMin());

    }
}
