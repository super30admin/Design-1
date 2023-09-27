// T.C -> O(1)
// S.C -> O(N)

// Does it pass LC: Yes
// I earlier passed 28/31 test case and I am having problem when integer goes out of range. 
// Then I used two Stacks to solve it. 

import java.util.Stack;

public class DesignMinStack {
    private Stack<Integer> stk;
    private Stack<Integer> minStk;

    public DesignMinStack() {
        stk = new Stack<Integer>();
        minStk = new Stack<Integer>();
    }

    public void push(int val) {
        stk.push(val);

        if (minStk.isEmpty()) {
            minStk.push(val);
        } else {
            if (val < minStk.peek()) {
                minStk.push(val);
            } else {
                minStk.push(minStk.peek());
            }
        }

    }

    public void pop() {
        stk.pop();
        minStk.pop();
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return minStk.peek();
    }
}
