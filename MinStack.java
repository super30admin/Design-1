import java.util.ArrayList;
import java.util.Arrays;

public class MinStack {
    private ArrayList <Integer> set;
    public MinStack() {
        set = new ArrayList<>();
    }

    public void push(int val) {
        set.add(val);
    }

    public void pop() {
        if (!set.isEmpty()) {
            set.remove(set.size() - 1);
        }
    }

    public int top() {
        if (!set.isEmpty()) {
            return set.get(set.size() - 1);
        }
        return -1;
    }

    public int getMin() {
        if (!set.isEmpty()) {
            int min = set.get(0);
            for (int value : set) {
                min = Math.min(min, value);
            }
            return min;
        }
        return -1;
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