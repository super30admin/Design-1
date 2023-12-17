/*
*Approach -  maintain two stacks , one for data and other for min. 
* 1:1 mapping each time for every push and pop operation. 
*After pop, update the min variable.
*
* Time Complexity - O(1) for push, pop, peek, getmin
*Space Complexity - O(2n) ~= O(n)
*/

package Design_One_155_Leetcode_MinStack;

import java.util.Stack;

public class MinStackusingTwoStacks {
    /** initialize your data structure here. */
    Stack<Integer> stack, min_stack;
    public MinStackusingTwoStacks()
    {
        stack = new Stack<Integer>();
        min_stack  = new Stack<Integer>();
        min_stack.push( Integer.MAX_VALUE);
		int min = Integer.MAX_VALUE;
    }

    public void push(int val) //push value and its minimum 
    {
		min = Math.min(min, val);
		stack.push(val);
		min_stack.push(min);
    }

    public void pop()
    {
        stack.pop();
        min_stack.pop();
		min = min_stack.peek();
    }

    public int top()
    {
        return stack.peek();
    }

    public int getMin()
    {
        return min();
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
