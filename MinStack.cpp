// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach

// I made two vectors to store the values entered by the user , one to store the acctual values and one to store the minimum value at that time 
class MinStack {
public:
vector<int> stack;
vector<int> minStack;
    MinStack() {
        
    }
    
    void push(int val) {
        stack.push_back(val);
        if(minStack.empty()) minStack.push_back(val);
        else if (minStack.back() < val) minStack.push_back(minStack.back());
        else minStack.push_back(val);
    }
    
    void pop() {
        stack.pop_back();
        minStack.pop_back();
    }
    
    int top() {
        return stack.back();
    }
    
    int getMin() {
        return minStack.back();
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
