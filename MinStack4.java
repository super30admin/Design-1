// Time Comlexity : O(1) for all the operations

// Space Complexity : O(n) in the worst case where the input is in decreasing order and you need to have additional min values for all
// the elements in the stack. 

import java.util.Stack;

public class MinStack4 {

    private Stack<Integer> datastack;
    private int min;

    public MinStack4() {
        datastack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min) {
            datastack.push(x);
            min = x;
        }
        datastack.push(x);
    }

    public void pop() {
        int poppedElem = datastack.pop();
        if (poppedElem == min) {
            min = datastack.pop();
        }
    }

    public int top() {
        return datastack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack1 s4 = new MinStack1();
        s4.push(5);
        s4.push(12);
        System.out.println("Current top of stack : " + s4.top());
        System.out.println("Current min element in the stack : " + s4.getMin());
        s4.push(1);
        s4.push(0);
        s4.pop();
        System.out.println("Current top of stack : " + s4.top());
        System.out.println("Current min element in the stack : " + s4.getMin());
    }
}
