// Space Complexity: O(n)
// Time Complexity:
// push:O(1)
//pop:O(1) Average case, Worst Case: O(n)
//peek: O(1)
//empty:O(1)


import java.util.Stack;

class MyQueue {

    Stack<Integer> primary;
    Stack<Integer> secondary;

    public MyQueue() {
        primary = new Stack<Integer>();
        secondary = new Stack<Integer>();
    }

    public void push(int x) {
        primary.push(x);

    }

    public int pop() {
        peek();
        return secondary.pop();

    }

    public int peek() {
        if(secondary.isEmpty()){
            while(!primary.isEmpty()){
                secondary.push(primary.pop());
            }
        }
        return secondary.peek();
    }

    public boolean empty() {
        return primary.isEmpty() && secondary.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */