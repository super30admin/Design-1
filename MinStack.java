import java.util.Stack;
// 1st approach is to use 2 Stacks
//2nd approach is to push in minSt only if min value changes
//3rd approach use only one stack
//Time complexity for each function in O(1) and Space complexity is O(n)
public class MinStack {
    // 1st approach is to use 2 Stacks
//2nd approach is to push in minSt only if min value changes
//3rd approach use only one stack
    Stack<Integer> st;
    int min;

    public MinStack() {
        this.min = Integer.MAX_VALUE;
        st = new Stack<>();
    }

    public void push(int val) {
        st.push(min);
        st.push(val);
        min = Math.min(min,val);
    }

    public void pop() {
        st.pop();
        min = st.pop();
    }

    public int top() {
        return st.peek();

    }

    public int getMin() {
        return min;

    }
}
