//time complexity: O(1) for each opration
//space complexity: O(n)
class MinStack {
public:
stack<pair<int,int>> s;

    MinStack() {
        //min=INT_MAX;
    }
    
    void push(int val) {

        if(s.empty())
        {
             s.push({val, val});
        }
       else
       {    
           int min_=min(s.top().second, val);
           s.push({val, min_});
       }
    }
    
    void pop() {

       // if(s.top().first==getMin())
            s.pop();
    }
    
    int top() {
        return s.top().first;
    }
    
    int getMin() {
        return s.top().second;
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