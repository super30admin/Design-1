// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack
{
    Stack<ValueMinPair> minStack = new Stack();

    // Class for create an object to store current value & current min value;
    public class ValueMinPair
    {
        int value;
        int min;
        public ValueMinPair(int Value, int minValue)
        {
            this.value = Value;
            this.min = minValue;
        }
    }
    public MinStack(){}

    // Add new element and check for current min while creating a new stack element.
    public void push(int val)
    {
        if (minStack.isEmpty())
            minStack.push(new ValueMinPair(val, val));
        else
            minStack.push(new ValueMinPair(val, Math.min(val, minStack.peek().min)));
    }

    // remove head of the stack
    public void pop()
    {
        minStack.pop();
    }
    // returns top element valuek
    public int top()
    {
        return minStack.peek().value;
    }

    // returns top element min value.
    public int getMin() {
        return minStack.peek().min;
    }

}
