// for push
// Time Complexity : O(1)
// Space Complexity : O(N)
// for pop and peek
// tc -o(1) and sc - o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : N/A

class MyQueue {

    Stack<Integer> st1 = new Stack();
    Stack<Integer> st2 = new Stack();
    int front;
    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(st1.isEmpty()){
            front = x;
        }
        st1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                // reversing using another st2 from st1
                st2.push(st1.pop());
            }
        }
        return st2.pop();
    }

    /** Get the front element. */
    public int peek() {
        // we are writing this because there might be cases where front might be poped and front is no longer top element
        if(!st2.isEmpty()){
            return st2.peek();
        }
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st1.isEmpty()&&st2.isEmpty();
    }
}

