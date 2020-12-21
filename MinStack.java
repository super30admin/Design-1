import java.util.ArrayList;

// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
class MinStack {
    ArrayList<Node> arr;

    public MinStack() {
        arr = new ArrayList<>();
    }

    // Time Complexity : O(1)
    public void push(int x) {
        int curr_min = Integer.MAX_VALUE;
        if (arr.size() != 0) {
            curr_min = arr.get(arr.size() - 1).curr_min;
        }
        curr_min = Math.min(curr_min, x);
        arr.add(new Node(x, curr_min));
    }

    // Time Complexity : O(1)
    public void pop() {
        arr.remove(arr.size() - 1);
    }

    // Time Complexity : O(1)
    public int top() {
        return arr.get(arr.size() - 1).value;
    }

    // Time Complexity : O(1)
    public int getMin() {
        return arr.get(arr.size() - 1).curr_min;
    }
}

class Node {
    int value;
    int curr_min;

    public Node(int v, int min) {
        value = v;
        curr_min = min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */