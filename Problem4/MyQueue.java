package Problem4;
//Problem 4 : Implement a HashMap without any built-in libraries.
// leetcode: https://leetcode.com/problems/design-hashmap/
import java.util.Stack;

public class MyQueue {

    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> reverseStack = new Stack<>();
    int x;
    public MyQueue() {
        this.x = 0 ;
        mainStack = new Stack<>();
        reverseStack = new Stack<>();
    }

    public void push(int x) {
        mainStack.push(x);
    }

    public int pop() {
        copystackfromOnetoAnother(mainStack, reverseStack);
        int result = reverseStack.pop();
        copystackfromOnetoAnother(reverseStack, mainStack);
        return result;
    }

    public int peek() {
        copystackfromOnetoAnother(mainStack, reverseStack);
        int result = reverseStack.peek();
        copystackfromOnetoAnother(reverseStack, mainStack);
        return result;
    }
    private void copystackfromOnetoAnother(Stack<Integer> source, Stack<Integer> destination) {
        while (!source.empty()) {
            destination.push(source.pop());
        }
    }
    public boolean empty() {
        return mainStack.empty();
    }
}
