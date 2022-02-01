// Time Complexity O(1)
// Space Complexity O(1)
// Github Run: Runtime: 20 ms, faster than 89.05% of C++ online submissions for Min Stack.
//             Memory Usage: 16.4 MB, less than 67.35% of C++ online submissions for Min Stack.

class MinStack {
public:
    public:
    stack<int> s1;
    stack<int> s2;

    MinStack() {
        }
    
    void push(int x) {
        s1.push(x);
        if(s2.empty())
            s2.push(x);
        else{
            if(x<=s2.top()){
                s2.push(x);
            }
        }
    }
    
    void pop() {
        if(!s1.empty()){
            if(s1.top()==s2.top()) {
                s2.pop();
                s1.pop();
            }else
                s1.pop();
        }
    }
    int top() {
        return s1.top();
    }
    
    int getMin() {
        if(!s2.empty())
            return s2.top();
        else
            return s1.top();
    }
};