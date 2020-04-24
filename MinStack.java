import java.util.Stack;

//Time Complexity : O(1)
//Space Complexity : O(n)
// It did run successfully on Leetcode
// Problems :  if the new element that we are pushing is equal to current minimum, we need to push it twice too

/*
He are maining minimum element with a single stack, We the element that we are pushing is the minimum or
equal to the current minimum, we'll be pushing it twice
 */

public class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> mystack;
    MinStack()
    {
        mystack = new Stack<>();
    }
    public void push(int x) {
        if(x<=min) {
            mystack.push(min);
            min = x;
            mystack.push(x);
        }
        else
            mystack.push(x);
    }
    public void pop() {
        int x = mystack.pop();
        if(x==min)
        {
            int newMin = mystack.pop();
            min = newMin;
        }
    }
    public int top() {
        return mystack.peek();
    }
    public int getMin() {
        return min;
    }
}
