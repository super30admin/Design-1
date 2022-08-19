import java.util.*;

/*******
Design MinStack (https://leetcode.com/problems/min-stack/)

Time Complexity :   O (1) 
Space Complexity :  O(n) 
Did this code successfully run on Leetcode :    Yes (155. Min Stack)
Any problem you faced while coding this :       No
*******/

class MinStack {
    Stack<int[]> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        // if stack is empty, push {val, val}
        if (st.isEmpty()){
            st.push(new int[]{val, val});
            System.out.println("Pushed element: " + val);
            return;
        }
        // if stack is not empty, push value and min(currentMin and current value)
        int currentMin = st.peek()[1];
        st.push(new int[]{val, Math.min(val, currentMin)});
        System.out.println("Pushed element: " + val);
    }
    
    // if stack is empty, return Stack UnderFlow
    // else pop the top element
    public void pop() {
        if (st.isEmpty()){
            System.out.println("Stack UnderFlow");
        }
        st.pop();
    }
    
    // if stack is empty, return Stack UnderFlow
    // else return the top element
    public int top() {
        if (st.isEmpty()){
            System.out.println("Stack UnderFlow");
            return -1;
        }
        return st.peek()[0];
    }
    
    // if stack is empty, return Stack UnderFlow
    // else min element
    public int getMin() {
        if (st.isEmpty()){
            System.out.println("Stack UnderFlow");
            return -1;
        }
        return st.peek()[1];
    }

    // Driver method to test above 
    public static void main(String args[]) 
    { 
        MinStack obj = new MinStack();
        obj.push(10);
        obj.push(5);
        obj.push(9);
        obj.pop();
        int top = obj.top();
        System.out.println("Top element: " + top);
        int min = obj.getMin();
        System.out.println("Min element: " + min);
    }
}
