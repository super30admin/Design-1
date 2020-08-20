class MyQueue {
public:
    
    stack<int> s1;
    stack<int> s2;
    
    /** Initialize your data structure here. */
    MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    void push(int x) {
        
        return s1.push(x);
        
    }
    
    /** Removes the element from in front of queue and returns that element. */
    int pop() {
        
        if (s2.empty()) {
            while(!s1.empty()) {
                 int p = s1.top();
                s2.push(p);
                s1.pop();
            }
        }
        
        int val = s2.top();
        s2.pop();
        return val;
        
    }
    
    /** Get the front element. */
    int peek() {
        if(s2.empty())
        {
            while(!s1.empty())
            {   
                int p = s1.top();
                s2.push(p);
                s1.pop();
            }
        }
        
        return s2.top();
        
    }
    
    /** Returns whether the queue is empty. */
    bool empty() {
        
        return s1.empty() && s2.empty();
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */