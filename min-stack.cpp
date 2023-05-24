// Time Complexity : O(1)
// Space Complexity : O(n) beacuse we are maintaining another stack for min value
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : figuring out that for O(1) time complexity we need to maintain another stack but not sure if we can do this without using aditional memory.

#include <iostream>
#include <vector>
#include <cmath>
  
using namespace std; 

class MinStack {

public:

    vector<int> stack;
    vector<int> minStack;
    double min;
    

    MinStack() {
        min = pow(2, 32) - 1;
    }
    
    void push(int val) {
        stack.push_back(val);
        if (min > val) {
            minStack.push_back(val);
            min = val;
        } 
        else{
            minStack.push_back(min);
        }
    }
    // we retrive the old min value if the minStack is not empty else we use the standard min value
    void pop() {
        stack.pop_back();
        minStack.pop_back();
        if (minStack.size() < 1){
            min = pow(2, 32) - 1;
        } 
        else{
            min = minStack.back();
        }
        
    }
    
    int top() {
        return (stack.back());
    }
    
    int getMin() {
        return (minStack.back());
    }
};