// Time Complexity :O(1)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Did the code after Sowmya explained it class.


// Your code here along with comments explaining your approach

//We can implement this in two stack approach.Though the time complexity is O(1)/Constant , the space complexity is O(2N)->O(N)
//The optimal solution is to do with one stack ,and maintaining min in a variable.

//For every push in the stack, there is two insertion if the value to be inserted in less than the value in min variable
// i.e check if the value to be pushed is less than or equal to min value in the variable.Make sure the min variable is initialized to Integer.Max_VALUE at the constructor .
//if the  value to be pushed in less than min value,then push the  min from variable(Which wil be the previous minimum as we found the new minimum with the new value that came in) to stack (the first push)and replace the current min with new min
//The second push is ,inserting the new value to stack after the previous minimum inserted to stack.If the value is not less than or equal to min,just push it to stack and no need to adjust the min variable.

//For pop,we pop twice if the popped value is equal to the current minimum .
//i.e pop the top ,check if the popped value is equal to current minimum and then pop

//to get the top most of the stack,just peek the stack

//to get the minimun, the variable will have the latest current minimum

class MinStack {

    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private int min;
    public MinStack() {
        stack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if(val <= min){
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        int val = stack.pop();
        if(min == val){
            min = stack.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
