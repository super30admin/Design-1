class MinStack {
public:
    /** initialize your data structure here. */
    stack<int> s;
    int min = 0;
    MinStack() {
        min = INT_MAX;
    }

    //Time Complexity: O(1)
    //Space Complexity:O(N), where n is the number of inputs.    
    void push(int x) {
        if(x<=min){
          s.push(min);
          s.push(x);
          min = x;
        }
        else{
            s.push(x);
        }
    }
    //Time Complexity: O(1)
    //Space Complexity:O(N), where n is the number of inputs.
    void pop() {
        if(s.top()==min){
            s.pop();
            min = s.top();
            s.pop();
        }
        else{
            s.pop();
        }
    }
    //Time Complexity: O(1)
    //Space Complexity:O(N), where n is the number of inputs.
    int top() {
        return s.top();
    }
    //Time Complexity: O(1)
    //Space Complexity:O(N), where n is the number of inputs.
    int getMin() {
        return min;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */