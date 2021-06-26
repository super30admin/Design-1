package Design_One_155_Leetcode_MinStack;

import java.util.Stack;

class MinStackWithOneStack {

    /** initialize your data structure here. */
    Stack<Integer> data_stack, min_stack;
    int min;

    public MinStackWithOneStack()
    {
        data_stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val)
    {
        if(val <= min)
        {
            data_stack.push(min);
            min = val;
        }
        data_stack.push(val);
    }

    public void pop()
    {
        int temp = data_stack.pop();
        min = temp <= min ? data_stack.pop(): min;
    }

    public int top()
    {
        return data_stack.peek();
    }

    public int getMin()
    {
        return min;
    }
}


class Main_class
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




/**
 * Time Complexity for Push,Pop, peek and getting Minimum of the stack will be constant =  O(1);
 * Approach: I am using one stack here and checking if I get a value to be pushed less than or eual to minimum,
 * First I will push existing minimum to the stack, then pushing the actual value and so on!
 *
 * while poping, if element poped is less than of equal to the existing minimum; I will do the pop operation again and last poped value would be my new minimum.
 *
 * Here , I am using one stack only to avoid extra space what I have used in earlier approach of two stacks.
 */