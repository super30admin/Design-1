class MinStack {

    private int maxSize; // Maximum size of the stack
    private int[] dataStack; // Array to store the actual elements
    private int[] minStack; // Array to store the minimum elements
    private int top; // Index of the top element in the stack

    public MinStack() {
        maxSize = 5000;
        dataStack = new int[maxSize];
        minStack = new int[maxSize];
        top = -1; // Initialize top to -1, indicating an empty stack
    }

    public void push(int item) {
        if (top == maxSize - 1) {
            // System.out.println("Stack overflow! Cannot push item: " + item);
            return;
        }

        top++;
        dataStack[top] = item; // Insert item into dataStack at the current top index

        if (top == 0 || item <= minStack[top - 1]) {
            minStack[top] = item; // Insert item into minStack only if it's smaller or equal to the current
                                  // minimum
        } else {
            minStack[top] = minStack[top - 1]; // Otherwise, copy the previous minimum into the minStack
        }
        // System.out.println("MinStack Array: " +Arrays.toString(minStack));
    }

    public int pop() {
        if (top == -1) {
            // System.out.println("Stack underflow! Cannot perform pop operation.");
            return -1;
        }

        int poppedItem = dataStack[top]; // Get the top item from the dataStack
        top--; // Decrement top

        return poppedItem;
    }

    public int top() {
        if (top == -1) {
            // System.out.println("Stack is empty. No element to return.");
            return -1;
        }

        return dataStack[top]; // Return the top item from the dataStack
    }

    public int getMin() {
        if (top == -1) {
            // System.out.println("Stack is empty. No minimum element.");
            return -1;
        }

        return minStack[top]; // Return the top item from the minStack, which represents the minimum element
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        // minStack.push(1);

        System.out.println("Minimum element: " + minStack.getMin()); // Output: 1

        minStack.pop();

        System.out.println("Top element: " + minStack.top()); // Output: 7
        System.out.println("Minimum element: " + minStack.getMin()); // Output: 2
    }
}
