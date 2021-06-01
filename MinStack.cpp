// Time Complexity : O(1), since we always access only top element in O(1) for all operations.
// Space Complexity : O(n), we are maintaining 2 stacks each of length n.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

#include<iostream>
#include <bits/stdc++.h>
#include<stack>

using namespace std;

class MinStack {
public:
    stack<int> s1;  /*stack to hold values pushed */
    stack<int> s2;  /* stack to hold minimum value till that point, corresponding to s1*/
    int min;
    /** initialize your data structure here. */
    MinStack() {
        min = INT_MAX;
    }
    
    void push(int val) {
       // cout<< "val: " << val;
        s1.push(val);
        min = std::min(val,min);
        s2.push(min);
      //  cout << "s1:" << s1.top() << ",s2:" << s2.top();
    }
    
    void pop() {
        s1.pop();
        s2.pop();
        if(s2.empty()){
            min = INT_MAX;
        } else {
            min = getMin();
        }
        
    }
    
    int top() {
        return s1.top();
        
    }
    
    int getMin() {
        return s2.top();
    }
    
};

