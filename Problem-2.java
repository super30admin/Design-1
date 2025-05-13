//Time complexity - 
// push, pop, top, min- O(1)
// Space complexity - O(1)
// Solved in Leetcode - yes
// Did you face any issues while solving - No. But wanted to know should be size of the array to be given for such problems.

//Explaination - top is the variable used to indicated top most element of stack. In the stack variable we are inserting in the order the data is given.
// But in the minStack, initially we are given 1st element, and then whenever we are adding an element checking if it's less than top of minStack, if yes replacing it else - placing the top-1 element in the top.
// This approch will help to always maintain the smallest element in the minStack. 
class MinStack {
    int top;
    int[] stack;
    int[] minStack;

    public MinStack() {
        top =-1;
        stack = new int[100000];
        minStack = new int[100000];
    }
    
    public void push(int val) {
        stack[++top] = val;

       if (top == 0) {
            minStack[top] = val;
        } else {
            minStack[top] = Math.min(val, minStack[top - 1]);
        }
    }
    
    public void pop() {
        if(top == -1) {
            return ;
        }
        --top;
    }
    
    public int top() {
        if(top == -1) {
            return 0;
        }
        return stack[top];
    }
    
    public int getMin() {
        return minStack[top];
    }
}
