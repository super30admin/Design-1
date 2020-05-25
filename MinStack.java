// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach


/*
 *MinStack.java
 *
 * Version:
 *     $1$
 *
 * Revisions:
 *     $Log$
 */



/**
 * This program performs all stack operatopn and returm minimum
 * element in O(1)
 *
 * @author Ashwini Jaitapkar
 */
class MinStack {

    //s1 maintains all element
    Stack<Integer> s1 ;
    //s2 maintain min element
    Stack<Integer> s2 ;


    public MinStack() {
        // initialiing two stacks
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /**
     * This function push the element in stack1 and stack2
     *
     *
     * @param x it is an element to be inserted
     *
     */
    public void push(int x) {

        s1.push(x);
        if(s2.empty()){
            s2.push(x);
        }else{
            //check for peek element from s2 to get min element in O(1)
            s2.push(Math.min(s2.peek(),x));
        }
    }
    /**
     * This function pop the element in stack1 and stack2
     *
     */
    public void pop() {
        s1.pop();
        s2.pop();

    }
    /**
     * This function return the top element
     *
     */
    public int top() {
        int topElement = s1.peek();
        return topElement;
    }
    /**
     * This function return the min element
     *
     */
    public int getMin() {
        int minElement = s2.peek();
        return minElement;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

