import java.util.Stack;

//Time Complexity

// Push: O(1)
// pop: O(1) in best case or on avg case but O(n) in worst case
// peek: O(1) in best case or on avg case but O(n) in worst case

// Space Complexity: O(n)

// Did this code successfully run on Leetcode : Yes
class MyQueue {

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;

    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void push(int x) {
        pushStack.add(x);
    }

    public int pop() {
        if(popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.add(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    public int peek() {
        if(popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.add(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    public boolean empty() {
        return popStack.isEmpty() && pushStack.isEmpty();
    }

    public static void main(String[] args) {

        MyQueue queue = new MyQueue();





        queue.push(1);



        queue.push(2);



        queue.peek();  // returns 1



        queue.pop();   // returns 1



        queue.empty(); // returns false

    }
}
