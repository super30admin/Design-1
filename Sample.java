                                                       //  Design HashSet

// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

// Approach;
// 1. Using linear chaining
// 2. if add() is invoked : if index at primary array is null, create a new array, and then mark true for the index in secondary array.
// 3. If remove() is invoked, check if secondary array is null. if not null, mark the element in secondary array as false.
// 4. If contains() is involved, check if secondary array is null. If this is true, return 0, else return bool value in secondary array

class MyHashSet {

    boolean[][] arr;

    public MyHashSet() {
        arr = new boolean[1001][];
    }
    
    public void add(int key) {
        int horizontalIndex = key % 1000;
        int verticalIndex = key / 1000;

        if(arr[horizontalIndex] == null){
            arr[horizontalIndex] = new boolean[1001];
        }

        arr[horizontalIndex][verticalIndex] = true;
    }
    
    public void remove(int key) {
        int horizontalIndex = key % 1000;
        int verticalIndex = key / 1000;
        if(arr[horizontalIndex] == null)
            return;
        else arr[horizontalIndex][verticalIndex] = false;
    }
    
    public boolean contains(int key) {
        int horizontalIndex = key % 1000;
        int verticalIndex = key / 1000;

        if(arr[horizontalIndex] == null)
            return false;
        else return arr[horizontalIndex][verticalIndex];
    }
}


                                                     // Min Stack

// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Could not pass all test cases when tried myself. Went through notes again, and was able to solve it.


// Your code here along with comments explaining your approach

// Approach;
// 1. Using two stacks. One to store elements, another to keep track of minimum element corresponding to each element.
// 2. if push() is invoked, add element to input stack. if current element is less than current min value, add it to minimum stack.
// 3. if pop() is invoked, pop from both stack and minstack.
// 4. if top() is invoked, remove top element from stack. If getMin() is invoked, return top element from minStack

class MinStack {
    Stack<Integer> stack = new Stack();
    Stack<Integer> minval = new Stack();
    
    public void push(int val) {
        if(minval.isEmpty())
            minval.push(Integer.MAX_VALUE);
        stack.push(val);
        if(val < minval.peek())
            minval.push(val);
        else minval.push(minval.peek());
    }
    
    public void pop() {
        minval.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minval.peek();
    }
}
