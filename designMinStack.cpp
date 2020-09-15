//time complexity:O(1)
//space complexity:O(n)
//executed on leetcode: yes
//approach:using 2 stacks
//any issues faced? no

class MinStack {
public:
    /** initialize your data structure here. */
    stack<int>s1;
    stack<int>s2;
    MinStack() {
        
    }
    
    void push(int x) {
        if(s1.empty())
        {
            s1.push(x);
            s2.push(x);
        }
        else if(x<=s2.top())
        {
            s1.push(x);
            s2.push(x);
        }
        else
        {
            s1.push(x);
        }
    }
    
    void pop() {
        if(s1.top()==s2.top())
        {
            s1.pop();
            s2.pop();
        }
        else
        {
            s1.pop();
        }
    }
    
    int top() {
        return s1.top();
    }
    
    int getMin() {
        return s2.top();
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