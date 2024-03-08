using System;
using System.Collections.Generic;
namespace S30_Solutions
{
    class Program
    {
        static void Main(string[] args)
        {
            MyHashSet obj = new MyHashSet();
            obj.Add(2);
            obj.Remove(2);
            bool param_3 = obj.Contains(2);

            MinStack obj1 = new MinStack();
            obj1.Push(2);
            obj1.Push(1);
            obj1.Pop();
            int param_2 = obj1.Top();
            int param_4 = obj1.GetMin();
        }
    }
    // Consider the total space used as SQRT(Range) + (number of unique second hash values) * SQRT(Range)
    // Therefore the worst case scenario for space will still be the Range itself.
    // However, the time is optimized. All the functions have O(1).
    public class MyHashSet
    {
        bool[][] HashSetValues;

        public MyHashSet()
        {
            HashSetValues = new bool[1000][];
        }

        public int hash1(int key)
        {
            return key % 1000;
        }
        public int hash2(int key)
        {
            return key / 1000;
        }

        public void Add(int key)
        {
            int key1 = hash1(key);
            int key2 = hash2(key);
            int rows = key1 == 0 ? 1001 : 1000;
            if (HashSetValues[key1] == null)
            {
                HashSetValues[key1] = new bool[rows];
            }
            HashSetValues[key1][key2] = true;
        }

        public void Remove(int key)
        {
            int key1 = hash1(key);
            int key2 = hash2(key);
            if (HashSetValues[key1] != null) HashSetValues[key1][key2] = false;
        }

        public bool Contains(int key)
        {
            int key1 = hash1(key);
            int key2 = hash2(key);
            if (HashSetValues[key1] != null) return HashSetValues[key1][key2];
            return false;
        }
    }
    public class MinStack {
        Stack<(int,int)> stack;
        int min;
        public MinStack() {
            stack = new Stack<(int,int)>();
            min = int.MaxValue;
        }
        
        public void Push(int val) {
            min = Math.Min(min,val);
            stack.Push((val,min));
        }
        
        public void Pop() {
            stack.Pop();
            if(stack.Count == 0) min = int.MaxValue;
            else min = GetMin();
        }
        
        public int Top() {
            var (val, minval) = stack.Peek();
            return val;
        }
        
        public int GetMin() {
            var (val, minval) = stack.Peek();
            return minval;
        }
    }
}
