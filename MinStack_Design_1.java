// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class MinStack() {
    //Stack and min int value
    Stack<Integer> myStack;
    int min;

    public MinStack(){
        //initializing stack and min val = Max valie (Infinity)
        myStack = new Stack();
        min = Integer.MAX_VALUE;
    }

    public void push(int val){
        //if the val to push is less than current minimum, we will push the min value first then assign val to min variable.
        if(val <= min) {
            myStack.push(min);
            min = val;
        }
        //at last we will push the val after checking above cobdition.
        myStack.push(val);
    }

    public void pop(){
        //Check if the value that is popping is equal to min, if equal, pop once more and assign it to min variable as we pushed  current min value when we got new minimum.
        if(min == myStack.pop()) {
            min = myStack.pop();
        }
    }

    public int top(){
        //peek to the top element
        return myStack.peek();
    }

    public int getMin(){
        //return min variable
        return min;
    }
}