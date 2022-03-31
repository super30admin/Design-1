// Time Complexity : Push O(1), Pop O(1) in average case, Pop O(n) in worst case
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class MyQueue {
    private Stack<Integer> inStack, outStack;
    public MyQueue() {
        inStack = new Stack<Integer>();
        outStack = new Stack<Integer>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                int element = inStack.pop();
                outStack.push(element);
            }
        }
        return outStack.pop();
    }

    public int peek() {
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                int element = inStack.pop();
                outStack.push(element);
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.size()==0 && outStack.size()==0;
    }
}
