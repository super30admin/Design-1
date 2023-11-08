/*The MinStack maintains two stacks (s1 and s2), where s1 stores the actual elements, and s2 keeps track of 
the minimum element encountered so far. This design ensures constant time retrieval of both the top element 
and the minimum element.*/

//Time Complexity: All operations O(1) 
//Space Complexity:  O(N)
#include<bits/stdc++.h>
using namespace std;
class MinStack {
private:
    stack<int>s1;
    stack<int>s2;
public:
    MinStack() {
        
    }
    
    void push(int x) {
        s1.push(x);
        if(s2.empty()||x<=getMin()) s2.push(x);
    }
    
    void pop() {
        if(s1.top()==getMin())s2.pop();
        s1.pop();
    }
    
    int top() {
        return s1.top();
    }
    
    int getMin() {
        return s2.top();
    }
};