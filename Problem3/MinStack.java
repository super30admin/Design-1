package Problem3;

import java.util.Objects;
import java.util.Stack;

public class MinStack {
    Stack<Integer> stack=new Stack<>();
    Stack<Integer> Minstack=new Stack<>();
    public MinStack() {
    }

    public void push(int val) {
        if (!Minstack.isEmpty() && val<=Minstack.peek()){
            Minstack.push(val);
        }
        else if(Minstack.isEmpty()){
            Minstack.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        if (Objects.equals(stack.peek(), Minstack.peek())){
            Minstack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return Minstack.peek();
    }
}
