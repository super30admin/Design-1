class MinStack {
public:
    vector<int> v, v2;

    MinStack() {
        
    }
    
    void push(int x) {
        v.push_back(x);
        if(v2.empty() == 1 || x <= v2.back())
            v2.push_back(x);
    }
    
    void pop() {
        if(v.back() == v2.back())
            v2.pop_back();
        v.pop_back();
    }
    
    int top() {
        return v.back();
    }
    
    int getMin() {
        return v2.back();
    }
};
