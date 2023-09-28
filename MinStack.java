import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Time Complexity :
 * 
 * push(): O(1)
 * top(): O(1)
 * pop(): O(1)
 * getMin(): O(1)
 */
/**
 * Space Complexity :
 * 
 * push(): O(1)
 * top(): O(1)
 * pop(): O(1)
 * getMin(): O(1)
 */
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : trying to solve the problem in O(1)
// time with O(1) space complexity

// Your code here along with comments explaining your approach
/**
 * Here, the main intent is to find min in O(1), not implementing a stack backed
 * by a dynamic (or static) array => so, just use the in-built Stack class
 * 
 * Pushing is not a problem; Popping is a problem
 * We need to track next min value in the stack before the popped element
 * 
 * So, its better to hold the min value for each pushed element along with it in
 * an Object like Pair {int num; int min}
 * 
 * In this way, we always have the min value for each pushed element in O(1),
 * w/o any need of iterating through the stack again
 */
public class MinStack {

    private class Pair {
        int num;
        int min;

        Pair(int num, int min) {
            this.num = num;
            this.min = min;
        }
    }

    private Deque<Pair> minStack;

    public MinStack() {
        minStack = new ArrayDeque<>();
    }

    public void push(int num) {
        int min;
        if (minStack.isEmpty()) {
            min = num;
        } else {
            min = Math.min(num, minStack.peek().min);
        }
        minStack.push(new Pair(num, min));
    }

    public int top() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek().num;
    }

    public void pop() {
        if (!minStack.isEmpty()) {
            minStack.pop();
        }
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            return -1;
        }
        return minStack.peek().min;
    }
}