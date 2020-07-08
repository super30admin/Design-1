// Time Complexity :O(1)
// Space Complexity :O(2n) = O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :Approach


// Your code here along with comments explaining your approach
import java.util.Stack;
class MinStack {
    
    // member variables
    Stack<Integer> input;
    // holds min-value and count 
    Stack<int[]> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        input = new Stack<>();
        minStack = new Stack<int[]>();
    }
    
    /** pushing element in stack. */
    public void push(int x) {
        // check for input stack is empty
        // also if current element being pushed is less than peek
        if(input.isEmpty() ||x<minStack.peek()[0])
            minStack.push(new int[] {x, 1});
        // bothe are equal
        else if(x ==minStack.peek()[0])
            minStack.peek()[1]++;    
        input.push(x);
    }
    
    /** poping element in stack. */
    public void pop() {
        System.out.println("Poping: "+ input.peek());
        if(input.pop() == minStack.peek()[0])
            if(minStack.peek()[1]--==1)
                minStack.pop();
    }
    
    /** peek element in stack. */
    public int top() {
        return input.peek();
    }
    
    /** min element in stack. */
    public int getMin() {
        return minStack.peek()[0];
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        int x=2, y=5 , z=1;
        obj.push(x);
        obj.push(y);
        obj.push(z);
        System.out.println("Put: "+x+","+y+", "+ z);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
        System.out.println("Top: "+param_3);
        System.out.println("Minimum: "+param_4);

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