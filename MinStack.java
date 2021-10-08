// Time Complexity :O(N) - Where N is the number of elements - Not sure
// Space Complexity :O(N) - Where N is the number of elements - Not sure

// Did this code successfully run on Leetcode :Yes

// Any problem you faced while coding this :
// 1)Issues with basics like not remebering Integer.MAX_Value.
// 2)Not properly understanding the Time and Space Complexity but considering the stack , it looks like O(N);
// 3)Had to spend a lot of time and needed to take help from discussions.
// 4)Couldn't figure out isFull() method without using array as the DS.


//Question:Design a SplStack that supports all the stack operations push, pop, isEmpty, isFull and an operation getMin() which
// should return minimum element from the SplStack. All these operations must be O(1).
// To implement this, you should only use standard Stack data structure.

// Your code here along with comments explaining your approach
class MinStack {

    //As per question create a SplStack using Stack Data Structure.
    Stack<Integer> stack;
    //Initialize the min variable and give it the Max Value (per leetcode constriants) for comparison with the incoming inputs.
    // This ensures we always get the smallest value in min after comparing.
    int min = Integer.MAX_VALUE;

    //Initialize stack ds in Constructor
    public MinStack() {
        stack =  new Stack<>();
    }

    //Push method for keeping the min value in variable and loading the stack
    public void push(int val) {
        //Check the min value
        if(val<=min){
            //put bigger value in stack
            stack.push(min);
            //Store the smallest value in min variable
            min = val;
        }
        //Push into stack
        stack.push(val);
        System.out.println(stack);
    }

    // Method to pop a value and maintain the min value
    public void pop() {
        //if top of stack is min, store it in min variable else keep popping the stack.
        //When TOS becomes equal to min value, pop the value and store it in min variable to get minof the stack
        if(stack.peek() == min){

            stack.pop();
            min=stack.pop();

        }
        else stack.pop();
    }

    //Standard stack method to get Top Of Stack (TOS)
    public int top() {
        if(stack.isEmpty()){
            return -1;
        }
        return stack.peek();
    }

    //As we already have min variable, we can return that using normal return statement.
    public int getMin() {
        return min;
    }

}
