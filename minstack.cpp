//TC: O(1)
//SC: O(N)

class MinStack {
public:
    /** initialize your data structure here. */
    stack<int> ms;
    stack<int> s;
    MinStack() {
    }
    
    void push(int x) {
        s.push(x);
        if(ms.empty()||x<=ms.top()){
            ms.push(x);
        }
    }
    
    void pop() {
       if(s.top()==ms.top()){
           ms.pop();
       }
       s.pop();
        
    }
    
    int top() {
        return s.top();
    }
    
    int getMin() {
        return ms.top();
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
