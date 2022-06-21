import java.util.Stack;

public class Minstack {
    Stack<Integer> mainStack;
    Stack<Integer> minStack;
    int min;

    public Minstack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }

    public void push(int val) {
        min = Math.min(min, val);
        mainStack.push(val);
        minStack.push(min);
    }

    public void pop() {
        mainStack.pop();
        minStack.pop();
        min = minStack.peek();
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Minstack obj = new Minstack();
        System.out.println("Min Before Intial Push : " + obj.getMin());
        obj.push(5);
        System.out.println("Min After Pushing 5 : " + obj.getMin());
        obj.push(9);
        System.out.println("Min After Pushing 9 : " + obj.getMin());
        obj.push(12);
        System.out.println("Min After Pushing 12 : " + obj.getMin());
        obj.pop();
        obj.push(4);
        System.out.println("Min After Pushing 4 : " + obj.getMin());
        obj.pop();
        obj.top();
        System.out.println("Min After Popping 4 : " + obj.getMin());

    }
}
