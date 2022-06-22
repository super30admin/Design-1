// Get the minimum value in a stack.
//Time Complexity: O(1)
//Space Complexity: O(n) 

import java.util.Stack;

public class Problem_155{
    public static void main(String[] args){
        MinStack ms = new MinStack();
        ms.push(10);
        ms.push(20);
        ms.push(30);
        ms.push(0);
        ms.push(12);
        ms.push(-20);
        ms.pop();
        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.top());
        
    }
}

class MinStack {
    int min;
    Stack<Integer> s;

    public MinStack() {
        s = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        //If the value is less or equal to min value then push the min and push the value in both the case.
        if(val <= min){
            s.push(min);
            min = val;
        }
        s.push(val);
    }
    
    public void pop() {
        // If min equals to popped element of stack then pop twice otherwise pop once.
        //(Note : checking the condition is itself popping the element from the original stack.)
        if(min == s.pop()){
            min = s.pop();
        }
    }
    // Gives the peek or top element from the stack.
    public int top() {
        return s.peek();
    }
    // We have maintained min value after the push and pop operations. So just return the min.
    public int getMin() {
        return min;
    }
}