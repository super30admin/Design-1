// Time Complexity : 0(1) for push(), pop(), top() and getMin() operations
// Space Complexity : O(2n) in the worst case, so O(n) for creating a stack, where n is the number of entries
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class MinStack {
    Stack<Integer> s;
    int min;

    public MinStack() {
        //create a stack
        s = new Stack<>();

        //initialize min to MAX in the beginning
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        //if the value is less than or equal to min value, then push the min value to the stack in addition to pushing the actual value to the stack
        if(val<=min){
            s.push(min);
            min = val;
        }

        //push the value to the stack
        s.push(val);
    }

    public void pop() {
        //if the value equals min value, then pop the min value from the stack in addition to popping the actual value from the stack
        if(min == s.pop()){
            min = s.pop();
        }
    }

    public int top() {
        //return stack top value
        return s.peek();
    }

    public int getMin() {
        //return min value
        return min;
    }
}

