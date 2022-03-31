// Time Complexity : O(1) for push,empty
// O(1) pop,peek- Average time complexity, O(N) amortized time complexity.
// Space Complexity : O(N) asymtotically for both stacks.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach
/*
Used the two stacks approach. One stack is the in stack, where we store all values. whenever a pop operation comes,
 we keep popping from the outstack (populate from instack if empty).
*/
public class QueueUsingStacks {
    Stack<Integer> inStack;
    Stack<Integer> outStack;
    public QueueUsingStacks() {
        inStack= new Stack<>();
        outStack= new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        peek();
        return outStack.pop();
    }

    public int peek() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
