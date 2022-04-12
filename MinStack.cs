// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, debugged, found the issue and resolved it


// Your code here along with comments explaining your approach
//https://leetcode.com/problems/min-stack/

public class MinStack
    {
        int min;
        Stack<int> stack;
        /** initialize your data structure here. */
        public MinStack()
        {
            min = Int32.MaxValue;
            stack = new Stack<int>();
        }

        public void Push(int x)
        {
            //if value being added is less than min value, then add current min value and new min value
            //so that we can keep track of current and next min value in current stack
            //also updated the min value with new value
            if(x <= min)
            {
                stack.Push(min);
                min = x;
            }
            //add value to stack
            stack.Push(x);
        }

        public void Pop()
        {
            //pop the top value from stack, if it is equal to min, it means, we need to pop next value also in stack
            //this next popped values will be our new minimum, because we are keeping track of ucrrent min and next min
            if(stack.Pop() == min){
                int val = stack.Pop();
                min = val;
            }
        }
    
        //return top value from stack
        public int Top()
        {
            return stack.Peek();
        }

        //return min value
        public int GetMin()
        {
            return min;
        }
    }
