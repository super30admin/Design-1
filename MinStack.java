import java.io.*;
import java.util.*;

class MinStack {

    Stack<Integer> s;
    int min;

    public MinStack() {

        s = new Stack<>();
        min = Integer.MAX_VALUE;

    }

    public void push(int val) {

        if (min >= val) {
            s.push(min);
            min = val;
        }
        s.push(val);
    }

    public void pop() {
        int popped = s.pop();

        if (popped == min) {
            min = s.pop();
        }
    }

    public int top() {

        return s.peek();
    }

    public int getMin() {
        return min;

    }

    public static void main(String args[]) {
        MinStack obj = new MinStack();
        obj.push(10);
        obj.push(5);
        obj.push(5);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println(param_3);
        System.out.println(param_4);

    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(val); obj.pop(); int param_3 = obj.top(); int
 * param_4 = obj.getMin();
 */