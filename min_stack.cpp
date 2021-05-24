// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No


class MinStack {
    
public:
    stack<pair<int, int>> s;
    MinStack() {
        
    }
    
    void push(int val) {
		// the first entry in the stack the min value will be val only
        if(s.empty()){
            s.push({val, val});
        }
        else{
			// the value will be directly added but for the value of minimum element, compare the current value and top. 
            s.push({val, min(val, s.top().second)});
        }
    }
    
    void pop() {
        s.pop();
    }
    
    int top() {
        return s.top().first;
    }
    
    int getMin() {
        return s.top().second;
    }
};


 // Your MinStack object will be instantiated and called as such:
// MinStack* obj = new MinStack();
// obj->push(val);
// obj->pop();
// int param_3 = obj->top();
// int param_4 = obj->getMin();

