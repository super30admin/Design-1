// Time Complexity : O(1)
// Space Complexity : O(N) where N are number of elements pushed in the stack.
// Did this code successfully run on Leetcode : Yes with an issue
// Any problem you faced while coding this : When I run my code on leetcode, with min declared as "Integer min;" the testcase fails. Changing it to "int min;" works. What could be the issue? The ranges of int and Integer are same I think. I will upload screenshot to this PR


// Your code here along with comments explaining your approach : Using single stack, pushing previous min in the stack if min changes. And popping twice if min is equal to value popped and setting min to nex pop.

import java.util.Stack;

class MinStack {
    
    Stack<Integer> stack;
    int min;

    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val <= min){
            stack.push(min);
            min = val;
        }
        
        stack.push(val);
    }
    
    public void pop() {
        if(min == stack.pop()){
            min = stack.pop();
        }
         
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }
public static void main(String args[]){
    MinStack obj = new MinStack();
    obj.push(2);
    obj.pop();
    obj.push(1);
    obj.push(3);
    System.out.println(obj.top());
    System.out.println(obj.getMin());
}

}
