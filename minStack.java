import java.util.Stack;

// Time Complexity : For Push = O(1), Pop= O(1), Top = (1), getMin= O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class MinStack {
    Stack <Integer> main = new Stack<>();
    int mini = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int x) {
    /** Checking if the element is less than the our global minimun value.
     * If it is, we will add the minimum value to our Stack and set the current element to the minimum value.
     * and we always push our element to the Stack.
     */
        if(x<=mini){
            main.push(mini);
            mini=x;
        }
        main.push(x);
        
    }
    
    public void pop() {
    /** Pop the top element from the Stack. Check if the element is equal to our global minimum value.
     * if it is equal, than we will pop another element and set that element as your global minimum.
     */
        if(mini == main.pop()){
            mini = main.pop();
        }  
    }
    
    public int top() {
    /** We will run a peek command to find out the top element of the Stack.*/
        return main.peek();
    }
    
    public int getMin() {
    /** We will return our global minimum.*/
        return mini;
    }
}