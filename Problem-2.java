/*
 * Uses two stacks (ArrayLists):
 * 1. stck: stores all values.
 * 2. minStck: tracks current minimums.
 * `min` points to top of minStck, `top` to top of stck.
 * - push: add to stck and update top;
 *   if <= current min, also push to minStck.
 * - pop: if top equals current min, pop from both stacks.
 * - top(): returns top of stck, getMin(): returns top of minStck.
 */

/*
 * Another approach (LinkedList):  uses a linked list where each node stores the value and the minimum at that point.
 * On each push, the new node stores the minimum of(value and the previous node’s min), ensuring constant-time getMin().
 * The head pointer always points to the top of the stack.
 */

// Time Complexity - O(1) - all functions, 
// Space Complexity - O(N) - N-elements to be pushed, also keeping minimum stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MinStack {
    ArrayList<Integer> stck;
    ArrayList<Integer> minStck;
    int min = -1;
    int top = -1;
    public MinStack() {
        stck = new ArrayList<>();
        minStck = new ArrayList<>();
        minStck.add(Integer.MAX_VALUE);
        min++;
    }
    
    public void push(int val) {
        stck.add(val);
        top++;
        if(stck.get(top) <= minStck.get(min)){
            minStck.add(stck.get(top));
            min++;
        }
    }
    
    public void pop() {
        if(minStck.get(min) == stck.get(top)){
            minStck.remove(min);
            min--;
        }
        stck.remove(top);
        top--;
        
    }
    
    public int top() {
        return stck.get(top);
    }
    
    public int getMin() {
        return minStck.get(min);
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
