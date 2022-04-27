// Time Complexity : O(1) for all operations
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
class MinStack {
public:
    stack<int> s; //stack 1
    stack<int> minStack; //Stack that helps store miminum for the corresponding elem in stack1
    int min = INT_MAX;
    MinStack() {
        minStack.push(min); 
    }
    
  //We push each value in s1 
  //If the new value we are pushing in S1 is the new min, update min and also push into minStack
    void push(int val) {
        s.push(val);
        if(val<min){
            min = val;
        }
        minStack.push(min);
    }
    
  //Remove elements from both stacks and replace min as the new top in minStack
    void pop() {
        s.pop();
        minStack.pop();
        min = minStack.top();
    }
   
  //Return topmost element in stack1
    int top() {
        return s.top();
    }
 
  //We use min variable to keep updating minimum, so return min 
    int getMin() {
        return min;
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
