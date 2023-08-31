// Min Stack Using 2 Stacks

// Time Complexity : O(1)
// Space Complexity : O(2n) -> Asymptotically O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/* Algorithm:
1. Maintain 2 stacks:: mainStack and minStack and a variable min
2. Whenever you're doing push operation, push the value into the mainStack and update min and push min to the minStack
3. Whenever you're doing pop operation, pop the value from mainStack and pop the value from minStack
*/
import java.util.*;
class MinStack {
    int min;
    Stack<Integer> s;
    Stack<Integer> minStack;
    public MinStack() {
        s = new Stack<>();
        minStack = new  Stack<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }
    
    public void push(int val) {
        if(val <= min){
            min = val;
        }
        s.push(val);
        minStack.push(min);
    }
    
    public void pop() {
        s.pop();
        minStack.pop();
        min = minStack.peek();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
       return min;
    }
}

// Min Stack using Single Stack

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes - https://leetcode.com/problems/min-stack/submissions/1035633065/
// Any problem you faced while coding this : No

/* Algorithm:
1. Maintain a Stack and a variable min
2. Whenever you're doing push operation, if you update min variable push twice, once the older min value and the current min value
3. Whenever you're doing pop operation, if min value is same as top of the stack then pop the value from mainStack and update the min to current top
*/

class MinStack1{
    Stack<Integer> s;
    int min;
    public MinStack1() {
        s = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(val <= min){
            s.push(min);
            min = val;
        }
        s.push(val);
    }
    
    public void pop() {
        if(min == s.pop()){
            min = s.pop();
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min;
    }
}