/*
*
* */

public class MinStack {
    Stack<Integer> minStack;
    Stack<Integer> mainStack;
    public MinStack() {

        minStack = new Stack<>();
        mainStack = new Stack<>();
    }


    public void push(int val) {
        mainStack.push(val);
        if (minStack.isEmpty() || minStack.peek() >= val)
        {
            minStack.push(val);
        }


    }

    public void pop() {

        if (!mainStack.isEmpty())
        {
            int currentVal = mainStack.peek();
            if (currentVal == minStack.peek())
            {
                minStack.pop();
            }
            mainStack.pop();
        }
    }

    public int top() {
        int top = mainStack.peek();
        return top;
    }

    public int getMin() {

        int min =  minStack.peek();
        return min;
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