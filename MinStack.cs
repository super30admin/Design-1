using System;
using System.Collections;
using System.Collections.Generic;

namespace Algorithms
{
    /// Time Complexity : O(1)
    // Space Complexity :O(1)
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  Based on the discussion in class
    public class MinStack
    {
        Stack<int> mainStack;
        Stack<int> minStack;
        int min;

        public MinStack()
        {
            mainStack = new Stack<int>();
            minStack = new Stack<int>();
            min = int.MaxValue;
            minStack.Push(min);
        }
        public void Push(int val)
        {
            mainStack.Push(val);
            min = Math.Min(val, min);
            minStack.Push(min);
        }

        public void Pop()
        {
            mainStack.Pop();
            minStack.Pop();
            min = minStack.Peek();
        }

        public int Top()
        {
            return mainStack.Peek();
        }

        public int GetMin()
        {
            return minStack.Peek();
        }
    }
}
    

