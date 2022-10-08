//Time Complexity: O(1) (as required)
//Space Complexity: O(n) (Additional stack is used)

import java.util.Stack;

class MinStack{
    private Stack<Integer> st;  //Input
    private Stack<Integer> minStack;
    private int min;

    public MinStack{
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
        return min;
    }

    public static void main(String args[]) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // -3
        minStack.pop();
        System.out.println(minStack.top());    // 0
        System.out.println(minStack.getMin()); // -2
        System.out.println();

        MinStack2 mS = new MinStack2();
        mS.push(-2);
        mS.push(0);
        mS.push(-3);
        System.out.println(mS.getMin()); // -3
        mS.pop();
        System.out.println(mS.top());    //  0
        System.out.println(mS.getMin()); // -2
    }
}