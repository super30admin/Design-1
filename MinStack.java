import java.util.Stack;

class MinStack {
    Stack<Integer> st; // Main stack to store elements
    Stack<Integer> minst; // Auxiliary stack to store minimum values
    int min; // Variable to track the current minimum value

    // Constructor to initialize the stack and auxiliary stack
    public MinStack() {
        this.min = Integer.MAX_VALUE; // Initializing minimum value to maximum integer value
        this.st = new Stack<>(); // Initializing the main stack
        this.minst = new Stack<>(); // Initializing the auxiliary stack
        this.minst.push(min); // Pushing the initial minimum value onto the auxiliary stack
    }
    
    // Method to push a new element onto the stack
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public void push(int val) {
        min = Math.min(min, val); // Update the minimum value
        this.minst.push(min); // Push the updated minimum onto the auxiliary stack
        this.st.push(val); // Push the value onto the main stack
    }
    
    // Method to pop the top element from the stack
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public void pop() {
        this.st.pop(); // Pop the top element from the main stack
        this.minst.pop(); // Pop the corresponding minimum value from the auxiliary stack
        min = minst.peek(); // Update the current minimum value
    }
    
    // Method to get the top element of the stack without removing it
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public int top() {
        return this.st.peek(); // Return the top element of the main stack
    }
    
    // Method to get the current minimum value in the stack
    // Time Complexity: O(1)
    // Space Complexity: O(1)
    public int getMin() {
        return this.min; // Return the current minimum value
    }

    // Main method for testing
    public static void main(String[] args) {
        MinStack obj = new MinStack(); // Create a new MinStack object
        obj.push(-2); // Push -2 onto the stack
        obj.push(0); // Push 0 onto the stack
        obj.push(-3); // Push -3 onto the stack
        System.out.println("Minimum element in the stack: " + obj.getMin()); // Output: -3
        obj.pop(); // Pop the top element from the stack
        System.out.println("Top element in the stack: " + obj.top()); // Output: 0
        System.out.println("Minimum element in the stack: " + obj.getMin()); // Output: -2
    }
}
