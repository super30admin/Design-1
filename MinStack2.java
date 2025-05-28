import java.util.Stack;

// Time Complexity:
// push(), pop(), top(), getMin() -> O(1)

// Space Complexity:
// O(n) for maintaining two stacks

public class MinStack2 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack2() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()){
            minStack.push(val);
        } else {
            minStack.push(Math.min(val,minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    // Optional: Print stack for debugging
    public void printStack() {
        System.out.println("Stack values with corresponding mins:");
        for (int i = 0; i < stack.size(); i++) {
            System.out.println("Value: " + stack.get(i) + ", Min so far: " + minStack.get(i));
        }
    }

    public static void main(String[] args) {
        //Your MinStack object will be instantiated and called as such:
        MinStack2 minStack = new MinStack2();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println("After Pushing MinStack : ");
        minStack.printStack();

        System.out.println("get Minimum from Min Stack : " + minStack.getMin()); // return -3

        minStack.pop();
        System.out.println("After Poping MinStack : ");
        minStack.printStack();

        System.out.println("MinStack top element : " + minStack.top()); //returns 0
        System.out.println("MinStack get Min element : " + minStack.getMin()); //return -2
    }
}
