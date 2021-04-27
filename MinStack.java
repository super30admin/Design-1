package Stack;

import java.util.Stack;

/*-------------------------------------------------------------------------------------------------------
    Time complexity : o(1)   for all operations
    space complexity: o(1)
    Did this code run successfully in leetcode : yes
    problems faces : no
    create two stacks, s1 to keep all the elements, s2 to keep the values every time a new minimu is found.
    for each push operation check if the element is less than the current minimum. the first element in s2 contains most recent minimum element found.
    for each pop operation check if the element is equal to current minimum, if yes them remove that element from both the stacks, if no remove only from s1
    */
public class MinStack {

    Stack<Integer> s1;
    Stack<Integer> s2;

    /** initialize your data structure here. */
    public MinStack() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();

    }

    public void push(int val) {

        s1.push(val);
        if (s2.empty() || val <= s2.peek()) {
            s2.push(val);
        }

    }

    public void pop() {
        if (s1.peek().equals(s2.peek())) {
            s2.pop();
        }
        s1.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }

}
