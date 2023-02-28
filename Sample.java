import java.util.Stack;

// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

//Not while coding but I have difficulty figuring out the time complexity in general. 

// Your code here along with comments explaining your approach : 

//This code below sets the value of that key as true. Hence when we want to find if it is contained ,
//we return true as well. Similarly we set it to false in the remove function. So when we call contains on a removed 
//element, it returns false as expected. 

class MyHashSet {
    boolean[] a ;
        public MyHashSet() {
             a = new boolean[1000001];
        }
        
        public void add(int key) {
             a[key] = true;     
        }
        
        public void remove(int key) {
            a[key] = false;
        }
        
        public boolean contains(int key) {
            return a[key];
        }
    }
    
// We are pushing as a pair of values and min 

    class MinStack {
    
        class Pair {
            int i, j;
            public Pair (int i, int j) {
                this.i = i;
                this.j = j;
            }
        }
    
        Stack<Pair> s;
        
        public MinStack() {
            s = new Stack<Pair>();
        }
        
        public void push(int val) {
            if (s.isEmpty()) {
                s.push(new Pair(val, val));
            } else {
                int min = s.peek().j;
                
                if (min > val)
                    min = val;
                
                s.push(new Pair(val, min));
            }
        }
        
        public void pop() {
            s.pop();
        }
        
        public int top() {
           return s.peek().i;
        }
        
        public int getMin() {
            return s.peek().j;
        }
    }