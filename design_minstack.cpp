// Time complexity-push -o(1),pop-O(1),top-O(1) getmin=O(1)
// space complexity O(n);
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no

#include<iostream>
using namespace std;
#include<vector>
#include<stack>
#include<limits>

class MinStack {
    stack<int> in_stack;
    stack<int> out_stack;
   
    public:
        /** initialize your data structure here. */
        MinStack() {
          out_stack.push(INT16_MAX);
        }
        
        void push(int val) {
            in_stack.push(val);
            int global_min= min(val,out_stack.top());
            out_stack.push(global_min);
        }
        
        void pop() {
                    in_stack.pop();
                    out_stack.pop();
          
            }
            
        
        
        int top() {
           return in_stack.top();
            
        }
        
        int getMin() {
            return out_stack.top();
        }
};
