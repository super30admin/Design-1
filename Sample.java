// Time Complexity :
//For problrm 1 - time complexity : O(1) for all functions
//For problrm 2 - time complexity : O(1) for all functions
// Space Complexity :
//For problrm 1 - space complexity : O(N)
//For problrm 2 - space complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//PROBLEM:1
// class MyHashSet {
//     // We used a boolean array to directly map keys (0 to 1,000,000)
//     // If set[key] == true → the key is present in the set else false
//     boolean[] set;

//     public MyHashSet() {
//         // Initialize a boolean array of size 1,000,001 to cover all possible key values
//         set = new boolean[1000001];
//     }

//     public void add(int key) {
//         // When the key is passed, mark the key as present in the set
//         set[key] = true;
//     }

//     public void remove(int key) {
//         // Mark the key as not present when we try to remove
//         set[key] = false;
//     }

//     public boolean contains(int key) {
//         // Return whether the key is present in the set based on add or remove we have done before
//         return set[key];
//     }
// }

//PROBLEM: 2
import java.util.Stack;

class MinStack {
    // Stack to store the elements
    Stack<Integer> num;

    // Constructor to initialize the stack
    public MinStack() {
        num = new Stack<>();
    }

    // Push a value onto the stack
    public void push(int val) {
        num.push(val);
    }

    // Pop the top value from the stack
    public void pop() {
        num.pop();
    }

    // Return the top value without removing it
    public int top() {
        return num.peek();
    }

    // Return the minimum value in the stack
    public int getMin() {
        // Assume the first element is the minimum
        int min = num.get(0);

        // Traverse the entire stack to find the minimum and replace the min value if i found a minimum value than the existing one 
        for (int i = 1; i < num.size(); i++) {
            if (min > num.get(i)) {
                min = num.get(i);
            }
        }

        return min;
    }
}
