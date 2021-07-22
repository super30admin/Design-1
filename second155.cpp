
class MinStack {
public:
    /** initialize your data structure here. */
    stack <int> minstack;
    int min;
    MinStack() {
        min = INT_MAX;
    }
    
    void push(int val) {
        if(val <= min)
        {
            minstack.push(min);
            min = val;
        }
        minstack.push(val);
    }
    
    void pop() {
        int top = minstack.top();
        minstack.pop();
        if(top == min)
        {
            min = minstack.top();
            minstack.pop();
        }
    }
    
    int top() {
        return minstack.top();
    }
    
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
