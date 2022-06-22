/**
 * Time Complexity : O(1)
 * Space Complexity : O(N)
*/

import java.util.*;
class MinStack {
    
    Stack<Integer> st;
    int min; 
    
    public MinStack() {
        st = new Stack<Integer>();
        min = Integer.MAX_VALUE;
        st.push(min);
    }
    
    public void push(int val) {
        if(val<=min){
            st.push(min);
            min = val;
        }
        st.push(val);
    }
    
    public void pop() {
       if(min == st.pop()){
           min =  st.pop();
       }
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack m = new MinStack();
        m.push(5);
        m.push(4);
        m.push(9);
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());
        m.pop();
        System.out.println(m.getMin());

    }
}

