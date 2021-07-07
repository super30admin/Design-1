// Time Complexity : push,pop,top and getMin - all functions have O(1) time complexity
// Space Complexity : As we use two stacks, space complexity is O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
// I forgot to set the new globalminimum afer pop operation. Please do not forget to assign global_minimum at each stage


// Your code here along with comments explaining your approach

import java.util.*;
class MinStack {
    Stack<Integer> st = new Stack<>();
    Stack<Integer> minStack = new Stack<>(); //A stack to keep track of the minimum element
    int global_minimum=Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
        minStack.push(global_minimum); //pushing infinity to stack;
    }

    public void push(int x) {
        //if incoming element is lesser than the global minium,set it to minimum
        if(x<global_minimum){
            global_minimum = x;
        }
        //Push data to stack and the minimum element to minStack
        st.push(x);
        minStack.push(global_minimum);

    }

    public void pop() {
        //Pop elements from both stacks
        st.pop();
        minStack.pop();
        //Assign the new global minimum
        global_minimum = minStack.peek();

    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return global_minimum;
    }


}
class Main{
    public static void main(String[] args) {
         MinStack obj = new MinStack();
         obj.push(1000);
         obj.push(20);
         obj.push(100);
         obj.pop();
         int param_3 = obj.top();
         int param_4 = obj.getMin();
         //System.out.println("Min element is "+param_4);
    }
}

