// Time Complexity : O(1)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :YES
// Any problem you faced while coding this :NO


// Your code here along with comments explaining your approach

class MinStack {
public:
    vector<pair<int, int>> s; // Utilize a vector of pairs to maintain the stack with each element and its corresponding minimum value.

    MinStack() { } // Initialize the MinStack.

    void push(int val) {
        if (s.empty())
            s.push_back({val, val}); // If the stack is empty, push the value with itself as the minimum.
        else
            s.push_back({val, min(s.back().second, val)}); // Push the value and update the minimum if necessary.
    }

    void pop() { s.pop_back(); } // Pop the top element from the stack.

    int top() { return s.back().first; } // Retrieve the top element of the stack.

    int getMin() { return s.back().second; } // Retrieve the minimum value in the stack.
};
