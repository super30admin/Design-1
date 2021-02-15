//TC: O(1) for all operations
//SC: O(n) worst case, if elements are pushed to stack in descending order.

class MinStack {
private:
    vector<int> stack;
    vector<int> min;
public:
    MinStack() {

    }
    
    void push(int x) {
        stack.push_back(x);
        
        if (min.empty() || x <= min.back()) {
            min.push_back(x);
        }
    }

    void pop() {
        if(stack.back() == getMin())
            min.pop_back();
        
        stack.pop_back();
    }

    int top() {
        return stack.back();
    }

    int getMin() {
        return min.back();
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