//Time Complexity - O(1)
//Space Complexity - average O(n) and wrost case O(2n)

// Implemented MinStack by using Single stack with pushing minimum value to stack along with value and
// during pop removing the minimum value if its equal to popped element.
import java.util.Stack;

class MinStack {
    Stack<Integer> s;
    int min;

    public MinStack() {
        this.s = new Stack<>();
        min = Integer.MAX_VALUE;

    }

    public void push(int val) {
        if(val <= min) {
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
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */