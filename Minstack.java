// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

import java.util.Stack;

public class Minstack {
    Stack<Integer> mainStack;
    Stack<Integer> minStack;
    int min;

    // Declaring and Initializing in the Constructor
    public Minstack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }

    // Comparing and assigning Minimum value of actual minimum value and value
    // passed
    // pushing passed value in main stack and minimum value in min stack
    public void push(int val) {
        min = Math.min(min, val);
        mainStack.push(val);
        minStack.push(min);
    }

    // Popping both the stacks
    // Assigning the minimum value from top of the minimum stack
    public void pop() {
        mainStack.pop();
        minStack.pop();
        min = minStack.peek();
    }

    // displaying the top value from main stack
    public int top() {
        return mainStack.peek();
    }

    // displaying the top value from minimum stack
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
