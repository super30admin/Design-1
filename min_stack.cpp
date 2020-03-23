// Time Complexity : O(1)

//Requires extra space for the min_stack
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
~


class MinStack {
public:
    /** initialize your data structure here. */
    stack <int> data_set;
    stack <int> min_element_stack;
    
    MinStack() {
  
    }
    
    //two pushes required
    //1. If element is first element or minimum push on min_element_stack
    //2. Push on the real stack
    void push(int x) {
       if(data_set.empty() || x<=min_element_stack.top()){
           min_element_stack.push(x);
       }
        data_set.push(x);
    }
    
    //If data set is empty return
    void pop() {
        if(data_set.empty()){
            return;
        }
        if(!min_element_stack.empty() && data_set.top() == min_element_stack.top()){
            min_element_stack.pop();
        }
        data_set.pop();
        return;
    }
    //Check for emptiness of the stack
    int top() {
       if(data_set.empty()){
            return INT_MIN;
        }
      return data_set.top();   
    }
    //return minimum when the min_stack is not empty
    int getMin() {
        if(!min_element_stack.empty())
           return min_element_stack.top();
        
         return INT_MIN;
    }
};

