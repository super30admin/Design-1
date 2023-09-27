    public class MinStack
    {
        // Time Complexity : Push - O(1), Pop - O(1), Top - O(1) and GetMin - O(1)
        // Space Complexity : since we are using 2 stacks- O(N)
        // Did this code successfully run on Leetcode : Yes
        // Any problem you faced while coding this : No

        private Stack<int> stack;
        private Stack<int> minStack;
        private int min;

        public MinStack()
        {
            min = int.MaxValue;
            stack = new Stack<int>();
            minStack = new Stack<int>();
            minStack.Push(min);
        }

        public void Push(int val)
        {
            min = Math.Min(min, val);
            stack.Push(val);
            minStack.Push(min);
        }

        public void Pop()
        {
            stack.Pop();
            minStack.Pop();
            min = minStack.Peek();
        }

        public int Top()
        {
            return stack.Peek();
        }

        public int GetMin()
        {
            return minStack.Peek();
        }
    }
