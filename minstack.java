
//time complexity- O(1) for all operations
//space complexity- O(n)
// passed all test cases on leetcode
// I have used a pair structure which stores the value and the current minimum upto the current element .
import java.util.*;
import java.lang.*;

class pair {
    int val;
    int min;

    public pair(int val, int min) {
        this.val = val;
        this.min = min;
    }
}

class minstack {
    Stack st<pair>;

    public minstack() {
        st = new Stack<pair>();
    }

    public void push(int val) {
        int min;
        if (st.size() == 0)
            min = Integer.MAX_VALUE;
        else
            min = st.peek().min;
        min = Math.min(min, val);
        st.push(new pair(val, min));
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek().val;
    }

    public int getMin() {
        return st.peek().min;
    }
}
