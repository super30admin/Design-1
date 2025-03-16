// Time Complexity :O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :nope


// Your code here along with comments explaining your approach




import java.util.Stack; // Import statement for Stack class

class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<int[]> minStack = new Stack<>();

    // Constructor to initialize the stack
    public MinStack() {}

    // Push operation: Adds an element to the stack and updates the minimum value
    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x < minStack.peek()[0]) {
            minStack.push(new int[] { x, 1 }); // Push new minimum value with count 1
        } else if (x == minStack.peek()[0]) {
            minStack.peek()[1]++; // Increment the count of the minimum value
        }
    }

    // Pop operation: Removes the top element and updates the minimum value
    public void pop() {
        if (stack.peek().equals(minStack.peek()[0])) {
            minStack.peek()[1]--;
            if (minStack.peek()[1] == 0) {
                minStack.pop(); // Remove minimum if count becomes zero
            }
        }
        stack.pop();
    }

    // Top operation: Returns the top element of the stack
    public int top() {
        return stack.peek();
    }

    // getMin operation: Returns the minimum value in the stack
    public int getMin() {
        return minStack.peek()[0];
    }

    // Test the code
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // Output: -3
        minStack.pop();
        System.out.println(minStack.top());    // Output: 0
        System.out.println(minStack.getMin()); // Output: -2
    }
}
