// Time Complexity : push-O(1), pop-O(1), top-O(1), getMin-O(1)
// Space Complexity :0(2*30000) or O(2n)->O(n) where n is size of stack
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : during the pop operation I forgot to change the currMin, hence it was failing for
//                                           some test cases. But I figured it out with some print statment and corrected it
class MinStack {
    //2-D array that store our data for stack implementation
    int[][] stack;
    //keep tracks of current global min
    int currMin;
    //keep track of most recently added item
    int top;
   //initializing member variables
    public MinStack() {
        stack = new int[30000][];
        currMin = Integer.MAX_VALUE;
        top = -1;
    }
    //method to push item at the top of stack
    public void push(int val) {
        // index 0 of data stores te stack value
        // index 1 of data stores the current min value
        int[] data = new int[2];
        data[0] = val;
        // find the current min
        currMin = Math.min(val, currMin);
        // update current min
        data[1] = currMin;
        // add item to top
        stack[++top] = data;
    }
    // removes item from the top
    public void pop() {
        //decreaing top
        top--;
        // if stack is empty
        if(top==-1){
            currMin = Integer.MAX_VALUE;
        }// if stack is not empty, update current min
        else{
            currMin = Math.min(stack[top][1], Integer.MAX_VALUE);
        }
    }
    // returns most recently added elements
    public int top() {
        return stack[top][0];
    }
    //returns current min element at stack
    public int getMin() {
        return stack[top][1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */