// Time Complexity : O(1) for push, pop and getMin()
// Space Complexity : O(2n) ------> O(n) as minimum is getting stored 
// Did this code successfully run on Leetcode : Yes

import java.util.Stack;

public class MinStack {
    private Stack<Integer> st;
    private int min;

    public MinStack() {
        st = new Stack<>(); 
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(min >= val)
        {
            st.push(min);
            min = val;
        }
        st.push(val);
    }
    
    public void pop() {
        if(st.pop() == min)
        {
            min = st.pop();
        }
    }
    
    public int top() {
        return st.peek();        
    }
    
    public int getMin() {
        return min;
    }    
}

class Main{
    public static void main(String[] args)
    {
        MinStack ms = new MinStack();
        ms.push(5);
        System.out.println(ms.getMin()); 
        ms.push(9);
        System.out.println(ms.getMin());
        ms.push(4);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
        ms.push(12);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
        ms.push(3);
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
        ms.pop();
        System.out.println(ms.getMin());
    }
}
