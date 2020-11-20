// Time Complexity: O(1)
// Space Complexity: O(n) for keeping an auxiliary stack to track the minimum element
// LeetCode: Y (https://leetcode.com/problems/min-stack/)
/*
    Approach: 
    Keep two stacks: 
        One Main Stack where push, pop, peek(top) works normally
        Second Stack of int array where 0th element is the minElement and the 1st elemet is the count of the minElement.
        
        Push
            Update the second stack when
                1. If the new element is less than current Min then push a new int[]{minElement, 1}
                2. If the new element is equal to current min then increment the count
            Push x onto the mainStack regardless.  
            
        Pop
            if the element being popped from mainStack is currentMinimum then decrease its count
            If the count of minELement reduces to zero then pop from the minStack
            Pop from the mainStack regardless.
            
        top
            Peek into mainStack
            
        getMin
            get the 0th element from top of minStack array

*/

class MinStack {

    Stack<Integer> mainStack;
    Stack<int[]> minStack;
    
    /** initialize your data structure here. */
    public MinStack() {
        mainStack = new Stack<Integer>();
        minStack = new Stack<int[]>();
    }
    
    public void push(int x) {
        
        /* Push the new Minimum */
        if(minStack.isEmpty() || x < minStack.peek()[0]) {
            minStack.push(new int[]{x, 1});
        }
        /* Update the count of currentMinimum if currentMinimun equals the new number that is being pushed */ 
        else if(x == minStack.peek()[0]) {
            minStack.peek()[1]++;
        }
        
        /* Push on the mainStack */
        mainStack.push(x);
    }
    
    public void pop() {
        /* if the element being popped from mainStack is currentMinimum then decrease its count */
        if(mainStack.peek().equals(minStack.peek()[0])) {
            minStack.peek()[1]--;
        }
        
        /* If the count of minELement reduces to zero then pop from the minStack */
        if(minStack.peek()[1] == 0) {
            minStack.pop();
        }
        
        /* Pop from the mainStack */
        mainStack.pop();
    }
    
    /** Get the top of mainStack */
    public int top() {
        return mainStack.peek();
    }
    
    /** Get the 0th element of top of minStack */
    public int getMin() {
        return minStack.peek()[0];
    }
}
