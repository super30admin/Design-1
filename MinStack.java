import java.util.Stack;

public class MinStack {
    Stack<Integer> check = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();

    public void push(int x) {
        check.push(x);
        if (min.empty())
        {
            min.push(x);
        } else if (x <= min.peek())
        {
            min.push(x);
        }
    }
    public void pop() {
        int poppedValue = check.pop();
        if (poppedValue == min.peek())
        {
            min.pop();
        }
    }
    public int top()
    {
        return check.peek();
    }
    public int getMin()
    {
        return min.peek();
    }
    public static void main(String args[])
    {
        MinStack obj = new MinStack();
        obj.push(5);
        obj.push(9);
        obj.push(4);
        obj.pop();
        int param_3 = obj.top();
        System.out.println(param_3);
        int param_4 = obj.getMin();
        System.out.println(param_4);
    }
}