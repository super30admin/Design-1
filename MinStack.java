/*
Time Complexity - O(1) for all operations
 Space Complexity - O(n) for worst case when all operations are push
 Has it passed all cases on Leetcode - Yes
 */

 /*
    Instead of maintaining two stacks, instead for every element added to the stack, we maintain the corresponding minimum element at that point.
    For every push operation, we push the minimum element so far in the stack along with it. If new value is smaller than existing min,
    reset min. But before that push the previous min to the stack. In case if this value is popped, this has a reference to what is the 
    next min element in the stack.
    During pop, if the min element is popped, reset min to the next minimum element which is usually the next top element added to the stack
*/
public class MinStack {
    Stack<Integer> minStack;
    int minElement;
    public MinStack() {
        this.minStack = new Stack<Integer>();
        this.minElement = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val <= min){
            s.push(min);
            min = val;
        }
        s.push(val);
    }
    
    public void pop() {
        if(minElement == minStack.pop()){
            minElement = minStack.pop();
        }
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        return minElement;
    }
}
