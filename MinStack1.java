import java.util.Stack;

// In this implementation, I am maintaining a stack which holds integer array. 
// While pushing each element to the stack, we push the current min element at that moment. 
// this way we can get the minimum element in the stack in constant time

// Time Complexity: O(1) for all the operations 

// Space Complexity : O(n)

class MinStack1 {

    Stack<int[]> stack;

    public MinStack1() {
        stack = new Stack<>();
        ;
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new int[] { x, x });
            return;
        }
        int min = Math.min(stack.peek()[1], x);
        stack.push(new int[] { x, min });
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }

    public static void main(String[] args) {
        MinStack1 s1 = new MinStack1();
        s1.push(5);
        s1.push(12);
        System.out.println("Current top of stack : " + s1.top());
        System.out.println("Current min element in the stack : " + s1.getMin());
        s1.push(1);
        s1.push(0);
        s1.pop();
        System.out.println("Current top of stack : " + s1.top());
        System.out.println("Current min element in the stack : " + s1.getMin());
    }
}