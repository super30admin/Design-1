import java.util.Arrays;

// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//Both codes ran succesfully on Leetcode.

//Q1

//Time and space complexity => O(1)

class MyHashSet {

    boolean[] myHash; // define a boolean array which will fill all spaces with false by default
                      // (java)

    public MyHashSet() {

        this.myHash = new boolean[1000001];

    }

    public void add(int key) {

        myHash[key] = true; // we assign the key with true because we know the key value cannot be greater
                            // than 1000001

    }

    public void remove(int key) {

        myHash[key] = false; // to remove, we just re assign it to false

    }

    public boolean contains(int key) {

        return myHash[key]; // returns true only if value was added to set
    }
}

// Q2

// Time complexity for all is O(1)
// Space complexity for all is O(1)
class MinStack {

    int[] stack; // the original array stack which will be returned
    int[] min_stack; // creating a second array called min stack that will keep note of the minimum
                     // in the array until that point.
    int top; // to keep track of the top of the array

    public MinStack() {

        this.stack = new int[30000];
        this.min_stack = new int[30000];
        Arrays.fill(min_stack, Integer.MAX_VALUE);
        this.top = -1;
    }

    public void push(int val) {

        top += 1;
        stack[top] = val;

        // for min stack, we will take minimum of val and the top of min_stack
        int min_value = 0;

        if (top == 0) {
            min_value = val;
        } else {
            min_value = Math.min(val, min_stack[top - 1]);
        }

        min_stack[top] = min_value;

    }

    public void pop() {

        top -= 1;

    }

    public int top() {
        return stack[top];
    }

    public int getMin() {
        // the top of the min_stack is the minimum in array
        return min_stack[top];
    }
}
