// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :I have confusion for isFull function
// (I have checked whether stack capacity is equal to stack size then I am returning true, but we are adding
//   1 element more than once in case of min. so exactly there are no distinct element capacity number of times)

import java.util.Stack;
/**
 Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(),
 isEmpty(), isFull()and an additional operation getMin() which should return minimum element from
 the SpecialStack. All these operations of SpecialStack must be O(1). To implement SpecialStack,
 you should only use standard Stack data structure and no other data structure like arrays, list, .. etc.
 */

public class MinStack{
    Stack<Integer> stack;
    int min;

    /**
     * Constructor
     */
    public MinStack(){
        stack=new Stack<>();
        min=Integer.MAX_VALUE;
    }

    //Time Complexity:o(1)
    //space complexity:o(1)
    /**
     * To push the value x in minstack
     * @param x
     */
    public void push(int x){
        //if x is less than or equal to min val then x will become min
        if(x<=min){
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    //Time Complexity:o(1)
    //space complexity:o(1)
    /**
     * To pop (remove) the top value form stack
     *
     */
    public void pop(){
        //poped value is min then we need to assign next min value to min
        if(stack.pop()==min){
            min=stack.pop();
        }
    }

    //Time Complexity:o(1)
    //space complexity:o(1)
    /**
     * Return top value of the stack
     *
     */
    public int top(){
        return stack.peek();
    }

    //Time Complexity:o(1)
    //space complexity:o(1)
    /**
     * Return min value of the stack
     */
    public int getMin(){
        return min;
    }

    //Time Complexity:o(1)
    //space complexity:o(1)
    /**
     * Check whether stack is empty
     * @return true if stack is empty else return false
     */
    public boolean isEmpty(){
        return stack.isEmpty();
    }

    //Time Complexity:o(1)
    //space complexity:o(1)
    /**
     * Check whether stack is Full
     * @return true if stack is full else return false
     */
    public boolean isFull(){
        return stack.capacity()==stack.size();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        System.out.println(minStack.isEmpty());//true
        minStack.push(-2);
        minStack.push(0);
        System.out.println(minStack.isEmpty());//false
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
        System.out.println(minStack.isFull());//false
        minStack.push(3);
        minStack.push(9);
        minStack.push(11);
        minStack.push(98);
        minStack.push(-14);
        minStack.push(54);
        System.out.println(minStack.isFull());//true
    }

}

