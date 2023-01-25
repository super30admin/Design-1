// Time Complexity : add - O(1), pop - O(1) , getMin - O(1) & top - O(n)
// Space Complexity : O(2n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
/*
 * we define 2 arrays, one to store the elements and the other to store the min values. If we have only 1 element in the stack, then that's the min element. On every push we check if the new
 * value is smaller than the top of the min stack. If true, then we push it in both stacks else we just push the element in the main stack. On getMin we return the element at the top of the min stack.
 * On pop, if the element popped is the top element we pop the element fom the min stack as well.
 */

//https://leetcode.com/problems/min-stack/description/
class MinStack {
    int top;
    int[] minStack = new int[100000];
    int minTop;
    int[] stack = new int[100000];

    public MinStack() {
        top=-1;
        minTop=-1;
    }
    
    public void push(int val) {
        top++;
        stack[top]=val;
        if(top==0){
            minTop++;
            minStack[minTop]=stack[top];
        }else{
            if(minStack[minTop]>=val){
                minTop++;
                minStack[minTop]=val;
            }
        }
    }
    
    public void pop() {
        if(stack[top]==minStack[minTop]){
            minTop--;
        }
        top--;
    }
    
    public int top() {
        return stack[top];
    }
    
    public int getMin() {
        return minStack[minTop];
    }
}