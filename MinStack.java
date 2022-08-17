// Time Complexity : push = O(1); pop = O(1); top = O(1); getMin = O(1)
// Space Complexity : O(n) as extra stack is used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.Stack;

/*solved with two apporaches */

/* Ist Approach => 1:1 MAPPING */

class MinStack {
    private Stack<Integer> st;  // for input
    private Stack<Integer> minStack;    // for storing the minimum for each operation i.e. 1:1 mapping
    private int min;    //minimum

    public MinStack() { //constructor
        this.st = new Stack<>();
        this.minStack = new Stack<>();
        this.min = Integer.MAX_VALUE;
        minStack.push(min);
    }
    
    public void push(int val) {
        min = Math.min(min,val);
        st.push(val);
        minStack.push(min);        
    }
    
    public void pop() {
        st.pop();
        minStack.pop();
        min = minStack.peek();
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minStack.peek(); // or just return min
    }

    public static void main(String args[]) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
        System.out.println();

        MinStack2 mS = new MinStack2();
        mS.push(-2);
        mS.push(0);
        mS.push(-3);
        System.out.println(mS.getMin()); // return -3
        mS.pop();
        System.out.println(mS.top());    // return 0
        System.out.println(mS.getMin()); // return -2
    }
}

/* without using 1:1 mapping */
class MinStack2 {
    int min = Integer.MAX_VALUE;
    Stack<Integer> st = new Stack<Integer>();
    public void push(int val) {
        // only push the old minimum value when the current 
        // minimum value changes AFTER pushing the new value x
        if (min >= val){
            st.push(min);
            min = val;
        }       
        st.push(val);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if (st.pop() == min){
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
