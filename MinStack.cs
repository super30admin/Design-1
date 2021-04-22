using System;
using System.Collections.Generic;

namespace Algorithms
{
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : Initially before today's class, 
    // I solved this using Dictionary(similar to HashMap in Java). Though I could get 
    // the Time complexity of Push and Pop functions to be O(1)
    // my time complexity went to O(N) for Top() and Get() since I am 
    // trying to find out the Max of all the values in the HashMap everytime before GetMin() or Pop()
    // This solution seemed more efficient, but that solution with HashMap worked on Leetcode too
    // but with less effient space and time management than this one.
    public class MinStack
    {
        /** initialize your data structure here. */
        private Stack<int> originalStack;
        private Stack<int> minStack;
        private int min;

        public MinStack()
        {
            originalStack = new Stack<int>();
            minStack = new Stack<int>();
            min = int.MaxValue;
            minStack.Push(min);
        }

        //Time Complexity - O(1)
        //Space Complexity - O(N)
        public void Push(int val)
        {
            //Every time a value is pushed, compare it with min value
            //And store the corresponding min to minStack and original value to Original Stack
            //So to keep the min element at the top of minStack.
            min = Math.Min(min, val);
            originalStack.Push(val);
            minStack.Push(min);
        }

        //Time Complexity - O(1)
        //Space Complexity - O(N)
        public void Pop()
        {
            originalStack.Pop();
            minStack.Pop();
            min = minStack.Peek(); // This step ensures that our min value getting updated after the original value and corresponding min are popped
        }

        //Time Complexity - O(1)
        //Space Complexity - O(1)
        public int Top()
        {
            return originalStack.Peek();
        }

        //Time Complexity - O(1)
        //Space Complexity - O(1)
        public int GetMin()
        {
            return min;
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.Push(val);
     * obj.Pop();
     * int param_3 = obj.Top();
     * int param_4 = obj.GetMin();
     */
}
