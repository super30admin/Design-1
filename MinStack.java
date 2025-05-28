import java.util.Stack;

// Time Complexity :
// push(): O(1), pop(): O(1), top(): O(1), getMin(): O(1)

// Space Complexity :
// O(2n), where n is the number of elements in the stack

// Did this code successfully run on Leetcode :
// Yes

// Any problem you faced while coding this :
// No major issues. Concept of storing (value, minSoFar) in a stack was clear.

// Your code here along with comments explaining your approach:
// - This implementation of MinStack uses a custom Pair class to keep track of both the value and the current minimum value in the stack.
// - Every time an element is pushed, we also push the current minimum so far, ensuring that getMin() works in O(1).
// - The top element stores both the value and the corresponding minimum at that point in time.

class MinStack {
    Stack<Pair> s;

    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int val) {
        if(s.isEmpty()) {
            s.push(new Pair(val,val));
        } else {
            int minVal = Math.min(val,s.peek().min);
            s.push(new Pair(val,minVal));
        }
        
    }
    
    public void pop() {
        s.pop();
        
    }
    
    public int top() {
        return s.peek().value;
        
    }
    
    public int getMin() {
        return s.peek().min;
    }

    // Optional: Print stack for debugging
    public void printStack() {
        for (Pair p : s) {
            System.out.println("Value: " + p.value + ", Min so far: " + p.min);
        }
    }

    public static void main(String[] args) {
      //Your MinStack object will be instantiated and called as such:
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println("After Pushing MinStack : ");
        minStack.printStack();

        System.out.println("get Minimum from Min Stack : " + minStack.getMin()); // return -3

        minStack.pop();
        System.out.println("After Poping MinStack : ");
        minStack.printStack();

        System.out.println("MinStack top element : " + minStack.top()); //returns 0
        System.out.println("MinStack get Min element : " + minStack.getMin()); //return -2
    }
}



 class Pair {
    int value;
    int min;

    public Pair(int value, int min) {
        this.value = value;
        this.min = min;
    }
}